package com.mpazi.controller.template;

import com.mpazi.domain.template.TransferLetterTemplate;
import com.mpazi.factory.template.factory.TransferLetterTemplateFactory;
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
public class TransferLetterTemplateControllerTest {

    Map<String, String> values;
    private TransferLetterTemplate template;

    @Before
    public void setUp() throws Exception {
        values = new HashMap<>();
        values.put("Transfer_Id","a2");
        values.put("Transfer_DoctorName","Dr.ROSSOW");


        this.template = TransferLetterTemplateFactory.getTransferLetter(values);

    }
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/transferLetterTemplate";

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
        template = restTemplate.getForObject(baseURL + "/template/1", TransferLetterTemplate.class);
        System.out.println(template.getTransfer_ID());
        assertNotNull(template);
    }

    @Test
    public void testCreateAppointment() {
        template = TransferLetterTemplateFactory.getTransferLetter(values);
        ResponseEntity<TransferLetterTemplate> postResponse = restTemplate.postForEntity(baseURL + "/create", template, TransferLetterTemplate.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateTransferLetterTemplate() {
        int id = 1;
        template = restTemplate.getForObject(baseURL + "/template/" + id, TransferLetterTemplate.class);

        restTemplate.put(baseURL + "/template/" + id, template);
        TransferLetterTemplate updatedTransferLetterTemplate = restTemplate.getForObject(baseURL + "/template/" + id, TransferLetterTemplate.class);
        assertNotNull(updatedTransferLetterTemplate);
    }

    @Ignore
    public void testDeleteTransferLetterTemplate() {
        int id = 2;
        TransferLetterTemplate template = restTemplate.getForObject(baseURL + "/template/" + id, TransferLetterTemplate.class);
        assertNotNull(template);
        restTemplate.delete(baseURL + "/template/" + id);
        try {
            template = restTemplate.getForObject(baseURL + "/template/" + id, TransferLetterTemplate.class);
        }
        catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}