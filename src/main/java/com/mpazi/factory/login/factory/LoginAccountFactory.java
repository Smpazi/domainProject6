package com.mpazi.factory.login.factory;

import com.mpazi.domain.register.login.LoginAccount;
import com.mpazi.domain.register.login.Role;

public class LoginAccountFactory {

    public static LoginAccount getLoginAccount(String staffId){
        return new LoginAccount.Builder().staffId(staffId)
                .build();

    }
}
