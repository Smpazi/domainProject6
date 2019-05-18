package com.mpazi.repository.login.impl;

import com.mpazi.domain.login.LoginAccount;
import com.mpazi.repository.login.LoginAccountRepository;

import java.util.HashSet;
import java.util.Set;

public class LoginAccountRepositoryImpl implements LoginAccountRepository {

    private  static  LoginAccountRepositoryImpl repository = null;
    private Set<LoginAccount> loginAccounts;


    private LoginAccountRepositoryImpl(){
        this.loginAccounts = new HashSet<>();
    }

    private LoginAccount findAccount(String loginAccountId){
        return  this.loginAccounts.stream()
                .filter(loginAccount -> loginAccount.getStaffId().trim().equals(loginAccountId))
                .findAny()
                .orElse(null);
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
        LoginAccount saveLoginAcc = findAccount(loginAccount.getStaffId());
        if(saveLoginAcc != null){
            this.loginAccounts.remove(saveLoginAcc);
            return create(loginAccount);
        }
        return null;
    }

    @Override
    public LoginAccount read(final String loginId) {
       LoginAccount loginAccount= findAccount(loginId);
        return loginAccount;
    }

    @Override
    public void delete(String loginId) {
        LoginAccount loginAccount= findAccount(loginId);
        if(loginAccount !=null)
        this.loginAccounts.remove(loginAccount);
    }
}
