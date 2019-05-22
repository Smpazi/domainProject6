package com.mpazi.repository.login.impl;

import com.mpazi.domain.login.Registration;
import com.mpazi.repository.login.RegistrationRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository("InMemoryRegistration")

public class RegistrationRepositoryImpl implements RegistrationRepository {

    private  static  RegistrationRepositoryImpl repository = null;
    private Map<String,Registration> registrations;

    private RegistrationRepositoryImpl(){
        this.registrations = new HashMap<>();
    }

    public static RegistrationRepositoryImpl getRepository(){
        if(repository == null)
            repository = new RegistrationRepositoryImpl();
        return repository;
    }

    @Override
    public Map<String, Registration> getAll() {
        return this.registrations;
    }

    @Override
    public Registration create(Registration registration) {
        registrations.put(registration.getReg_Id(),registration);
        Registration savedReg = registrations.get(registration.getReg_Id());
        return savedReg;
    }

    @Override
    public Registration update(Registration registration) {
        registrations.put(registration.getReg_Id(),registration);
        Registration savedReg = registrations.get(registration.getReg_Id());
        return savedReg;
    }

    @Override
    public Registration read(String s) {
        Registration registration = registrations.get(s);
        return registration;
    }

    @Override
    public void delete(String s) {
        registrations.remove(s);
    }
}
