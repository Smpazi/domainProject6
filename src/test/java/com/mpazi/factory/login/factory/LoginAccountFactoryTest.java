package com.mpazi.factory.login.factory;

import com.mpazi.domain.register.login.LoginAccount;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginAccountFactoryTest {

    @Test
    public void getLogAccountTest(){

        LoginAccount loginAccount =LoginAccountFactory.getLoginAccount("CD123",1234);

        assertEquals("CD123",loginAccount.getStaffId());

    }

}