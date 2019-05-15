package com.mpazi.repository.login;

import com.mpazi.domain.login.LoginAccount;
import com.mpazi.factory.login.factory.LoginAccountFactory;
import com.mpazi.repository.implementation.login.LoginAccountRepositoryImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class LoginAccountRepositoryTest {

   private LoginAccountRepository repository;
    private LoginAccount loginAccount;

    private  LoginAccount getSavedLoginAccount(){
        Set<LoginAccount> savedAccount = this.repository.getAll();
        return  savedAccount.iterator().next();
    }
    @Before
    public void setUp() throws Exception {
        this.repository = LoginAccountRepositoryImpl.getRepository();
        this.loginAccount = LoginAccountFactory.getLoginAccount("233s",555);
    }

    @Test
    public void create() {
        LoginAccount createdAccount = this.repository.create(this.loginAccount);
        System.out.println("Created = " + createdAccount);
        assertSame(createdAccount,this.loginAccount);
    }

    @Test
    public void read(){
        LoginAccount savedLoginAcc = getSavedLoginAccount();
      //  System.out.println("StaffId = " + savedLoginAcc.getStaffId());
        LoginAccount read = this.repository.read(savedLoginAcc.getStaffId());
        System.out.println(" read =" + savedLoginAcc.getStaffId());

        assertSame(savedLoginAcc,);
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