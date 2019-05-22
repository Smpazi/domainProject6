package com.mpazi.repository.information;

import com.mpazi.domain.information.Appointment;
import com.mpazi.factory.information.factory.AppointmentFactory;
import com.mpazi.repository.information.impl.AppointmentRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class AppointmentRepositoryTest {

    Map<String, String> values;
    @Autowired
    private AppointmentRepository repository;
    private Appointment appointment;

    @Before
    public void setUp() throws Exception {
        this.repository = AppointmentRepositoryImpl.getRepository();
        values = new HashMap<>();
        values.put("AppointmentId","55555");
        values.put("AppointmentDate","10/May/2010");


       this.appointment = AppointmentFactory.getAppointment(values);

    }

    @Test
    public void create() {
        Appointment created = this.repository.create(appointment);
        System.out.println("In create, created = " + created);
        repository.create(created);

        Assert.assertSame(created, this.appointment);

    }
  @Test
    public void read() {
      Appointment appoint = new Appointment.Builder()
              .appointmentId(values.get("AppointmentId"))
              .appointmentDate(values.get("AppointmentDate"))
              .build();
      repository.create(appoint);
      Appointment appointment = repository.read("55555");

      assertEquals("10/May/2010",appointment.getAppointmentDate());

      System.out.println("In read, read = " + appointment.getAppointmentDate());
  }
    @Test
    public void update()  {
        Appointment newAppointment = new Appointment.Builder()
                .appointmentId(values.get("AppointmentId"))
                .appointmentDate("20/May/2019")
                .build();
        repository.update(newAppointment);
        Appointment UpdateAppo = repository.read("55555");
        assertEquals("20/May/2019",UpdateAppo.getAppointmentDate());
        System.out.println("In update, updated = " + UpdateAppo.getAppointmentDate());

    }


 @Test
  public void delete() {
      this.repository.delete("55555");
      Appointment appointment1= repository.read("55555");
      assertNull(appointment1);

 }

 @Test
    public void  getAll(){
     Map<String,Appointment> all = this.repository.getAll();
     System.out.println(all);
 }



}