package com.mpazi.service.users.impl;

import com.mpazi.domain.users.ClinicEmployee;
import com.mpazi.repository.users.ClinicEmployeeRepository;
import com.mpazi.repository.users.impl.ClinicEmployeeRepositoryImpl;
import com.mpazi.service.users.ClinicEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service ("ServiceImpClinicEmployee")
public class ClinicEmployeeServiceImpl implements ClinicEmployeeService {
    @Autowired
    @Qualifier("InMemoryClinicEmployee")
    private  static ClinicEmployeeServiceImpl service = null;

    ClinicEmployeeRepository repository = ClinicEmployeeRepositoryImpl.getRepository();

    public static ClinicEmployeeServiceImpl getInstance(){
        if(service == null)
            service =new ClinicEmployeeServiceImpl();
        return service;
    }
    @Override
    public ClinicEmployee create(ClinicEmployee clinicEmployee) {
        return repository.create(clinicEmployee);
    }

    @Override
    public ClinicEmployee update(ClinicEmployee clinicEmployee) {
        return repository.update(clinicEmployee);
    }

    @Override
    public void delete(String s) {

        repository.delete(s);
    }

    @Override
    public ClinicEmployee read(String s) {
        return repository.read(s);
    }

    @Override
    public Map<String, ClinicEmployee> getAll() {
        return repository.getAll();
    }
}
