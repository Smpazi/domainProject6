package com.mpazi.factory.information.factory;

import com.mpazi.domain.information.CheckUpRecord;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CheckUpRecordFactoryTest {

    Map<String, String> values;
    @Before
    public void setUp() throws Exception {

        values = new HashMap<>();
        values.put("CheckUpRecordName","Treatments");
    //    values.put("CheckUpDescription","23/April/2011");

    }
    @Test
    public void getCheckUpRecordTest() {

        CheckUpRecord check = CheckUpRecordFactory.getCheckUpRecord(values);

        Assert.assertEquals("Treatments",check.getCheckUpRecordName());

    }
}