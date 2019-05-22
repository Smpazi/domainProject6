package com.mpazi.factory.template.factory;

import com.mpazi.domain.template.ReferralLetterTemplate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ReferralLetterTemplateFactoryTest {
    Map<String, String> values;
    @Before
    public void setUp() throws Exception {

        values = new HashMap<>();
        values.put("Referral_HospitalName","Tygerburg Hospital");

    }
    @Test
    public void getReferralLetterTest() {

        ReferralLetterTemplate referralLetter= ReferralLetterTemplateFactory.getReferralLetter(values);

        Assert.assertEquals("Tygerburg Hospital", referralLetter.getReferral_HospitalName());

    }
}