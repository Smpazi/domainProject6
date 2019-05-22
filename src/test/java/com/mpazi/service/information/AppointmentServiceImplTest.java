package com.mpazi.service.information;

import com.mpazi.domain.information.Appointment;
import com.mpazi.factory.information.factory.AppointmentFactory;
import com.mpazi.service.information.impl.AppointmentServiceImpl;
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
public class AppointmentServiceImplTest {

    Map<String, String> values;
    private AppointmentService service;
    private Appointment appointment;

    @Before
    public void setUp() throws Exception {
        this.service = AppointmentServiceImpl.getInstance();
        values = new HashMap<>();
        values.put("AppointmentId","55555");
        values.put("AppointmentDate","10/May/2010");

        this.appointment = AppointmentFactory.getAppointment(values);

    }

    @Test
    public void create() {
        Appointment created = this.service.create(appointment);
        System.out.println("In create, created = " + created);
        service.create(created);

        Assert.assertSame(created, this.appointment);

    }
    @Test
    public void read() {
        Appointment appoint = new Appointment.Builder()
                .appointmentId(values.get("AppointmentId"))
                .appointmentDate(values.get("AppointmentDate"))
                .build();
        service.create(appoint);
        Appointment appointment = service.read("55555");
        assertEquals("10/May/2010",appointment.getAppointmentDate());

        System.out.println("In read, read = " + appointment.getAppointmentDate());
    }
    @Test
    public void update()  {
        Appointment newAppointment = new Appointment.Builder()
                .appointmentId(values.get("AppointmentId"))
                .appointmentDate("20/May/2019")
                .build();
        service.update(newAppointment);
        Appointment UpdateAppo = service.read("55555");
        assertEquals("20/May/2019",UpdateAppo.getAppointmentDate());
        System.out.println("In update, updated = " + UpdateAppo.getAppointmentDate());

    }


    @Test
    public void delete() {
        this.service.delete("55555");
        Appointment appointment1= service.read("55555");
        assertNull(appointment1);

        // System.out.println(appointment1.getAppointmentDate());

    }

    @Test
    public void  getAll(){
        Map<String,Appointment> all = this.service.getAll();
        System.out.println(all);
    }



}