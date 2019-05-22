package com.mpazi.controller.information;

import com.mpazi.domain.information.CheckUpRecord;
import com.mpazi.factory.information.factory.CheckUpRecordFactory;
import com.mpazi.repository.information.CheckUpRecordRepository;
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
public class CheckUpRecordControllerTest {

    Map<String, String> values;
    private CheckUpRecord checkUpRecord;

    @Before
    public void setUp() throws Exception {
        values = new HashMap<>();
        values.put("CheckUpRecordId","3333");
        values.put("CheckUpRecordName","Treatments");

        this.checkUpRecord = CheckUpRecordFactory.getCheckUpRecord(values);

    }


    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/checkUpRecord";

    @Ignore
    public void testGetAllCheckUpRecord() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetCheckUpRecordById() {
        checkUpRecord = restTemplate.getForObject(baseURL + "/checkUpRecord/1", CheckUpRecord.class);
        System.out.println(checkUpRecord.getCheckUpRecordId());
        assertNotNull(checkUpRecord);
    }

    @Test
    public void testCreateCheckUpRecord() {
        checkUpRecord = CheckUpRecordFactory.getCheckUpRecord(values);
        ResponseEntity<CheckUpRecord> postResponse = restTemplate.postForEntity(baseURL + "/create", checkUpRecord, CheckUpRecord.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateCheckUpRecord() {
        int id = 1;
        checkUpRecord = restTemplate.getForObject(baseURL + "/checkUpRecord/" + id, CheckUpRecord.class);

        restTemplate.put(baseURL + "/checkUpRecord/" + id, checkUpRecord);
        CheckUpRecord updatedCheckUpRecord = restTemplate.getForObject(baseURL + "/checkUpRecord/" + id, CheckUpRecord.class);
        assertNotNull(updatedCheckUpRecord);
    }

    @Ignore
    public void testDeleteCheckUpRecord() {
        int id = 2;
        CheckUpRecord checkUpRecord = restTemplate.getForObject(baseURL + "/checkUpRecord/" + id, CheckUpRecord.class);
        assertNotNull(checkUpRecord);
        restTemplate.delete(baseURL + "/checkUpRecord/" + id);
        try {
            checkUpRecord = restTemplate.getForObject(baseURL + "/checkUpRecord/" + id, CheckUpRecord.class);
        }
        catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}