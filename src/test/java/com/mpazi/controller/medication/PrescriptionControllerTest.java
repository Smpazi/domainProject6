package com.mpazi.controller.medication;

import com.mpazi.domain.medication.Prescription;
import com.mpazi.factory.medication.factory.PrescriptionFactory;
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
public class PrescriptionControllerTest {

    Map<String, String> values;
    private Prescription prescription;

    @Before
    public void setUp() throws Exception {
        values = new HashMap<>();
        values.put("Prescription_ID","pre444");
        values.put("VisitTime","10:20:00");

        this.prescription = PrescriptionFactory.getPrescription(values);

    }

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/prescription";

    @Ignore
    public void testGetAllPrescription() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetPrescriptionById() {
        prescription = restTemplate.getForObject(baseURL + "/prescription/1", Prescription.class);
        System.out.println(prescription.getPrescriptionId());
        assertNotNull(prescription);
    }

    @Test
    public void testCreatePrescription() {
        prescription = PrescriptionFactory.getPrescription(values);
        ResponseEntity<Prescription> postResponse = restTemplate.postForEntity(baseURL + "/create", prescription, Prescription.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdatePrescription() {
        int id = 1;
        prescription = restTemplate.getForObject(baseURL + "/prescription/" + id, Prescription.class);

        restTemplate.put(baseURL + "/prescription/" + id, prescription);
        Prescription updatedPrescription = restTemplate.getForObject(baseURL + "/prescription/" + id, Prescription.class);
        assertNotNull(updatedPrescription);
    }

    @Ignore
    public void testDeletePrescription() {
        int id = 2;
        Prescription prescription = restTemplate.getForObject(baseURL + "/prescription/" + id, Prescription.class);
        assertNotNull(prescription);
        restTemplate.delete(baseURL + "/prescription/" + id);
        try {
            prescription = restTemplate.getForObject(baseURL + "/prescription/" + id, Prescription.class);
        }
        catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}