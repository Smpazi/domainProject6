package com.mpazi.factory.login.factory;

import com.mpazi.domain.login.UserPasswordReset;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class UserPasswordResetFactoryTest {
    Map<String, String> values;
    @Before
    public void setUp() throws Exception {

        values = new HashMap<>();

    }
    @Test
    public void getUserPasswordResetTest() {

        UserPasswordReset userPasswordReset= UserPasswordResetFactory.getUserPasswordReset(values, 233,444);

        Assert.assertNotEquals("new Password not the same as old ",userPasswordReset.getNewPassword(),userPasswordReset.getOldPassword());

    }
}