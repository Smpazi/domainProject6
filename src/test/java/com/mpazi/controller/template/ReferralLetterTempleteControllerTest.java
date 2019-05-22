package com.mpazi.controller.template;

import com.mpazi.domain.template.ReferralLetterTemplate;
import com.mpazi.factory.template.factory.ReferralLetterTemplateFactory;
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
public class ReferralLetterTempleteControllerTest {

    Map<String, String> values;
    private ReferralLetterTemplate letterTemplete;

    @Before
    public void setUp() throws Exception {
        values = new HashMap<>();
        values.put("Referral_ID","9797");
        values.put("Referral_HospitalName","StellyHospital");
        this.letterTemplete = ReferralLetterTemplateFactory.getReferralLetter(values);

    }
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/letterTemplete";

    @Ignore
    public void testGetAllReferralLetterTemplate() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetReferralLetterTemplateById() {
        letterTemplete = restTemplate.getForObject(baseURL + "/letterTemplete/1", ReferralLetterTemplate.class);
        System.out.println(letterTemplete.getReferral_ID());
        assertNotNull(letterTemplete);
    }

    @Test
    public void testCreateReferralLetterTemplate() {
        letterTemplete = ReferralLetterTemplateFactory.getReferralLetter(values);
        ResponseEntity<ReferralLetterTemplate> postResponse = restTemplate.postForEntity(baseURL + "/create", letterTemplete, ReferralLetterTemplate.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateReferralLetterTemplate() {
        int id = 1;
        letterTemplete = restTemplate.getForObject(baseURL + "/letterTemplete/" + id, ReferralLetterTemplate.class);

        restTemplate.put(baseURL + "/letterTemplete/" + id, letterTemplete);
        ReferralLetterTemplate updatedReferralLetterTemplate = restTemplate.getForObject(baseURL + "/letterTemplete/" + id, ReferralLetterTemplate.class);
        assertNotNull(updatedReferralLetterTemplate);
    }

    @Ignore
    public void testDeleteReferralLetterTemplate() {
        int id = 2;
        ReferralLetterTemplate letterTemplete = restTemplate.getForObject(baseURL + "/letterTemplete/" + id, ReferralLetterTemplate.class);
        assertNotNull(letterTemplete);
        restTemplate.delete(baseURL + "/letterTemplete/" + id);
        try {
            letterTemplete = restTemplate.getForObject(baseURL + "/letterTemplete/" + id, ReferralLetterTemplate.class);
        }
        catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}