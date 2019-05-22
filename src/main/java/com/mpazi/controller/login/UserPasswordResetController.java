package com.mpazi.controller.login;

import com.mpazi.domain.login.UserPasswordReset;
import com.mpazi.service.login.UserPasswordResetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;
@RestController
@RequestMapping("/userPasswordReset")
public class UserPasswordResetController {

    @Autowired
    @Qualifier("ServiceImpUserPasswordReset")
    private UserPasswordResetService service;

    @PostMapping("/create")
    @ResponseBody
    public UserPasswordReset create(UserPasswordReset userPasswordReset) {
        return service.create(userPasswordReset);
    }

    @PostMapping("/update")
    @ResponseBody
    public UserPasswordReset update(UserPasswordReset userPasswordReset) {
        return service.update(userPasswordReset);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public UserPasswordReset read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Map<String, UserPasswordReset> getAll() {
        return service.getAll();
    }

}
