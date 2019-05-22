package com.mpazi.repository.login;

import com.mpazi.domain.login.UserPasswordReset;
import com.mpazi.factory.login.factory.UserPasswordResetFactory;
import com.mpazi.repository.login.impl.UserPasswordResetRepositoryImpl;
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
public class UserPasswordResetRepositoryTest {
    Map<String, String> values;
    private UserPasswordResetRepository repository;
    private UserPasswordReset userPasswordReset;

    @Before
    public void setUp() throws Exception {
        this.repository = UserPasswordResetRepositoryImpl.getRepository();
        values = new HashMap<>();
        values.put("UserID","USER32");


        this.userPasswordReset = UserPasswordResetFactory.getUserPasswordReset(values,333,444);

    }

    @Test
    public void create() {
        UserPasswordReset created = this.repository.create(userPasswordReset);
        System.out.println("In create, created = " + created);
        repository.create(created);

        Assert.assertSame(created, this.userPasswordReset);

    }
    @Test
    public void read() {
        UserPasswordReset appoint = new UserPasswordReset.Builder()
                .userId(values.get("UserID"))
                .oldPassword(333)
                .build();
        repository.create(appoint);
        UserPasswordReset read = repository.read("USER32");
        assertEquals(333,read.getOldPassword()) ;

        System.out.println("In read, read = " +read.getOldPassword() );
    }
    @Test
    public void update()  {
        UserPasswordReset userPasswordReset = new UserPasswordReset.Builder()
                .userId(values.get("UserID"))
                .newPassword(222)
                .build();
        repository.update(userPasswordReset);
        UserPasswordReset updated = repository.read("USER32");
        assertEquals(222,updated.getNewPassword());
    }


    @Test
    public void delete() {

        this.repository.delete("AS322");
        UserPasswordReset userPasswordReset= repository.read("AS322");
        assertNull(userPasswordReset);

    }

    @Test
    public void  getAll(){
        Map<String, UserPasswordReset> all = this.repository.getAll();
        System.out.println(all);
    }

}