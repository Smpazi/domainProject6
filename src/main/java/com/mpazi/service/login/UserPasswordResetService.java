package com.mpazi.service.login;

import com.mpazi.domain.login.UserPasswordReset;
import com.mpazi.service.IService;

import java.util.Map;

public interface UserPasswordResetService extends IService<UserPasswordReset, String> {
    Map<String, UserPasswordReset> getAll();

}
