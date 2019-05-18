package com.mpazi.factory.information.factory;

import com.mpazi.domain.information.CheckUpRecord;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckUpRecordFactoryTest {

    @Test
    public void getCheckUpRecordTest(){

        CheckUpRecord upRecord =CheckUpRecordFactory.getCheckUpRecord("all wound related records");

        assertEquals("all wound related records",upRecord.getCheckUpRecordName());
    }

}