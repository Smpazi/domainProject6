package com.mpazi.controller.login;

import com.mpazi.domain.login.Registration;
import com.mpazi.factory.login.factory.RegistrationFactory;
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
public class RegistrationControllerTest {

    Map<String, String> values;
    private Registration registration;

    @Before
    public void setUp() throws Exception {
        values = new HashMap<>();
        values.put("Reg_ID","AS322");
        values.put("StaffName","Dr. LEXIS");
        this.registration = RegistrationFactory.getRegistration(values);

    }
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/registration";

    @Ignore
    public void testGetAllRegistration() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetRegistrationById() {
        registration = restTemplate.getForObject(baseURL + "/registration/1", Registration.class);
        System.out.println(registration.getReg_Id());
        assertNotNull(registration);
    }

    @Test
    public void testCreateRegistration() {
        registration = RegistrationFactory.getRegistration(values);
        ResponseEntity<Registration> postResponse = restTemplate.postForEntity(baseURL + "/create", registration, Registration.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateRegistration() {
        int id = 1;
        registration = restTemplate.getForObject(baseURL + "/registration/" + id, Registration.class);

        restTemplate.put(baseURL + "/registration/" + id, registration);
        Registration updatedRegistration = restTemplate.getForObject(baseURL + "/registration/" + id, Registration.class);
        assertNotNull(updatedRegistration);
    }

    @Ignore
    public void testDeleteAppointment() {
        int id = 2;
        Registration registration = restTemplate.getForObject(baseURL + "/registration/" + id, Registration.class);
        assertNotNull(registration);
        restTemplate.delete(baseURL + "/registration/" + id);
        try {
            registration = restTemplate.getForObject(baseURL + "/registration/" + id, Registration.class);
        }
        catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}