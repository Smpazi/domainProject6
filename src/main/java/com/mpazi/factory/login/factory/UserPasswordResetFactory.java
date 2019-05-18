package com.mpazi.factory.login.factory;

import com.mpazi.domain.login.UserPasswordReset;
import com.mpazi.util.Misc;

import java.util.Map;

public class UserPasswordResetFactory {

    public static UserPasswordReset getUserPasswordReset(Map<String, String> values, int oldPass, int newPass){
        return new UserPasswordReset.Builder()
                .userId(values.get(Misc.generateId()))
                .oldPassword(oldPass)
                .newPassword(newPass)
                .build();

    }
}
