package com.mpazi.controller.users;

import com.mpazi.domain.users.Receptionist;
import com.mpazi.factory.users.factory.ReceptionistFactory;
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
public class ReceptionistControllerTest {

    Map<String, String> values;
    private Receptionist receptionist;

    @Before
    public void setUp() throws Exception {
        values = new HashMap<>();
        this.receptionist = ReceptionistFactory.getReceptionist("");

    }

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/receptionist";

    @Ignore
    public void testGetAllReceptionist() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetReceptionistById() {
        receptionist = restTemplate.getForObject(baseURL + "/receptionist/1", Receptionist.class);
        System.out.println(receptionist.getJob_type());
        assertNotNull(receptionist);
    }

    @Test
    public void testCreateReceptionist() {
        receptionist = ReceptionistFactory.getReceptionist("");
        ResponseEntity<Receptionist> postResponse = restTemplate.postForEntity(baseURL + "/create", receptionist, Receptionist.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateReceptionist() {
        int id = 1;
        receptionist = restTemplate.getForObject(baseURL + "/receptionist/" + id, Receptionist.class);

        restTemplate.put(baseURL + "/receptionist/" + id, receptionist);
        Receptionist updatedReceptionist = restTemplate.getForObject(baseURL + "/receptionist/" + id, Receptionist.class);
        assertNotNull(updatedReceptionist);
    }

    @Ignore
    public void testDeleteReceptionist() {
        int id = 2;
        Receptionist receptionist = restTemplate.getForObject(baseURL + "/receptionist/" + id, Receptionist.class);
        assertNotNull(receptionist);
        restTemplate.delete(baseURL + "/appointment/" + id);
        try {
            receptionist = restTemplate.getForObject(baseURL + "/receptionist/" + id, Receptionist.class);
        }
        catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}