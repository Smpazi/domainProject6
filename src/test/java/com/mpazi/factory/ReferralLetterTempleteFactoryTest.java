package com.mpazi.factory;

import com.mpazi.domain.templete.ReferralLetterTemplete;
import com.mpazi.factory.other.factory.ReferralLetterTemplateFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReferralLetterTempleteFactoryTest {
    @Test
    public void getReferralLetterTest(){

        ReferralLetterTemplete letter = ReferralLetterTemplateFactory.getReferralLetter("Dr. Yang");

        assertEquals("Dr. Yang",letter.getReferral_doctorName());
    }

}