package com.mpazi.service.login.impl;

import com.mpazi.domain.login.LoginAccount;
import com.mpazi.repository.login.LoginAccountRepository;
import com.mpazi.repository.login.impl.LoginAccountRepositoryImpl;
import com.mpazi.service.login.LoginAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service ("ServiceImpLoginAccount")
public class LoginAccountServiceImpl implements LoginAccountService {

    @Qualifier("InMemoryLoginAccount")
    private  static LoginAccountServiceImpl service = null;

    LoginAccountRepository repository = LoginAccountRepositoryImpl.getRepository();

    public static LoginAccountServiceImpl getInstance(){
        if(service == null)
            service =new LoginAccountServiceImpl();
        return service;
    }

    @Override
    public Map<String, LoginAccount> getAll() {
        return repository.getAll();
    }

    @Override
    public LoginAccount create(LoginAccount loginAccount) {
        return repository.create(loginAccount);
    }

    @Override
    public LoginAccount update(LoginAccount loginAccount) {
        return repository.update(loginAccount);
    }

    @Override
    public void delete(String s) {

        repository.delete(s);
    }

    @Override
    public LoginAccount read(String s) {
        return repository.read(s);
    }
}
