package com.mpazi.service.users;

import com.mpazi.domain.users.Nurse;
import com.mpazi.factory.users.factory.NurseFactory;
import com.mpazi.repository.users.NurseRepository;
import com.mpazi.repository.users.impl.NurseRepositoryImpl;
import com.mpazi.service.users.impl.NurseServiceImpl;
import org.junit.*;
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
public class NurseServiceImplTest {

    Map<String, String> values;
    private NurseService service;
    private Nurse nurse;

    @Before
    public void setUp() throws Exception {
        this.service = NurseServiceImpl.getInstance();
        values = new HashMap<>();

        this.nurse = NurseFactory.getNurse("BabiesDepartment");

    }

    @Test
    public void create() {
        Nurse created = this.service.create(nurse);
        System.out.println("In create, created = " + created);
        service.create(created);

        Assert.assertSame(created, this.nurse);

    }
    @Test
    public void read() {
        Nurse appoint = new Nurse.Builder()
                .nursing_Department("BabiesDepartment")
                .build();
        service.create(appoint);
        Nurse read = service.read("AS322");
        System.out.println("In read, read = " +read.getNursing_Department() );
    }
    @Test
    public void update()  {
        Nurse newAppointment = new Nurse.Builder()
                .nursing_Department(values.get("BabiesDepartment"))
                .build();
        service.update(newAppointment);
        Nurse updated = service.read("AS322");
        assertEquals("BabiesDepartment",updated.getNursing_Department());
    }


    @Test
    public void delete() {

        this.service.delete("AS322");
        Nurse nurse= service.read("AS322");
        assertNull(nurse);

    }

    @Test
    public void  getAll(){
        Map<String, Nurse> all = this.service.getAll();
        System.out.println(all);
    }

}