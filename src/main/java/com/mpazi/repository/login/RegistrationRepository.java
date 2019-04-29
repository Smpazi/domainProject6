package com.mpazi.repository.login;

import com.mpazi.domain.register.login.Registration;
import com.mpazi.repository.IRepository;

import java.util.Set;

public interface RegistrationRepository extends IRepository<Registration, String> {
    Set<Registration> getAll();

}
