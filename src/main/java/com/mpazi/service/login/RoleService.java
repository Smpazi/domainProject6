package com.mpazi.service.login;

import com.mpazi.domain.login.Role;
import com.mpazi.service.IService;

import java.util.Set;

public interface RoleService extends IService<Role, String> {
    Set<Role> getAll();

}
