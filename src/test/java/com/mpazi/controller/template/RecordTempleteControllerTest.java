package com.mpazi.controller.template;

import com.mpazi.domain.template.RecordTemplete;
import com.mpazi.factory.template.factory.RecordTempleteFactory;
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
public class RecordTempleteControllerTest {

    Map<String, String> values;
    private RecordTemplete recordTemplete;

    @Before
    public void setUp() throws Exception {
        values = new HashMap<>();
        values.put("Template_ID","ac33");

        this.recordTemplete = RecordTempleteFactory.getRecordTemplete(values,7);

    }
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/recordTemplete";

    @Ignore
    public void testGetAllRecordTemplete() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetRecordTempleteById() {
        recordTemplete = restTemplate.getForObject(baseURL + "/recordTemplete/1", RecordTemplete.class);
        System.out.println(recordTemplete.getTempleteId());
        assertNotNull(recordTemplete);
    }

    @Test
    public void testCreateRecordTemplete() {
        recordTemplete = RecordTempleteFactory.getRecordTemplete(values,7);
        ResponseEntity<RecordTemplete> postResponse = restTemplate.postForEntity(baseURL + "/create", recordTemplete, RecordTemplete.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateRecordTemplete() {
        int id = 1;
        recordTemplete = restTemplate.getForObject(baseURL + "/recordTemplete/" + id, RecordTemplete.class);

        restTemplate.put(baseURL + "/recordTemplete/" + id, recordTemplete);
        RecordTemplete updatedRecordTemplete = restTemplate.getForObject(baseURL + "/recordTemplete/" + id, RecordTemplete.class);
        assertNotNull(updatedRecordTemplete);
    }

    @Ignore
    public void testDeleteRecordTemplete() {
        int id = 2;
        RecordTemplete recordTemplete = restTemplate.getForObject(baseURL + "/recordTemplete/" + id, RecordTemplete.class);
        assertNotNull(recordTemplete);
        restTemplate.delete(baseURL + "/recordTemplete/" + id);
        try {
            recordTemplete = restTemplate.getForObject(baseURL + "/recordTemplete/" + id, RecordTemplete.class);
        }
        catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}