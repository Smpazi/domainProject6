package com.mpazi.controller.information;

import com.mpazi.domain.information.Appointment;
import com.mpazi.domain.information.CheckUpPatient;
import com.mpazi.factory.information.factory.AppointmentFactory;
import com.mpazi.factory.information.factory.CheckUpPatientFactory;
import com.mpazi.repository.information.CheckUpPatientRepository;
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

@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class CheckUpPatientControllerTest {
    Map<String, String> values;
    private CheckUpPatient checkUpPatient;

    @Before
    public void setUp() throws Exception {
        values = new HashMap<>();
        values.put("CheckUp_ID","2222");
        values.put("CheckUp_Date","02/03/2011");
        values.put("CheckUp_Reason","Wound dressing");

        this.checkUpPatient = CheckUpPatientFactory.getCheckUpPatient(values);

    }


    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/checkUpPatient";

    @Test
    public void testGetAllCheckUpPatient() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetCheckUpPatientById() {
        checkUpPatient = restTemplate.getForObject(baseURL + "/checkUpPatient/1", CheckUpPatient.class);
        System.out.println(checkUpPatient.getCheckUp_Id());
        assertNotNull(checkUpPatient);
    }

    @Test
    public void testCreateCheckUpPatient() {
        this.checkUpPatient = CheckUpPatientFactory.getCheckUpPatient(values);
        ResponseEntity<CheckUpPatient> postResponse = restTemplate.postForEntity(baseURL + "/create", checkUpPatient, CheckUpPatient.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateCheckUpPatient() {
        int id = 1;
        checkUpPatient = restTemplate.getForObject(baseURL + "/checkUpPatient/" + id, CheckUpPatient.class);

        restTemplate.put(baseURL + "/checkUpPatient/" + id, checkUpPatient);
        CheckUpPatient updatedStudent = restTemplate.getForObject(baseURL + "/checkUpPatient/" + id, CheckUpPatient.class);
        assertNotNull(updatedStudent);
    }

    @Test
    public void testDeleteAppointment() {
        int id = 2;
        CheckUpPatient checkUpPatient = restTemplate.getForObject(baseURL + "/checkUpPatient/" + id, CheckUpPatient.class);
        assertNotNull(checkUpPatient);
        restTemplate.delete(baseURL + "/checkUpPatient/" + id);
        try {
            checkUpPatient = restTemplate.getForObject(baseURL + "/checkUpPatient/" + id, CheckUpPatient.class);
        }
        catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}