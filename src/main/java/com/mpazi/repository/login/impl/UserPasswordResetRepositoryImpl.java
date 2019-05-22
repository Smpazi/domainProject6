package com.mpazi.repository.login.impl;

import com.mpazi.domain.login.UserPasswordReset;
import com.mpazi.repository.login.UserPasswordResetRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository("InMemoryUserPasswordReset")

public class UserPasswordResetRepositoryImpl implements UserPasswordResetRepository {

    private  static  UserPasswordResetRepositoryImpl repository = null;
   private Map<String, UserPasswordReset> userPasswordResets;

    private UserPasswordResetRepositoryImpl(){
        this.userPasswordResets = new HashMap<>();
    }

    public static UserPasswordResetRepositoryImpl getRepository(){
        if(repository == null)
            repository = new UserPasswordResetRepositoryImpl();
        return repository;
    }

    @Override
    public Map<String, UserPasswordReset> getAll() {
        return this.userPasswordResets;
    }

    @Override
    public UserPasswordReset create(UserPasswordReset userPasswordReset) {
        userPasswordResets.put(userPasswordReset.getUserId(),userPasswordReset);
        UserPasswordReset savedPass = userPasswordResets.get(userPasswordReset.getUserId());
        return savedPass;
    }

    @Override
    public UserPasswordReset update(UserPasswordReset userPasswordReset) {
        userPasswordResets.put(userPasswordReset.getUserId(),userPasswordReset);
        UserPasswordReset savedPass = userPasswordResets.get(userPasswordReset.getUserId());
        return savedPass;
    }

    @Override
    public UserPasswordReset read(String s) {
        UserPasswordReset userPasswordReset = userPasswordResets.get(s);
        return userPasswordReset;
    }

    @Override
    public void delete(String s) {
        this.userPasswordResets.remove(s);
    }
}
