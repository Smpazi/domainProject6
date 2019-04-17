package com.mpazi.factory;

import com.mpazi.domain.TreatmentHistory;
import org.junit.Assert;
import org.junit.Test;

public class TreatmentHistoryFactoryTest {

    @Test
    public void getTreatmentHistoryTest() {

        TreatmentHistory treatment= TreatmentHistoryFactory.getTreatment("2 treatment in 2 weeks");
        System.out.println(treatment.getDrugDosage());
        Assert.assertEquals("2 treatment in 2 weeks",treatment.getDrugDosage());

    }

}