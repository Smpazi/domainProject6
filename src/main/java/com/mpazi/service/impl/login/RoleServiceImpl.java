package com.mpazi.service.impl.login;

import com.mpazi.domain.login.Role;
import com.mpazi.repository.login.RoleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RoleServiceImpl implements RoleRepository {

    private  static RoleServiceImpl repository = null;
   private List<Role> roleList;

    private RoleServiceImpl(){
        this.roleList = new ArrayList<>();
    }

    public static RoleServiceImpl getRepository(){
        if(repository == null)
            repository = new RoleServiceImpl();
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
