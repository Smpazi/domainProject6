package com.mpazi.factory.login.factory;

import com.mpazi.domain.login.LoginAccount;

public class LoginAccountFactory {

    public static LoginAccount getLoginAccount(String staffId, int pass){
        return new LoginAccount.Builder()
                .staffId(staffId)
                .password(pass)
                .build();

    }
}
