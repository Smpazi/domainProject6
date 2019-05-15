package com.mpazi.factory.login.factory;

import com.mpazi.domain.login.Role;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoleFactoryTest {

    @Test
    public void getRole(){
        Role role =RoleFactory.getRoleFactory(223);

        assertEquals(223,role.getRoleId());
    }

}