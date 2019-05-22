package com.mpazi.controller.login;

import com.mpazi.domain.login.Role;
import com.mpazi.service.login.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    @Qualifier("ServiceImpRole")
    private RoleService service;

    @PostMapping("/create")
    @ResponseBody
    public Role create(Role role) {
        return service.create(role);
    }

    @PostMapping("/update")
    @ResponseBody
    public Role update(Role role) {
        return service.update(role);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Role read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Map<String, Role> getAll() {
        return service.getAll();
    }

}
