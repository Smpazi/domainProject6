package com.mpazi.repository.login.impl;

import com.mpazi.domain.login.LoginAccount;
import com.mpazi.repository.login.LoginAccountRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository("InMemoryLoginAccount")

public class LoginAccountRepositoryImpl implements LoginAccountRepository {

    private  static  LoginAccountRepositoryImpl repository = null;
    private Map<String, LoginAccount> loginAccounts;

    private LoginAccountRepositoryImpl(){
        this.loginAccounts = new HashMap<>();
    }

    public static LoginAccountRepositoryImpl getRepository(){
        if(repository == null)
            repository = new LoginAccountRepositoryImpl();
        return repository;
    }

    @Override
    public Map<String, LoginAccount> getAll() {
        return this.loginAccounts;
    }

    @Override
    public LoginAccount create(LoginAccount loginAccount) {
        loginAccounts.put(loginAccount.getStaffId(),loginAccount);
        LoginAccount savedLogIn = loginAccounts.get(loginAccount.getStaffId());
        return savedLogIn;
    }

    @Override
    public LoginAccount update(LoginAccount loginAccount) {
        loginAccounts.put(loginAccount.getStaffId(),loginAccount);
        LoginAccount savedLogIn = loginAccounts.get(loginAccount.getStaffId());
        return savedLogIn;
    }

    @Override
    public LoginAccount read(final String loginId) {
       LoginAccount loginAccount= loginAccounts.get(loginId);
        return loginAccount;
    }

    @Override
    public void delete(String loginId) {
        if(loginId !=null)
        this.loginAccounts.remove(loginId);
    }
}
