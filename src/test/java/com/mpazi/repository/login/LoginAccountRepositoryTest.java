package com.mpazi.repository.login;

import com.mpazi.domain.register.login.LoginAccount;
import com.mpazi.factory.login.factory.LoginAccountFactory;
import com.mpazi.repository.implementation.login.LoginAccountRepositoryImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class LoginAccountRepositoryTest {

    Set<LoginAccount> loginAccounts;
    LoginAccountRepository repository;

    LoginAccount loginAccount;
    @Before
    public void setUp() throws Exception {
        repository = LoginAccountRepositoryImpl.getRepository();
        loginAccounts = new HashSet<>();
        loginAccounts.add(loginAccount);
    }

    @Test
    public void create() throws Exception{
        loginAccount= LoginAccountFactory.getLoginAccount("emp444",333);
        repository.create(loginAccount);
        assertEquals(333,loginAccount.getPassword());
    }

    @Test
    public void read() throws Exception {
        loginAccount = repository.read("emp444");
        assertEquals("emp444",loginAccount.getStaffId());
    }

    @Test
    public void update() throws Exception{
        loginAccount = repository.read("emp444");
        LoginAccount newLogin = new LoginAccount.Builder()
                .staffId("emp444")
                .password(123)
                .build();
        repository.update(newLogin);
        LoginAccount updateLogin = repository.read("emp444");
        assertEquals(123,updateLogin.getPassword());
    }

    @Test
    public void delete() throws Exception{
        repository.delete("emp444");
        loginAccount= repository.read("emp444");
        assertNull(loginAccount);
    }




}