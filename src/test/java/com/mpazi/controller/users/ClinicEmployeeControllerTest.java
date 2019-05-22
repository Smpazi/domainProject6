package com.mpazi.controller.users;

import com.mpazi.domain.users.ClinicEmployee;
import com.mpazi.factory.users.factory.ClinicEmployeeFactory;
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
public class ClinicEmployeeControllerTest {

    Map<String, String> values;
    private ClinicEmployee clinicEmployee;

    @Before
    public void setUp() throws Exception {
        values = new HashMap<>();
        values.put("Employee_ID","23");

        this.clinicEmployee = ClinicEmployeeFactory.getClinicEmployee(values,7777);

    }

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/clinicEmployee";

    @Ignore
    public void testGetAllClinicEmployee() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetClinicEmployeeById() {
        clinicEmployee = restTemplate.getForObject(baseURL + "/clinicEmployee/1", ClinicEmployee.class);
        System.out.println(clinicEmployee.getEmp_Id());
        assertNotNull(clinicEmployee);
    }

    @Test
    public void testCreateClinicEmployee() {
        clinicEmployee = ClinicEmployeeFactory.getClinicEmployee(values,000);
        ResponseEntity<ClinicEmployee> postResponse = restTemplate.postForEntity(baseURL + "/create", clinicEmployee, ClinicEmployee.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateClinicEmployee() {
        int id = 1;
        clinicEmployee = restTemplate.getForObject(baseURL + "/clinicEmployee/" + id, ClinicEmployee.class);

        restTemplate.put(baseURL + "/clinicEmployee/" + id, clinicEmployee);
        ClinicEmployee updatedClinicEmployee = restTemplate.getForObject(baseURL + "/clinicEmployee/" + id, ClinicEmployee.class);
        assertNotNull(updatedClinicEmployee);
    }

    @Ignore
    public void testDeleteClinicEmployee() {
        int id = 2;
        ClinicEmployee clinicEmployee = restTemplate.getForObject(baseURL + "/clinicEmployee/" + id, ClinicEmployee.class);
        assertNotNull(clinicEmployee);
        restTemplate.delete(baseURL + "/clinicEmployee/" + id);
        try {
            clinicEmployee = restTemplate.getForObject(baseURL + "/clinicEmployee/" + id, ClinicEmployee.class);
        }
        catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}