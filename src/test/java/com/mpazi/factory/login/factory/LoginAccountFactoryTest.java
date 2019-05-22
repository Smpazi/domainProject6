package com.mpazi.factory.login.factory;

import com.mpazi.domain.login.LoginAccount;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class LoginAccountFactoryTest {

    Map<String, String> values;
    @Before
    public void setUp() throws Exception {

        values = new HashMap<>();
        values.put("StaffId","1010");

    }
    @Test
    public void getLoginAccountTest() {

        LoginAccount loginAccount= LoginAccountFactory.getLoginAccount(values,444);

        Assert.assertEquals(444,loginAccount.getPassword());

    }
}