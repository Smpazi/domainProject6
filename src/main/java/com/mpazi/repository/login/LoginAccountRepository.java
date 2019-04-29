package com.mpazi.repository.login;

import com.mpazi.domain.register.login.LoginAccount;
import com.mpazi.repository.IRepository;

import java.util.Set;

public interface LoginAccountRepository extends IRepository<LoginAccount, String> {
    Set<LoginAccount> getAll();

}
