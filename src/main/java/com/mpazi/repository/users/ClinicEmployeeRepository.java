package com.mpazi.repository.users;

import com.mpazi.domain.users.ClinicEmployee;
import com.mpazi.repository.IRepository;

import java.util.Map;

public interface ClinicEmployeeRepository extends IRepository<ClinicEmployee, String> {
Map<String, ClinicEmployee> getAll();

}
