package com.mpazi.repository.login;

import com.mpazi.domain.login.Role;
import com.mpazi.repository.IRepository;

import java.util.Map;

public interface RoleRepository extends IRepository<Role, String> {
    Map<String, Role> getAll();

}
