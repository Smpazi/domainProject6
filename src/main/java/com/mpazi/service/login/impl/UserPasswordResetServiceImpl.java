package com.mpazi.service.login.impl;

import com.mpazi.domain.login.UserPasswordReset;
import com.mpazi.repository.login.UserPasswordResetRepository;
import com.mpazi.repository.login.impl.UserPasswordResetRepositoryImpl;
import com.mpazi.service.login.UserPasswordResetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service  ("ServiceImpUserPasswordReset")
public class UserPasswordResetServiceImpl implements UserPasswordResetService {

    @Qualifier("InMemoryUserPasswordReset")
    private  static UserPasswordResetServiceImpl service = null;

    UserPasswordResetRepository repository = UserPasswordResetRepositoryImpl.getRepository();

    public static UserPasswordResetServiceImpl getInstance(){
        if(service == null)
            service =new UserPasswordResetServiceImpl();
        return service;
    }
    @Override
    public Map<String, UserPasswordReset> getAll() {
        return repository.getAll();
    }

    @Override
    public UserPasswordReset create(UserPasswordReset userPasswordReset) {
        return repository.create(userPasswordReset);
    }

    @Override
    public UserPasswordReset update(UserPasswordReset userPasswordReset) {
        return repository.update(userPasswordReset);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }

    @Override
    public UserPasswordReset read(String s) {
        return repository.read(s);
    }
}
