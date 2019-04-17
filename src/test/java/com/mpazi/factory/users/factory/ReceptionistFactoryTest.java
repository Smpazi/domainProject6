package com.mpazi.factory.users.factory;

import com.mpazi.domain.users.Receptionist;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReceptionistFactoryTest {
    @Test
    public void getReceptionistTest(){

        Receptionist receptionist =ReceptionistFactory.getReceptionist("AddPatient");

        assertEquals("AddPatient",receptionist.getJob_type());
    }

}