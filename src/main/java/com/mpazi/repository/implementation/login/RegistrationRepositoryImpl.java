package com.mpazi.repository.implementation.login;

import com.mpazi.domain.register.login.Registration;
import com.mpazi.repository.login.RegistrationRepository;

import java.util.HashSet;
import java.util.Set;

public class RegistrationRepositoryImpl implements RegistrationRepository {

    private  static  RegistrationRepositoryImpl repository = null;
    private Set<Registration> registrations;

    private RegistrationRepositoryImpl(){
        this.registrations = new HashSet<>();
    }

    public static RegistrationRepositoryImpl getRepository(){
        if(repository == null)
            repository = new RegistrationRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Registration> getAll() {
        return this.registrations;
    }

    @Override
    public Registration create(Registration registration) {
        this.registrations.add(registration);
        return null;
    }

    @Override
    public Registration update(Registration registration) {
        return null;
    }

    @Override
    public Registration read(String s) {
        return null;
    }

    @Override
    public void delete(String s) {


    }
}
