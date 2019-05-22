package com.mpazi.service.login.impl;

import com.mpazi.domain.login.Role;
import com.mpazi.repository.login.RoleRepository;
import com.mpazi.repository.login.impl.RoleRepositoryImpl;
import com.mpazi.service.login.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service  ("ServiceImpRole")
public class RoleServiceImpl implements RoleService {

    @Autowired
    @Qualifier("InMemoryRole")
    private  static RoleServiceImpl service = null;

    RoleRepository repository = RoleRepositoryImpl.getRepository();

    public static RoleServiceImpl getInstance(){
        if(service == null)
            service =new RoleServiceImpl();
        return service;
    }
    @Override
    public Map<String, Role> getAll() {
        return repository.getAll();
    }

    @Override
    public Role create(Role role) {
        return repository.create(role);
    }

    @Override
    public Role update(Role role) {
        return repository.update(role);
    }

    @Override
    public void delete(String s) {

        repository.delete(s);
    }

    @Override
    public Role read(String s) {
        return repository.read(s);
    }
}
