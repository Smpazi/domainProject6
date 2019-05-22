package com.mpazi.repository.information;

import com.mpazi.domain.information.Notification;
import com.mpazi.factory.information.factory.NotificationFactory;
import com.mpazi.repository.information.impl.NotificationRepositoryImpl;
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
@FixMethodOrder(MethodSorters.JVM)
public class NotificationImplTest {
    Map<String, String> values;
    private NotificationRepository repository;
    private Notification notification;

    @Before
    public void setUp() throws Exception {
        this.repository = NotificationRepositoryImpl.getRepository();
        values = new HashMap<>();
        values.put("NotificationID","AS322");
        values.put("NotificationDate","10/May/2010");


        this.notification = NotificationFactory.getNotification(values);

    }

    @Test
    public void create() {
        Notification created = this.repository.create(notification);
        System.out.println("In create, created = " + created);
        repository.create(created);

        Assert.assertSame(created, this.notification);

    }
    @Test
    public void read() {
        Notification appoint = new Notification.Builder()
                .notificationID(values.get("NotificationID"))
                .notificationDate(values.get("NotificationDate"))
                .build();
        repository.create(appoint);
        Notification read = repository.read("AS322");
        assertEquals("10/May/2010",read.getNotificationDate());

        System.out.println("In read, read = " +read.getNotificationDate() );
    }
    @Test
    public void update()  {
        Notification newAppointment = new Notification.Builder()
                .notificationID(values.get("NotificationID"))
                .notificationDate("20/May/2019")
                .build();
        repository.update(newAppointment);
        Notification updated = repository.read("AS322");
        assertEquals("20/May/2019",updated.getNotificationDate());
    }


    @Test
    public void delete() {

        this.repository.delete("AS322");
        Notification notification= repository.read("AS322");
        assertNull(notification);

    }

    @Test
    public void  getAll(){
        Map<String,Notification> all = this.repository.getAll();
        System.out.println(all);
    }




}