package com.mpazi.controller.information;

import com.mpazi.domain.information.Consultation;
import com.mpazi.factory.information.factory.ConsultationFactory;
import com.mpazi.repository.information.ConsultationRepository;
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
public class ConsultationControllerTest {
    Map<String, String> values;
    private Consultation consultation;

    @Before
    public void setUp() throws Exception {
        values = new HashMap<>();
        values.put("Consultation_Description","illness");

        this.consultation = ConsultationFactory.getConsultation(values);

    }
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/consultation";

    @Ignore
    public void testGetAllConsultation() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetConsultationById() {
        consultation = restTemplate.getForObject(baseURL + "/consultation/1", Consultation.class);
        System.out.println(consultation.getConsult_description());
        assertNotNull(consultation);
    }

    @Test
    public void testCreateConsultation() {
        consultation = ConsultationFactory.getConsultation(values);
        ResponseEntity<Consultation> postResponse = restTemplate.postForEntity(baseURL + "/create", consultation, Consultation.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateConsultation() {
        int id = 1;
        consultation = restTemplate.getForObject(baseURL + "/consultation/" + id, Consultation.class);

        restTemplate.put(baseURL + "/consultation/" + id, consultation);
        Consultation updatedConsultation = restTemplate.getForObject(baseURL + "/consultation/" + id, Consultation.class);
        assertNotNull(updatedConsultation);
    }

    @Ignore
    public void testDeleteConsultation() {
        int id = 2;
        Consultation consultation = restTemplate.getForObject(baseURL + "/consultation/" + id, Consultation.class);
        assertNotNull(consultation);
        restTemplate.delete(baseURL + "/consultation/" + id);
        try {
            consultation = restTemplate.getForObject(baseURL + "/consultation/" + id, Consultation.class);
        }
        catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}