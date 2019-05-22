package com.mpazi.controller.information;

import com.mpazi.domain.information.Appointment;
import com.mpazi.factory.information.factory.AppointmentFactory;
import com.mpazi.service.information.impl.AppointmentServiceImpl;
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
public class AppointmentControllerTest {

    Map<String, String> values;
    private Appointment appointment;

    @Before
    public void setUp() throws Exception {
        values = new HashMap<>();
        values.put("AppointmentId","55555");
        values.put("AppointmentDate","10/May/2010");

      //  this.appointment = AppointmentFactory.getAppointment(values);
    }

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/appointment";

    @Ignore
    public void testGetAllAppointment() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetAppointmentById() {
        appointment = restTemplate.getForObject(baseURL + "/appointment/1", Appointment.class);
        System.out.println(appointment.getAppointmentId());
        assertNotNull(appointment);
    }

    @Test
    public void testCreateAppointment() {
         appointment = AppointmentFactory.getAppointment(values);
        ResponseEntity<Appointment> postResponse = restTemplate.postForEntity(baseURL + "/create", this.appointment, Appointment.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateAppointment() {
        int id = 1;
         appointment = restTemplate.getForObject(baseURL + "/appointment/" + id, Appointment.class);

        restTemplate.put(baseURL + "/appointment/" + id, appointment);
        Appointment updatedStudent = restTemplate.getForObject(baseURL + "/appointment/" + id, Appointment.class);
        assertNotNull(updatedStudent);
    }

    @Ignore
    public void testDeleteAppointment() {
        int id = 2;
        Appointment appointment = restTemplate.getForObject(baseURL + "/appointment/" + id, Appointment.class);
        assertNotNull(appointment);
        restTemplate.delete(baseURL + "/appointment/" + id);
        try {
            appointment = restTemplate.getForObject(baseURL + "/appointment/" + id, Appointment.class);
        }
        catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}