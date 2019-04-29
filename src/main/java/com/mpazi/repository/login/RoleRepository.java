package com.mpazi.repository.login;

import com.mpazi.domain.register.login.Role;
import com.mpazi.repository.IRepository;

import java.util.Set;

public interface RoleRepository extends IRepository<Role, String> {
    Set<Role> getAll();

}
