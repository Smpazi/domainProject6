package com.mpazi.service.login;

import com.mpazi.domain.login.UserPasswordReset;
import com.mpazi.factory.login.factory.UserPasswordResetFactory;
import com.mpazi.repository.login.UserPasswordResetRepository;
import com.mpazi.repository.login.impl.UserPasswordResetRepositoryImpl;
import com.mpazi.service.login.impl.UserPasswordResetServiceImpl;
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
public class UserPasswordResetServiceImplTest {

    Map<String, String> values;
    private UserPasswordResetService service;
    private UserPasswordReset userPasswordReset;

    @Before
    public void setUp() throws Exception {
        this.service = UserPasswordResetServiceImpl.getInstance();
        values = new HashMap<>();
        values.put("UserID","USER32");


        this.userPasswordReset = UserPasswordResetFactory.getUserPasswordReset(values,333,444);

    }

    @Test
    public void create() {
        UserPasswordReset created = this.service.create(userPasswordReset);
        System.out.println("In create, created = " + created);
        service.create(created);

        Assert.assertSame(created, this.userPasswordReset);

    }
    @Test
    public void read() {
        UserPasswordReset appoint = new UserPasswordReset.Builder()
                .userId(values.get("UserID"))
                .oldPassword(333)
                .build();
        service.create(appoint);
        UserPasswordReset read = service.read("USER32");
        assertEquals(333,read.getOldPassword()) ;

        System.out.println("In read, read = " +read.getOldPassword() );
    }
    @Test
    public void update()  {
        UserPasswordReset userPasswordReset = new UserPasswordReset.Builder()
                .userId(values.get("UserID"))
                .newPassword(222)
                .build();
        service.update(userPasswordReset);
        UserPasswordReset updated = service.read("USER32");
        assertEquals(222,updated.getNewPassword());
    }


    @Test
    public void delete() {

        this.service.delete("AS322");
        UserPasswordReset userPasswordReset= service.read("AS322");
        assertNull(userPasswordReset);

    }

    @Test
    public void  getAll(){
        Map<String, UserPasswordReset> all = this.service.getAll();
        System.out.println(all);
    }

}