package com.mpazi.factory.login.factory;

import com.mpazi.domain.login.LoginAccount;

import java.util.Map;

public class LoginAccountFactory {

    public static LoginAccount getLoginAccount(Map<String, String> values, int pass){
        return new LoginAccount.Builder()
                .staffId(values.get("StaffId"))
                .password(pass)
                .build();

    }
}
