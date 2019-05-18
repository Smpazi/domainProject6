package com.mpazi.repository.login.impl;

import com.mpazi.domain.login.UserPasswordReset;
import com.mpazi.repository.login.UserPasswordResetRepository;

import java.util.HashSet;
import java.util.Set;

public class UserPasswordResetRepositoryImpl implements UserPasswordResetRepository {

    private  static  UserPasswordResetRepositoryImpl repository = null;
   private Set<UserPasswordReset> userPasswordResets;

    private UserPasswordResetRepositoryImpl(){
        this.userPasswordResets = new HashSet<>();
    }

    public static UserPasswordResetRepositoryImpl getRepository(){
        if(repository == null)
            repository = new UserPasswordResetRepositoryImpl();
        return repository;
    }

    @Override
    public Set<UserPasswordReset> getAll() {
        return this.userPasswordResets;
    }

    @Override
    public UserPasswordReset create(UserPasswordReset userPasswordReset) {
        this.userPasswordResets.add(userPasswordReset);
        return userPasswordReset;
    }

    @Override
    public UserPasswordReset update(UserPasswordReset userPasswordReset) {
        return userPasswordReset;
    }

    @Override
    public UserPasswordReset read(String s) {
        return null;
    }

    @Override
    public void delete(String s) {
        this.userPasswordResets.remove(s);
    }
}
