package com.mpazi.factory.patient.record.factory;

import com.mpazi.domain.patient.record.ViewPatientRecord;
import org.junit.Test;

import static org.junit.Assert.*;

public class ViewPatientRecordFactoryTest {
    @Test
    public void getViewPatientRecordTest(){

        ViewPatientRecord viewPatientRecord =ViewPatientRecordFactory.getViewPatientRecord();

        assertNotNull(viewPatientRecord.getRecordId());

        System.out.println(viewPatientRecord.getRecordId());


    }

}