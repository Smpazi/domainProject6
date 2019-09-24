package com.mpazi.repository.login.impl;

import com.mpazi.domain.login.Role;
import com.mpazi.repository.login.RoleRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository("InMemoryRole")
public class RoleRepositoryImpl implements RoleRepository {

    private  static  RoleRepositoryImpl repository = null;
   private Map<String, Role> roleList;

    private RoleRepositoryImpl(){
        this.roleList = new HashMap<>();
    }

    public static RoleRepositoryImpl getRepository(){
        if(repository == null)
            repository = new RoleRepositoryImpl();
        return repository;
    }

    @Override
    public Map<String, Role> getAll() {
        return roleList;
    }

    @Override
    public Role create(Role role) {
        roleList.put(role.getRoleTitle(),role);
        Role savedRole = roleList.get(role.getRoleTitle());
        return savedRole;
    }

    @Override
    public Role update(Role role) {
        roleList.put(role.getRoleTitle(),role);
        Role savedRole = roleList.get(role.getRoleTitle());
        return savedRole;
    }

    @Override
    public Role read(String s) {
        Role role = roleList.get(s);
        return role;
    }

    @Override
    public void delete(String s) {
        roleList.remove(s);
    }
}
