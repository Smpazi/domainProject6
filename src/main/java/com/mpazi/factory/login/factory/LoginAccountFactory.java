package com.mpazi.factory.login.factory;

import com.mpazi.domain.register.login.LoginAccount;
import com.mpazi.domain.register.login.Role;

public class LoginAccountFactory {

    public static LoginAccount getLoginAccount(String staffId, int pass){
        return new LoginAccount.Builder()
                .staffId(staffId)
                .password(pass)
                .build();

    }
}
