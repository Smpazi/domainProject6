package com.mpazi.factory.patient.record.factory;

import com.mpazi.domain.patient.record.CheckUpRecord;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckUpRecordFactoryTest {

    @Test
    public void getCheckUpRecordTest(){

        CheckUpRecord upRecord =CheckUpRecordFactory.getCheckUpRecord("all wound related records");

        assertEquals("all wound related records",upRecord.getCheckUpRecordName());
    }

}