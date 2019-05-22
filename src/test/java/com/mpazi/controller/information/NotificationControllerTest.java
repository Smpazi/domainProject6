package com.mpazi.controller.information;

import com.mpazi.domain.information.Notification;
import com.mpazi.factory.information.factory.NotificationFactory;
import com.mpazi.repository.information.NotificationRepository;
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
import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class NotificationControllerTest {

    Map<String, String> values;
    private Notification notification;

    @Before
    public void setUp() throws Exception {
        values = new HashMap<>();
        values.put("NotificationID","AS322");
        values.put("NotificationDate","10/May/2010");


        this.notification = NotificationFactory.getNotification(values);

    }

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/notification";

    @Ignore
    public void testGetAllNotification() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Ignore
    public void testGetNotificationById() {
        notification = restTemplate.getForObject(baseURL + "/notification/1", Notification.class);
        System.out.println(notification.getNotificationID());
        assertNotNull(notification);
    }

    @Test
    public void testCreateNotification() {
        notification = NotificationFactory.getNotification(values);
        ResponseEntity<Notification> postResponse = restTemplate.postForEntity(baseURL + "/create", notification, Notification.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Ignore
    public void testUpdateNotification() {
        int id = 1;
        notification = restTemplate.getForObject(baseURL + "/notification/" + id, Notification.class);

        restTemplate.put(baseURL + "/notification/" + id, notification);
        Notification updatedNotification = restTemplate.getForObject(baseURL + "/notification/" + id, Notification.class);
        assertNotNull(updatedNotification);
    }

    @Ignore
    public void testDeleteNotification() {
        int id = 2;
        Notification notification = restTemplate.getForObject(baseURL + "/notification/" + id, Notification.class);
        assertNotNull(notification);
        restTemplate.delete(baseURL + "/notification/" + id);
        try {
            notification = restTemplate.getForObject(baseURL + "/notification/" + id, Notification.class);
        }
        catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}