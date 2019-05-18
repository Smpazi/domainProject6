package com.mpazi.factory.template.factory;

import com.mpazi.domain.template.ReferralLetterTemplete;
import com.mpazi.factory.template.factory.ReferralLetterTemplateFactory;
import org.junit.Test;

public class ReferralLetterTempleteFactoryTest {
    @Test
    public void getReferralLetterTest(){

        ReferralLetterTemplete letter = ReferralLetterTemplateFactory.getReferralLetter("Dr. Yang");

        assertEquals("Dr. Yang",letter.getReferral_doctorName());
    }

}