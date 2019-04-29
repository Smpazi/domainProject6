package com.mpazi.repository.implementation.users;

import com.mpazi.domain.users.ClinicEmployee;
import com.mpazi.repository.users.ClinicEmployeeRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClinicEmployeeRepositoryImpl implements ClinicEmployeeRepository {

    private  static  ClinicEmployeeRepositoryImpl repository = null;
    private Set<ClinicEmployee> clinicEmployeeList;

    private ClinicEmployeeRepositoryImpl(){
       this.clinicEmployeeList = new HashSet<>();
    }

    public static ClinicEmployeeRepositoryImpl getRepository(){
        if(repository == null)
            repository = new ClinicEmployeeRepositoryImpl();
        return repository;
    }

    @Override
    public ClinicEmployee create(ClinicEmployee clinicEmployee) {
        clinicEmployeeList.add(clinicEmployee);
        return clinicEmployee;
    }

    @Override
    public ClinicEmployee update(ClinicEmployee clinicEmployee) {
        clinicEmployeeList.add(clinicEmployee);
        return clinicEmployee;
    }

    @Override
    public ClinicEmployee read(String s) {
        return null;
    }

    @Override
    public void delete(String emp_Id) {
        clinicEmployeeList.remove(emp_Id);
    }
}
