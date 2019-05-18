package com.mpazi.factory.login.factory;

import com.mpazi.domain.login.Role;

import java.util.Map;

public class RoleFactory {

    public static Role getRoleFactory(Map<String, String> values){
        return new Role.Builder()
                .roleTitle(values.get("RoleTitle"))
                .roleDescription(values.get("Role_Description"))
                .build();
    }
}
