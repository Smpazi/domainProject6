package com.mpazi.controller.medication;

import com.mpazi.domain.medication.Medication;
import com.mpazi.factory.medication.factory.MedicationFactory;
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
public class MedicationControllerTest {

    Map<String, String> values;
    private Medication medication;

    @Before
    public void setUp() throws Exception {
        values = new HashMap<>();
        values.put("Med_ID","AB222");
        values.put("Medication_Name","Flutex");

        this.medication = MedicationFactory.getMedication(values);

    }
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/medication";

    @Ignore
    public void testGetAllMedication() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetMedicationById() {
        medication = restTemplate.getForObject(baseURL + "/medication/1", Medication.class);
        System.out.println(medication.getMed_Id());
        assertNotNull(medication);
    }

    @Test
    public void testCreateMedication() {
        medication = MedicationFactory.getMedication(values);
        ResponseEntity<Medication> postResponse = restTemplate.postForEntity(baseURL + "/create", medication, Medication.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateMedication() {
        int id = 1;
        medication = restTemplate.getForObject(baseURL + "/medication/" + id, Medication.class);

        restTemplate.put(baseURL + "/medication/" + id, medication);
        Medication updatedMedication = restTemplate.getForObject(baseURL + "/medication/" + id, Medication.class);
        assertNotNull(updatedMedication);
    }

    @Ignore
    public void testDeleteMedication() {
        int id = 2;
        Medication medication = restTemplate.getForObject(baseURL + "/medication/" + id, Medication.class);
        assertNotNull(medication);
        restTemplate.delete(baseURL + "/medication/" + id);
        try {
            medication = restTemplate.getForObject(baseURL + "/medication/" + id, Medication.class);
        }
        catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}