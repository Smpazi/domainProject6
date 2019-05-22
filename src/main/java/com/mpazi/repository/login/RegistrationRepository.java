package com.mpazi.repository.login;

import com.mpazi.domain.login.Registration;
import com.mpazi.repository.IRepository;

import java.util.Map;

public interface RegistrationRepository extends IRepository<Registration, String> {
    Map<String, Registration> getAll();

}
