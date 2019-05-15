package com.mpazi.factory.login.factory;

import com.mpazi.domain.login.UserPasswordReset;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserPasswordResetFactoryTest {

    @Test
    public void getUserPasswordTest(){

        UserPasswordReset userPasswordReset =UserPasswordResetFactory.getUserPasswordReset(12345,12345);


        assertEquals(userPasswordReset.getOldPassword(),userPasswordReset.getNewPassword());


    }

}