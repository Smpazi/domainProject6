package com.mpazi.controller.template;

import com.mpazi.domain.template.SearchPatient;
import com.mpazi.factory.template.factory.SearchPatientFactory;
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
public class SearchPatientControllerTest {

    Map<String, String> values;
    private SearchPatient searchPatient;

    @Before
    public void setUp() throws Exception {
        values = new HashMap<>();
        values.put("SearchId","3");
        this.searchPatient = SearchPatientFactory.getSearchPatient(values);

    }
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/searchPatient";

    @Ignore
    public void testGetAllSearchPatient() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetSearchPatientById() {
        searchPatient = restTemplate.getForObject(baseURL + "/searchPatient/1", SearchPatient.class);
        System.out.println(searchPatient.getSearchId());
        assertNotNull(searchPatient);
    }

    @Test
    public void testCreateSearchPatient() {
        searchPatient = SearchPatientFactory.getSearchPatient(values);
        ResponseEntity<SearchPatient> postResponse = restTemplate.postForEntity(baseURL + "/create", searchPatient, SearchPatient.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateSearchPatient() {
        int id = 1;
        searchPatient = restTemplate.getForObject(baseURL + "/searchPatient/" + id, SearchPatient.class);

        restTemplate.put(baseURL + "/searchPatient/" + id, searchPatient);
        SearchPatient updatedSearchPatient = restTemplate.getForObject(baseURL + "/searchPatient/" + id, SearchPatient.class);
        assertNotNull(updatedSearchPatient);
    }

    @Ignore
    public void testDeleteSearchPatient() {
        int id = 2;
        SearchPatient searchPatient = restTemplate.getForObject(baseURL + "/searchPatient/" + id, SearchPatient.class);
        assertNotNull(searchPatient);
        restTemplate.delete(baseURL + "/searchPatient/" + id);
        try {
            searchPatient = restTemplate.getForObject(baseURL + "/searchPatient/" + id, SearchPatient.class);
        }
        catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}