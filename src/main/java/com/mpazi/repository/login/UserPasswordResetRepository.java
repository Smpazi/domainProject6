package com.mpazi.repository.login;

import com.mpazi.domain.register.login.UserPasswordReset;
import com.mpazi.repository.IRepository;

import java.util.Set;

public interface UserPasswordResetRepository extends IRepository<UserPasswordReset, String> {
    Set<UserPasswordReset> getAll();

}
