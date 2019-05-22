package com.mpazi.controller.login;

import com.mpazi.domain.login.LoginAccount;
import com.mpazi.factory.login.factory.LoginAccountFactory;
import com.mpazi.repository.login.LoginAccountRepository;
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
public class LoginAccountControllerTest {

    Map<String, String> values;
    private LoginAccount loginAccount;

    @Before
    public void setUp() throws Exception {
        values = new HashMap<>();
        values.put("StaffId","AS32");

        this.loginAccount =  LoginAccountFactory.getLoginAccount(values,666);

    }
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/loginAccount";

    @Ignore
    public void testGetAllLoginAccount() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetLoginAccountById() {
        loginAccount = restTemplate.getForObject(baseURL + "/loginAccount/1", LoginAccount.class);
        System.out.println(loginAccount.getStaffId());
        assertNotNull(loginAccount);
    }

    @Test
    public void testCreateLoginAccount() {
        loginAccount = LoginAccountFactory.getLoginAccount(values,0);
        ResponseEntity<LoginAccount> postResponse = restTemplate.postForEntity(baseURL + "/create", loginAccount, LoginAccount.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateLoginAccount() {
        int id = 1;
        loginAccount = restTemplate.getForObject(baseURL + "/loginAccount/" + id, LoginAccount.class);

        restTemplate.put(baseURL + "/loginAccount/" + id, loginAccount);
        LoginAccount updatedLoginAccount= restTemplate.getForObject(baseURL + "/loginAccount/" + id, LoginAccount.class);
        assertNotNull(updatedLoginAccount);
    }

    @Ignore
    public void testDeleteLoginAccount() {
        int id = 2;
        LoginAccount loginAccount = restTemplate.getForObject(baseURL + "/loginAccount/" + id, LoginAccount.class);
        assertNotNull(loginAccount);
        restTemplate.delete(baseURL + "/loginAccount/" + id);
        try {
            loginAccount = restTemplate.getForObject(baseURL + "/loginAccount/" + id, LoginAccount.class);
        }
        catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}