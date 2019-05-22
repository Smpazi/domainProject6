package com.mpazi.factory.users.factory;

import com.mpazi.domain.users.Nurse;
import org.junit.Test;

import static org.junit.Assert.*;

public class NurseFactoryTest {

    @Test
    public void getNurseTest(){
        Nurse nurse =NurseFactory.getNurse("wound cleaner");

        assertEquals("wound cleaner",nurse.getNursing_Department());

    }

}