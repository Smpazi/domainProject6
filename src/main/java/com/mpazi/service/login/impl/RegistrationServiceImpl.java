package com.mpazi.service.login.impl;

import com.mpazi.domain.login.Registration;
import com.mpazi.repository.login.RegistrationRepository;
import com.mpazi.repository.login.impl.RegistrationRepositoryImpl;
import com.mpazi.service.login.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service ("ServiceImpRegistration")
public class RegistrationServiceImpl implements RegistrationService {

    @Qualifier("InMemoryRegistration")
    private  static RegistrationServiceImpl service = null;

    RegistrationRepository repository = RegistrationRepositoryImpl.getRepository();

    public static RegistrationServiceImpl getInstance(){
        if(service == null)
            service =new RegistrationServiceImpl();
        return service;
    }

    @Override
    public Map<String, Registration> getAll() {
        return repository.getAll();
    }

    @Override
    public Registration create(Registration registration) {
        return repository.create(registration);
    }

    @Override
    public Registration update(Registration registration) {
        return repository.update(registration);
    }

    @Override
    public void delete(String s) {

        repository.delete(s);
    }

    @Override
    public Registration read(String s) {
        return repository.read(s);
    }
}
