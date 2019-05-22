package com.mpazi.repository.users;

import com.mpazi.domain.users.Nurse;
import com.mpazi.factory.users.factory.NurseFactory;
import com.mpazi.repository.users.impl.NurseRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class NurseRepositoryTest {
    Map<String, String> values;
    private NurseRepository repository;
    private Nurse nurse;

    @Before
    public void setUp() throws Exception {
        this.repository = NurseRepositoryImpl.getRepository();
        values = new HashMap<>();

        this.nurse = NurseFactory.getNurse("BabiesDepartment");

    }

    @Test
    public void create() {
        Nurse created = this.repository.create(nurse);
        System.out.println("In create, created = " + created);
        repository.create(created);

        Assert.assertSame(created, this.nurse);

    }
    @Test
    public void read() {
        Nurse appoint = new Nurse.Builder()
                .nursing_Department("BabiesDepartment")
                .build();
        repository.create(appoint);
        Nurse read = repository.read("AS322");
        System.out.println("In read, read = " +read.getNursing_Department() );
    }
    @Test
    public void update()  {
        Nurse newAppointment = new Nurse.Builder()
                .nursing_Department(values.get("BabiesDepartment"))
                .build();
        repository.update(newAppointment);
        Nurse updated = repository.read("AS322");
        assertEquals("BabiesDepartment",updated.getNursing_Department());
    }


    @Test
    public void delete() {

        this.repository.delete("AS322");
        Nurse nurse= repository.read("AS322");
        assertNull(nurse);

    }

    @Test
    public void  getAll(){
        Map<String, Nurse> all = this.repository.getAll();
        System.out.println(all);
    }

}