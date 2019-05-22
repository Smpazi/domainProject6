package com.mpazi.repository.login;

import com.mpazi.domain.login.LoginAccount;
import com.mpazi.factory.login.factory.LoginAccountFactory;
import com.mpazi.repository.login.impl.LoginAccountRepositoryImpl;
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
import java.util.Set;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)
public class LoginAccountRepositoryTest {

    Map<String, String> values;
    private  LoginAccountRepository repository;
    private  LoginAccount loginAccount;

    @Before
    public void setUp() throws Exception {
        this.repository =  LoginAccountRepositoryImpl.getRepository();
        values = new HashMap<>();
        values.put("StaffId","AS32");

        this.loginAccount =  LoginAccountFactory.getLoginAccount(values,666);

    }

    @Test
    public void create() {
        LoginAccount created = this.repository.create(loginAccount);
        System.out.println("In create, created = " + created);
        repository.create(created);

        Assert.assertSame(created, this.loginAccount);

    }
    @Test
    public void read() {
        LoginAccount loginAccount = new  LoginAccount.Builder()
                .staffId(values.get("StaffId"))
                .password(333)
                .build();
        repository.create(loginAccount);
        LoginAccount read = repository.read("AS32");
        assertEquals(333,read.getPassword());
        System.out.println("In read, read = " +read.getPassword());
    }
    @Test
    public void update()  {
        LoginAccount loginAccount = new LoginAccount.Builder()
                .staffId(values.get("StaffId"))
                .password(333)
                .build();
        repository.update(loginAccount);
        LoginAccount updated = repository.read("AS32");
        assertEquals("AS32",updated.getStaffId());
    }


    @Test
    public void delete() {

        this.repository.delete("AS32");
        LoginAccount loginAccount= repository.read("AS32");
        assertNull(loginAccount);
    }

    @Test
    public void  getAll(){
        Map<String, LoginAccount> all = this.repository.getAll();
        System.out.println(all);
    }

}