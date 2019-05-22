package com.mpazi.controller.login;

import com.mpazi.domain.login.Role;
import com.mpazi.factory.login.factory.RoleFactory;
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
public class RoleControllerTest {

    Map<String, String> values;
    private Role role;

    @Before
    public void setUp() throws Exception {
        values = new HashMap<>();
        values.put("RoleTitle","NurseController");
        values.put("Role_Description","Caregiver");
        this.role = RoleFactory.getRoleFactory(values);

    }
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/role";

    @Ignore
    public void testGetAllAppointment() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetRoleById() {
        role = restTemplate.getForObject(baseURL + "/role/1", Role.class);
        System.out.println(role.getRoleTitle());
        assertNotNull(role);
    }

    @Test
    public void testCreateRole() {
        role =RoleFactory.getRoleFactory(values);
        ResponseEntity<Role> postResponse = restTemplate.postForEntity(baseURL + "/create", role, Role.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateRole() {
        int id = 1;
        role = restTemplate.getForObject(baseURL + "/role/" + id, Role.class);

        restTemplate.put(baseURL + "/role/" + id, role);
        Role updatedRole = restTemplate.getForObject(baseURL + "/role/" + id, Role.class);
        assertNotNull(updatedRole);
    }

    @Ignore
    public void testDeleteRole() {
        int id = 2;
        Role role = restTemplate.getForObject(baseURL + "/role/" + id, Role.class);
        assertNotNull(role);
        restTemplate.delete(baseURL + "/role/" + id);
        try {
            role = restTemplate.getForObject(baseURL + "/role/" + id, Role.class);
        }
        catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}