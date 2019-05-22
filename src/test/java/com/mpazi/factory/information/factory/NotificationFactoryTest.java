package com.mpazi.factory.information.factory;

import com.mpazi.domain.information.Notification;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class NotificationFactoryTest {

    Map<String, String> values;
    @Before
    public void setUp() throws Exception {

        values = new HashMap<>();
        values.put("NotificationDate","23/April/2011");
        //    values.put("CheckUpDescription","23/April/2011");

    }
    @Test
    public void getNotificationTest() {

        Notification notification = NotificationFactory.getNotification(values);

        Assert.assertEquals("23/April/2011",notification.getNotificationDate());

    }
}