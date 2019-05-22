package com.mpazi.factory.template.factory;

import com.mpazi.domain.template.RecordTemplete;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class RecordTempleteFactoryTest {

    Map<String, String> values;
    @Before
    public void setUp() throws Exception {

        values = new HashMap<>();


    }
    @Test
    public void getRecordTempleteTest() {

        RecordTemplete recordTemplete=  RecordTempleteFactory.getRecordTemplete(values,3);

        Assert.assertEquals(3,recordTemplete.getTimeVisit());

    }
}