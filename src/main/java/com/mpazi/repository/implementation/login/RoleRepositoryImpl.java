package com.mpazi.repository.implementation.login;

import com.mpazi.domain.login.Role;
import com.mpazi.repository.login.RoleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RoleRepositoryImpl implements RoleRepository {

    private  static  RoleRepositoryImpl repository = null;
   private List<Role> roleList;

    private RoleRepositoryImpl(){
        this.roleList = new ArrayList<>();
    }

    public static RoleRepositoryImpl getRepository(){
        if(repository == null)
            repository = new RoleRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Role> getAll() {
        return null;
    }

    @Override
    public Role create(Role role) {
        this.roleList.add(role);
        return role;
    }

    @Override
    public Role update(Role role) {
        return null;
    }

    @Override
    public Role read(String s) {
        return null;
    }

    @Override
    public void delete(String s) {
        roleList.remove(s);
    }
}
