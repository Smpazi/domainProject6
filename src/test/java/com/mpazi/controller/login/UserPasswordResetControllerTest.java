package com.mpazi.controller.login;

import com.mpazi.domain.login.UserPasswordReset;
import com.mpazi.factory.login.factory.UserPasswordResetFactory;
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
public class UserPasswordResetControllerTest {

    Map<String, String> values;
    private UserPasswordReset userPasswordReset;

    @Before
    public void setUp() throws Exception {
        values = new HashMap<>();
        values.put("UserID","USER32");

        this.userPasswordReset = UserPasswordResetFactory.getUserPasswordReset(values,333,444);

    }
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/userPasswordReset";

    @Ignore
    public void testGetAllUserPasswordReset() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetUserPasswordResetById() {
        userPasswordReset = restTemplate.getForObject(baseURL + "/userPasswordReset/1", UserPasswordReset.class);
        System.out.println(userPasswordReset.getUserId());
        assertNotNull(userPasswordReset);
    }

    @Test
    public void testCreateUserPasswordReset() {
        userPasswordReset = UserPasswordResetFactory.getUserPasswordReset(values,888,888);
        ResponseEntity<UserPasswordReset> postResponse = restTemplate.postForEntity(baseURL + "/create", userPasswordReset, UserPasswordReset.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateUserPasswordReset() {
        int id = 1;
        userPasswordReset = restTemplate.getForObject(baseURL + "/userPasswordReset/" + id, UserPasswordReset.class);

        restTemplate.put(baseURL + "/userPasswordReset/" + id, userPasswordReset);
        UserPasswordReset updatedUserPasswordReset = restTemplate.getForObject(baseURL + "/userPasswordReset/" + id, UserPasswordReset.class);
        assertNotNull(updatedUserPasswordReset);
    }

    @Ignore
    public void testDeleteUserPasswordReset() {
        int id = 2;
        UserPasswordReset userPasswordReset = restTemplate.getForObject(baseURL + "/userPasswordReset/" + id, UserPasswordReset.class);
        assertNotNull(userPasswordReset);
        restTemplate.delete(baseURL + "/userPasswordReset/" + id);
        try {
            userPasswordReset = restTemplate.getForObject(baseURL + "/userPasswordReset/" + id, UserPasswordReset.class);
        }
        catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}