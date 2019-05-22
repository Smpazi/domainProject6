package com.mpazi.repository.login;

import com.mpazi.domain.login.Role;
import com.mpazi.factory.login.factory.RoleFactory;
import com.mpazi.repository.login.impl.RoleRepositoryImpl;
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
public class RoleRepositoryTest {
    Map<String, String> values;
    private RoleRepository repository;
    private Role role;

    @Before
    public void setUp() throws Exception {
        this.repository = RoleRepositoryImpl.getRepository();
        values = new HashMap<>();
        values.put("RoleTitle","NurseController");
        values.put("Role_Description","Caregiver");


        this.role = RoleFactory.getRoleFactory(values);

    }

    @Test
    public void create() {
        Role created = this.repository.create(role);
        System.out.println("In create, created = " + created);
        repository.create(created);

        Assert.assertSame(created, this.role);

    }
    @Test
    public void read() {
        Role appoint = new Role.Builder()
                .roleTitle(values.get("RoleTitle"))
                .roleDescription(values.get("Role_Description"))
                .build();
        repository.create(appoint);
        Role read = repository.read("NurseController");
        assertEquals("NurseController",read.getRoleTitle());

        System.out.println("In read, read = " +read.getRoleTitle() );
    }
    @Test
    public void update()  {
        Role role = new Role.Builder()
                .roleTitle(values.get("RoleTitle"))
                .roleDescription("MedicationController discributor")
                .build();
        repository.update(role);
        Role updated = repository.read("NurseController");
        assertEquals("MedicationController discributor",updated.getRoleDescription());
    }

    @Test
    public void delete() {

        this.repository.delete("NurseController");
        Role role= repository.read("NurseController");
        assertNull(role);

    }

    @Test
    public void  getAll(){
        Map<String,Role> all = this.repository.getAll();
        System.out.println(all);
    }

}