package com.mpazi.controller.information;

import com.mpazi.domain.information.MedicalHistory;
import com.mpazi.factory.information.factory.MedicalHistoryFactory;
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
import static org.junit.Assert.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class MedicalHistoryControllerTest {

    Map<String, String> values;
    private MedicalHistory medicalHistory;

    @Before
    public void setUp() throws Exception {
        values = new HashMap<>();
        values.put("MedHistory_ID","7676");
        values.put("Cronical_Desease","Cancer");


        this.medicalHistory = MedicalHistoryFactory.getMedicalHistory(values);

    }
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/medicalHistory";

    @Test
    public void testGetAllMedicalHistory() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetMedicalHistoryById() {
        medicalHistory = restTemplate.getForObject(baseURL + "/medicalHistory/1", MedicalHistory.class);
        System.out.println(medicalHistory.getMedHistory_ID());
        assertNotNull(medicalHistory);
    }

    @Test
    public void testCreateMedicalHistory() {
        medicalHistory = MedicalHistoryFactory.getMedicalHistory(values);
        ResponseEntity<MedicalHistory> postResponse = restTemplate.postForEntity(baseURL + "/create", medicalHistory, MedicalHistory.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateMedicalHistory() {
        int id = 1;
        medicalHistory = restTemplate.getForObject(baseURL + "/medicalHistory/" + id, MedicalHistory.class);

        restTemplate.put(baseURL + "/medicalHistory/" + id, medicalHistory);
        MedicalHistory updatedMedicalHistory = restTemplate.getForObject(baseURL + "/medicalHistory/" + id, MedicalHistory.class);
        assertNotNull(updatedMedicalHistory);
    }

    @Test
    public void testDeleteMedicalHistory() {
        int id = 2;
        MedicalHistory medicalHistory = restTemplate.getForObject(baseURL + "/medicalHistory/" + id, MedicalHistory.class);
        assertNotNull(medicalHistory);
        restTemplate.delete(baseURL + "/medicalHistory/" + id);
        try {
            medicalHistory = restTemplate.getForObject(baseURL + "/medicalHistory/" + id, MedicalHistory.class);
        }
        catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}