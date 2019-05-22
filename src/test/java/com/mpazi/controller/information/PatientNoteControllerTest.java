package com.mpazi.controller.information;

import com.mpazi.domain.information.PatientNote;
import com.mpazi.factory.information.factory.PatientNoteFactory;
import com.mpazi.repository.information.PatientNoteRepository;
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
public class PatientNoteControllerTest {

    Map<String, String> values;
    private PatientNote patientNote;

    @Before
    public void setUp() throws Exception {
        values = new HashMap<>();
        values.put("PatientNote_Id","AZ21");
        values.put("PatientNoteType","AddMedication");

        this.patientNote = PatientNoteFactory.getPatientNote(values);

    }
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/patientNote";

    @Ignore
    public void testGetAllPatientNote() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetPatientNoteById() {
        patientNote = restTemplate.getForObject(baseURL + "/patientNote/1", PatientNote.class);
        System.out.println(patientNote.getPatientNoteId());
        assertNotNull(patientNote);
    }

    @Test
    public void testCreatePatientNote() {
        patientNote =PatientNoteFactory.getPatientNote(values);
        ResponseEntity<PatientNote> postResponse = restTemplate.postForEntity(baseURL + "/create", patientNote, PatientNote.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdatePatientNote() {
        int id = 1;
        patientNote = restTemplate.getForObject(baseURL + "/patientNote/" + id, PatientNote.class);

        restTemplate.put(baseURL + "/patientNote/" + id, patientNote);
        PatientNote updatedPatientNote = restTemplate.getForObject(baseURL + "/patientNote/" + id, PatientNote.class);
        assertNotNull(updatedPatientNote);
    }

    @Ignore
    public void testDeletePatientNote() {
        int id = 2;
        PatientNote patientNote = restTemplate.getForObject(baseURL + "/patientNote/" + id, PatientNote.class);
        assertNotNull(patientNote);
        restTemplate.delete(baseURL + "/patientNote/" + id);
        try {
            patientNote = restTemplate.getForObject(baseURL + "/patientNote/" + id, PatientNote.class);
        }
        catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}