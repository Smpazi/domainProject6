package com.mpazi.controller.login;

import com.mpazi.domain.login.LoginAccount;
import com.mpazi.service.login.LoginAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;
@RestController
@RequestMapping("/loginAccount")
public class LoginAccountController {
    @Autowired
    @Qualifier("ServiceImpLoginAccount")
    private LoginAccountService service;

    @PostMapping("/create")
    @ResponseBody
    public LoginAccount create(LoginAccount loginAccount) {
        return service.create(loginAccount);
    }

    @PostMapping("/update")
    @ResponseBody
    public LoginAccount update(LoginAccount loginAccount) {
        return service.update(loginAccount);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public LoginAccount read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Map<String, LoginAccount> getAll() {
        return service.getAll();
    }

}
