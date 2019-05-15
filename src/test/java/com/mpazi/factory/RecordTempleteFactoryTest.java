package com.mpazi.factory;

import com.mpazi.domain.templete.RecordTemplete;
import com.mpazi.factory.other.factory.RecordTempleteFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecordTempleteFactoryTest {
    @Test
    public void getRecordTempleteTest(){
        RecordTemplete recordTemplete = RecordTempleteFactory.getRecordTemplete("Write patient note record");

        assertEquals("Write patient note record",recordTemplete.getTempleteNote());
    }

}