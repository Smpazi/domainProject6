package com.mpazi.service.login;

import com.mpazi.domain.login.Role;
import com.mpazi.factory.login.factory.RoleFactory;
import com.mpazi.repository.login.RoleRepository;
import com.mpazi.repository.login.impl.RoleRepositoryImpl;
import com.mpazi.service.login.impl.RoleServiceImpl;
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
public class RoleServiceImplTest {
    Map<String, String> values;
    private RoleService service;
    private Role role;

    @Before
    public void setUp() throws Exception {
        this.service = RoleServiceImpl.getInstance();
        values = new HashMap<>();
        values.put("RoleTitle","NurseController");
        values.put("Role_Description","Caregiver");


        this.role = RoleFactory.getRoleFactory(values);

    }

    @Test
    public void create() {
        Role created = this.service.create(role);
        System.out.println("In create, created = " + created);
        service.create(created);

        Assert.assertSame(created, this.role);

    }
    @Test
    public void read() {
        Role appoint = new Role.Builder()
                .roleTitle(values.get("RoleTitle"))
                .roleDescription(values.get("Role_Description"))
                .build();
        service.create(appoint);
        Role read = service.read("NurseController");
        assertEquals("NurseController",read.getRoleTitle());

        System.out.println("In read, read = " +read.getRoleTitle() );
    }
    @Test
    public void update()  {
        Role role = new Role.Builder()
                .roleTitle(values.get("RoleTitle"))
                .roleDescription("MedicationController discributor")
                .build();
        service.update(role);
        Role updated = service.read("NurseController");
        assertEquals("MedicationController discributor",updated.getRoleDescription());
    }

    @Test
    public void delete() {

        this.service.delete("NurseController");
        Role role= service.read("NurseController");
        assertNull(role);

    }

    @Test
    public void  getAll(){
        Map<String,Role> all = this.service.getAll();
        System.out.println(all);
    }

}