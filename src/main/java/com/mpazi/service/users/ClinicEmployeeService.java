package com.mpazi.service.users;

import com.mpazi.domain.users.ClinicEmployee;
import com.mpazi.service.IService;

import java.util.Set;

public interface ClinicEmployeeService extends IService<ClinicEmployee, String> {

    Set<ClinicEmployee> getAll();
}
