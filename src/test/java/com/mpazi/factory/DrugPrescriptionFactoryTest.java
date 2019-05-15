package com.mpazi.factory;

import com.mpazi.domain.medication.DrugPrescription;
import com.mpazi.factory.other.factory.DrugPrescriptionFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class DrugPrescriptionFactoryTest {
    Map<String,String> values;
    @Before
    public void setUp() throws Exception {
        values = new HashMap<>();
        values.put("drug_prescriptionId", "123");
        values.put("drugName","Panado");
    }

    @Test
    public void getDrugPrescriptionTest(){
        DrugPrescription drugPrescription = DrugPrescriptionFactory.getDrugPrescription(values,"Headache");

        assertEquals("Headache",drugPrescription.getDrugType());
    }

}