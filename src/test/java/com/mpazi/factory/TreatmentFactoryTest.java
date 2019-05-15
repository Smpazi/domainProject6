package com.mpazi.factory;

import com.mpazi.domain.templete.Treatment;
import com.mpazi.factory.other.factory.TreatmentFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TreatmentFactoryTest {
    Map<String,String> values;
    @Before
    public void setUp() throws Exception {
        values = new HashMap<>();
        values.put("treatment_ID", "789");
    }

    @Test
    public void getTreatmentHistoryTest() {

        Treatment treatment= TreatmentFactory.getTreatment(values,233);
        System.out.println(treatment.getDrugDosage());
        Assert.assertEquals(233,treatment.getDrugDosage());

    }

}