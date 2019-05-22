package com.mpazi.controller.medication;

import com.mpazi.domain.medication.Medicine;
import com.mpazi.factory.medication.factory.MedicineFactory;
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
@SpringBootTest
@RunWith(SpringRunner.class)
public class MedicineControllerTest {

    Map<String, String> values;
    private Medicine medicine;

    @Before
    public void setUp() throws Exception {
        values = new HashMap<>();
        values.put("Med_ID","8989");
        values.put("Medicine_CreatedAt","Clicks pharmacy");
        values.put("Medicine_GenricName","MistAlba");
        this.medicine = MedicineFactory.getMedicine(values);

    }

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/medicine";

    @Ignore
    public void testGetAllMedicine() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetMedicineById() {
        medicine = restTemplate.getForObject(baseURL + "/medicine/1", Medicine.class);
        System.out.println(medicine.getMed_Id());
        assertNotNull(medicine);
    }

    @Test
    public void testCreateMedicine() {
        medicine = MedicineFactory.getMedicine(values);
        ResponseEntity<Medicine> postResponse = restTemplate.postForEntity(baseURL + "/create", medicine, Medicine.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateMedicine() {
        int id = 1;
        medicine = restTemplate.getForObject(baseURL + "/medicine/" + id, Medicine.class);

        restTemplate.put(baseURL + "/medicine/" + id, medicine);
        Medicine updatedMedicine = restTemplate.getForObject(baseURL + "/medicine/" + id, Medicine.class);
        assertNotNull(updatedMedicine);
    }

    @Ignore
    public void testDeleteMedicine() {
        int id = 2;
        Medicine medicine = restTemplate.getForObject(baseURL + "/medicine/" + id, Medicine.class);
        assertNotNull(medicine);
        restTemplate.delete(baseURL + "/medicine/" + id);
        try {
            medicine = restTemplate.getForObject(baseURL + "/medicine/" + id, Medicine.class);
        }
        catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}