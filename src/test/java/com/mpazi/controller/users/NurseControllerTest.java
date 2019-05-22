package com.mpazi.controller.users;

import com.mpazi.domain.users.Nurse;
import com.mpazi.factory.users.factory.NurseFactory;
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
public class NurseControllerTest {

    Map<String, String> values;
    private Nurse nurse;

    @Before
    public void setUp() throws Exception {
        values = new HashMap<>();

        this.nurse = NurseFactory.getNurse("BabiesDepartment");

    }
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/nurse";

    @Ignore
    public void testGetAllNurse() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetNurseById() {
        nurse = restTemplate.getForObject(baseURL + "/nurse/1", Nurse.class);
        System.out.println(nurse.getNursing_Department());
        assertNotNull(nurse);
    }

    @Test
    public void testCreateNurse() {
        nurse = NurseFactory.getNurse("BabiesDepartment");
        ResponseEntity<Nurse> postResponse = restTemplate.postForEntity(baseURL + "/create", nurse, Nurse.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateNurse() {
        int id = 1;
        nurse = restTemplate.getForObject(baseURL + "/nurse/" + id, Nurse.class);

        restTemplate.put(baseURL + "/nurse/" + id, nurse);
        Nurse updatedNurse = restTemplate.getForObject(baseURL + "/nurse/" + id, Nurse.class);
        assertNotNull(updatedNurse);
    }

    @Ignore
    public void testDeleteNurse() {
        int id = 2;
        Nurse nurse = restTemplate.getForObject(baseURL + "/nurse/" + id, Nurse.class);
        assertNotNull(nurse);
        restTemplate.delete(baseURL + "/nurse/" + id);
        try {
            nurse = restTemplate.getForObject(baseURL + "/nurse/" + id, Nurse.class);
        }
        catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}