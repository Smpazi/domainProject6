package com.mpazi.service.login;

import com.mpazi.domain.login.Registration;
import com.mpazi.service.IService;

import java.util.Set;

public interface RegistrationService extends IService<Registration, String> {
    Set<Registration> getAll();

}
