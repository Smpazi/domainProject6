package com.mpazi.service.login;

import com.mpazi.domain.login.LoginAccount;
import com.mpazi.service.IService;

import java.util.Map;

public interface LoginAccountService extends IService<LoginAccount, String> {
    Map<String, LoginAccount> getAll();

}
