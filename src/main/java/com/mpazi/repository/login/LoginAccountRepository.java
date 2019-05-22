package com.mpazi.repository.login;

import com.mpazi.domain.login.LoginAccount;
import com.mpazi.repository.IRepository;

import java.util.Map;

public interface LoginAccountRepository extends IRepository<LoginAccount, String> {
    Map<String, LoginAccount> getAll();

}
