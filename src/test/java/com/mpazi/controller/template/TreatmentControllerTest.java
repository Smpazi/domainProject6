package com.mpazi.controller.template;

import com.mpazi.domain.template.Treatment;
import com.mpazi.factory.template.factory.TreatmentFactory;
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
public class TreatmentControllerTest {

    Map<String,String> values;
    Treatment treatment;
    @Before
    public void setUp() throws Exception {
        values = new HashMap<>();
        values.put("treatment_ID","3245");

        this.treatment = TreatmentFactory.getTreatment(values,8);

    }
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/treatment";

    @Ignore
    public void testGetAllTreatment() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetTreatmentById() {
        treatment = restTemplate.getForObject(baseURL + "/treatment/1", Treatment.class);
        System.out.println(treatment.getTreatment_ID());
        assertNotNull(treatment);
    }

    @Test
    public void testCreateTreatment() {
        treatment = TreatmentFactory.getTreatment(values,7);
        ResponseEntity<Treatment> postResponse = restTemplate.postForEntity(baseURL + "/create", treatment, Treatment.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateTreatment() {
        int id = 1;
        treatment = restTemplate.getForObject(baseURL + "/treatment/" + id, Treatment.class);

        restTemplate.put(baseURL + "/treatment/" + id, treatment);
        Treatment updatedTreatment = restTemplate.getForObject(baseURL + "/treatment/" + id, Treatment.class);
        assertNotNull(updatedTreatment);
    }

    @Ignore
    public void testDeleteTreatment() {
        int id = 2;
        Treatment treatment = restTemplate.getForObject(baseURL + "/treatment/" + id, Treatment.class);
        assertNotNull(treatment);
        restTemplate.delete(baseURL + "/treatment/" + id);
        try {
            treatment = restTemplate.getForObject(baseURL + "/treatment/" + id, Treatment.class);
        }
        catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}