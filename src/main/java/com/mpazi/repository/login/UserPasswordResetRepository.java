package com.mpazi.repository.login;

import com.mpazi.domain.login.UserPasswordReset;
import com.mpazi.repository.IRepository;

import java.util.Map;

public interface UserPasswordResetRepository extends IRepository<UserPasswordReset, String> {
    Map<String, UserPasswordReset> getAll();

}
