package com.mpazi.repository.users.impl;

import com.mpazi.domain.users.ClinicEmployee;
import com.mpazi.repository.users.ClinicEmployeeRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
@Repository("InMemoryClinicEmployee")
public class ClinicEmployeeRepositoryImpl implements ClinicEmployeeRepository {

    private  static  ClinicEmployeeRepositoryImpl repository = null;
    private Map<String,ClinicEmployee> clinicEmployeeList;

    private ClinicEmployeeRepositoryImpl(){
       this.clinicEmployeeList = new HashMap<>();
    }

    public static ClinicEmployeeRepositoryImpl getRepository(){
        if(repository == null)
            repository = new ClinicEmployeeRepositoryImpl();
        return repository;
    }

    @Override
    public ClinicEmployee create(ClinicEmployee clinicEmployee) {
        clinicEmployeeList.put(clinicEmployee.getEmp_Id(),clinicEmployee);
        ClinicEmployee savedTrans = clinicEmployeeList.get(clinicEmployee.getEmp_Id());
        return savedTrans;
    }

    @Override
    public ClinicEmployee update(ClinicEmployee clinicEmployee) {
        clinicEmployeeList.put(clinicEmployee.getEmp_Id(),clinicEmployee);
        ClinicEmployee savedTrans = clinicEmployeeList.get(clinicEmployee.getEmp_Id());
        return savedTrans;
    }

    @Override
    public ClinicEmployee read(String s) {
        ClinicEmployee clinicEmployee = clinicEmployeeList.get(s);
        return clinicEmployee;
    }

    @Override
    public void delete(String emp_Id) {
        clinicEmployeeList.remove(emp_Id);
    }

    @Override
    public Map<String, ClinicEmployee> getAll() {
        return clinicEmployeeList;
    }
}
