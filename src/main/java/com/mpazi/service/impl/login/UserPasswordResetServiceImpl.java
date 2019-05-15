package com.mpazi.service.impl.login;

import com.mpazi.domain.login.UserPasswordReset;
import com.mpazi.repository.login.UserPasswordResetRepository;

import java.util.HashSet;
import java.util.Set;

public class UserPasswordResetServiceImpl implements UserPasswordResetRepository {

    private  static UserPasswordResetServiceImpl repository = null;
   private Set<UserPasswordReset> userPasswordResets;

    private UserPasswordResetServiceImpl(){
        this.userPasswordResets = new HashSet<>();
    }

    public static UserPasswordResetServiceImpl getRepository(){
        if(repository == null)
            repository = new UserPasswordResetServiceImpl();
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
