package com.mpazi.service.login;

import com.mpazi.domain.login.LoginAccount;
import com.mpazi.service.IService;

import java.util.Set;

public interface LoginAccountService extends IService<LoginAccount, String> {
    Set<LoginAccount> getAll();

}
