package com.mpazi.factory.login.factory;

import com.mpazi.domain.register.login.Role;

public class RoleFactory {

    public static Role getRoleFactory(int roleId){
        return new Role.Builder().roleId(roleId)
                .build();
    }
}
