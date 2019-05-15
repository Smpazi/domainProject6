package com.mpazi.factory.login.factory;

import com.mpazi.domain.login.UserPasswordReset;
import com.mpazi.util.Misc;

public class UserPasswordResetFactory {

    public static UserPasswordReset getUserPasswordReset(int oldPass, int newPass){
        return new UserPasswordReset.Builder().userId(Misc.generateId())
                .oldPassword(oldPass)
                .newPassword(newPass)
                .build();

    }
}
