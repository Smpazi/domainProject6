package com.mpazi.service.users;

import com.mpazi.domain.users.ClinicEmployee;
import com.mpazi.service.IService;

import java.util.Map;

public interface ClinicEmployeeService extends IService<ClinicEmployee, String> {

    Map<String, ClinicEmployee> getAll();
}
