package com.mpazi.repository.implementation.login;

import com.mpazi.domain.register.login.LoginAccount;
import com.mpazi.repository.login.LoginAccountRepository;

import java.util.HashSet;
import java.util.Set;

public class LoginAccountRepositoryImpl implements LoginAccountRepository {

    private  static  LoginAccountRepositoryImpl repository = null;
    private Set<LoginAccount> loginAccounts;


    private LoginAccountRepositoryImpl(){
        this.loginAccounts = new HashSet<>();
    }

    public static LoginAccountRepositoryImpl getRepository(){
        if(repository == null)
            repository = new LoginAccountRepositoryImpl();
        return repository;
    }

    @Override
    public Set<LoginAccount> getAll() {
        return this.loginAccounts;
    }

    @Override
    public LoginAccount create(LoginAccount loginAccount) {
        this.loginAccounts.add(loginAccount);
        return loginAccount;
    }

    @Override
    public LoginAccount update(LoginAccount loginAccount) {
        loginAccounts.add(loginAccount);
        LoginAccount saveLoginAcc = loginAccount;
        return saveLoginAcc;
    }

    @Override
    public LoginAccount read(String s) {
       // LoginAccount loginAccount= s
        return null;
    }

    @Override
    public void delete(String s) {
        this.loginAccounts.remove(s);
    }
}
