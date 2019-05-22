package com.mpazi.controller.users;

import com.mpazi.domain.users.Doctor;
import com.mpazi.factory.users.factory.DoctorFactory;
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
public class DoctorControllerTest {

    Map<String, String> values;
    private Doctor doctor;

    @Before
    public void setUp() throws Exception {
        values = new HashMap<>();

        this.doctor = DoctorFactory.getDoctor("34444");

    }
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/doctor";

    @Ignore
    public void testGetAllDoctor() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetDoctorById() {
        doctor = restTemplate.getForObject(baseURL + "/doctor/1", Doctor.class);
        System.out.println(doctor.getDoc_practiceNum());
        assertNotNull(doctor);
    }

    @Test
    public void testCreateDoctor() {
        doctor = DoctorFactory.getDoctor("");
        ResponseEntity<Doctor> postResponse = restTemplate.postForEntity(baseURL + "/create", doctor, Doctor.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateDoctor() {
        int id = 1;
        doctor = restTemplate.getForObject(baseURL + "/doctor/" + id, Doctor.class);

        restTemplate.put(baseURL + "/doctor/" + id, doctor);
        Doctor updatedDoctor= restTemplate.getForObject(baseURL + "/doctor/" + id, Doctor.class);
        assertNotNull(updatedDoctor);
    }

    @Ignore
    public void testDeleteDoctor() {
        int id = 2;
        Doctor doctor = restTemplate.getForObject(baseURL + "/doctor/" + id, Doctor.class);
        assertNotNull(doctor);
        restTemplate.delete(baseURL + "/doctor/" + id);
        try {
            doctor = restTemplate.getForObject(baseURL + "/doctor/" + id, Doctor.class);
        }
        catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}