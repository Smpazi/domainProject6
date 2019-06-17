package com.mpazi.controller.information;

import com.mpazi.domain.information.Patient;
import com.mpazi.factory.information.factory.PatientFactory;
import com.mpazi.repository.information.PatientRepository;
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
public class PatientControllerTest {
    Map<String,String> values;
    private Patient patient;
    @Before
    public void setUp() throws Exception {
        values = new HashMap<>();
        values.put("patientId","333A");
        values.put("patientName","Salomi");

        this.patient = PatientFactory.getPatient(values,24);

    }

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/patient";

    @Test
    public void testGetAllPatient() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetPatientById() {
        patient = restTemplate.getForObject(baseURL + "/patient/1", Patient.class);
        System.out.println(patient.getPatientId());
        assertNotNull(patient);
    }

    @Test
    public void testCreatePatient() {
        patient = PatientFactory.getPatient(values,9);
        ResponseEntity<Patient> postResponse = restTemplate.postForEntity(baseURL + "/create", patient, Patient.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdatePatient() {
        int id = 1;
        patient = restTemplate.getForObject(baseURL + "/patient/" + id, Patient.class);

        restTemplate.put(baseURL + "/patient/" + id, patient);
        Patient updatedPatient = restTemplate.getForObject(baseURL + "/patient/" + id, Patient.class);
        assertNotNull(updatedPatient);
    }

    @Test
    public void testDeletePatient() {
        int id = 2;
        Patient patient = restTemplate.getForObject(baseURL + "/patient/" + id, Patient.class);
        assertNotNull(patient);
        restTemplate.delete(baseURL + "/patient/" + id);
        try {
            patient = restTemplate.getForObject(baseURL + "/patient/" + id, Patient.class);
        }
        catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}