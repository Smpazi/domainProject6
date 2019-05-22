package com.mpazi.service.login;

import com.mpazi.domain.login.Registration;
import com.mpazi.service.IService;

import java.util.Map;

public interface RegistrationService extends IService<Registration, String> {
    Map<String, Registration> getAll();

}
