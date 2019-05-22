package com.mpazi.controller.medication;

import com.mpazi.domain.medication.DrugPrescription;
import com.mpazi.factory.medication.factory.DrugPrescriptionFactory;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class DrugPrescriptionControllerTest {

    Map<String,String> values;

   private DrugPrescription drugPrescription;
    @Before
    public void setUp() throws Exception {
        values = new HashMap<>();
        values.put("drug_prescriptionId","3245");
        values.put("drugName","Panado");

        this.drugPrescription = DrugPrescriptionFactory.getDrugPrescription(values,"Headache");

    }

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/drugPrescription";

    @Ignore
    public void testGetAllDrugPrescription() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetDrugPrescriptionById() {
        drugPrescription = restTemplate.getForObject(baseURL + "/drugPrescription/1", DrugPrescription.class);
        System.out.println(drugPrescription.getDrug_prescriptionId());
        assertNotNull(drugPrescription);
    }

    @Test
    public void testCreateDrugPrescription() {
        drugPrescription = DrugPrescriptionFactory.getDrugPrescription(values,"");
        ResponseEntity<DrugPrescription> postResponse = restTemplate.postForEntity(baseURL + "/create", drugPrescription, DrugPrescription.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateDrugPrescription() {
        int id = 1;
        drugPrescription = restTemplate.getForObject(baseURL + "/drugPrescription/" + id, DrugPrescription.class);

        restTemplate.put(baseURL + "/drugPrescription/" + id, drugPrescription);
        DrugPrescription updatedDrugPrescription = restTemplate.getForObject(baseURL + "/drugPrescription/" + id, DrugPrescription.class);
        assertNotNull(updatedDrugPrescription);
    }

    @Ignore
    public void testDeleteDrugPrescription() {
        int id = 2;
        DrugPrescription drugPrescription = restTemplate.getForObject(baseURL + "/drugPrescription/" + id, DrugPrescription.class);
        assertNotNull(drugPrescription);
        restTemplate.delete(baseURL + "/drugPrescription/" + id);
        try {
            drugPrescription = restTemplate.getForObject(baseURL + "/drugPrescription/" + id, DrugPrescription.class);
        }
        catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}