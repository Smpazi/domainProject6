package com.mpazi.controller.medication;

import com.mpazi.domain.medication.Pill;
import com.mpazi.factory.medication.factory.PillFactory;
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
public class PillControllerTest {
    Map<String, String> values;
    private Pill pill;

    @Before
    public void setUp() throws Exception {
        values = new HashMap<>();
        values.put("pill_ID","889");

        this.pill = PillFactory.getPill(values,33);

    }

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/pill";

    @Ignore
    public void testGetAllPill() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetPillById() {
        pill = restTemplate.getForObject(baseURL + "/pill/1", Pill.class);
        System.out.println(pill.getPill_ID());
        assertNotNull(pill);
    }

    @Test
    public void testCreatePill() {
        pill = PillFactory.getPill(values,8);
        ResponseEntity<Pill> postResponse = restTemplate.postForEntity(baseURL + "/create", pill, Pill.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdatePill() {
        int id = 1;
        pill = restTemplate.getForObject(baseURL + "/pill/" + id, Pill.class);

        restTemplate.put(baseURL + "/pill/" + id, pill);
        Pill updatedPill = restTemplate.getForObject(baseURL + "/pill/" + id, Pill.class);
        assertNotNull(updatedPill);
    }

    @Ignore
    public void testDeletePill() {
        int id = 2;
        Pill pill = restTemplate.getForObject(baseURL + "/pill/" + id, Pill.class);
        assertNotNull(pill);
        restTemplate.delete(baseURL + "/pill/" + id);
        try {
            pill = restTemplate.getForObject(baseURL + "/pill/" + id, Pill.class);
        }
        catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}