package com.mpazi.service.information;

import com.mpazi.domain.information.Notification;
import com.mpazi.factory.information.factory.NotificationFactory;
import com.mpazi.repository.information.NotificationRepository;
import com.mpazi.repository.information.impl.NotificationRepositoryImpl;
import com.mpazi.service.information.impl.NotificationServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NotificationServiceImplTest {
    Map<String, String> values;
    private NotificationService service;
    private Notification notification;

    @Before
    public void setUp() throws Exception {
        this.service = NotificationServiceImpl.getInstance();
        values = new HashMap<>();
        values.put("NotificationID","AS322");
        values.put("NotificationDate","10/May/2010");


        this.notification = NotificationFactory.getNotification(values);

    }

    @Test
    public void create() {
        Notification created = this.service.create(notification);
        System.out.println("In create, created = " + created);
        service.create(created);

        Assert.assertSame(created, this.notification);

    }
    @Test
    public void read() {
        Notification appoint = new Notification.Builder()
                .notificationID(values.get("NotificationID"))
                .notificationDate(values.get("NotificationDate"))
                .build();
        service.create(appoint);
        Notification read = service.read("AS322");
        System.out.println("In read, read = " +read.getNotificationDate() );
    }
    @Test
    public void update()  {
        Notification newAppointment = new Notification.Builder()
                .notificationID(values.get("NotificationID"))
                .notificationDate("20/May/2019")
                .build();
        service.update(newAppointment);
        Notification updated = service.read("AS322");
        assertEquals("20/May/2019",updated.getNotificationDate());
    }


    @Test
    public void delete() {

        this.service.delete("AS322");
        Notification notification= service.read("AS322");
        assertNull(notification);

    }

    @Test
    public void  getAll(){
        Map<String,Notification> all = this.service.getAll();
        System.out.println(all);
    }

}