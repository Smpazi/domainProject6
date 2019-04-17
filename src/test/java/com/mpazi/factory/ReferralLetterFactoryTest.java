package com.mpazi.factory;

import com.mpazi.domain.ReferralLetter;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReferralLetterFactoryTest {
    @Test
    public void getReferralLetterTest(){

        ReferralLetter letter =ReferralLetterFactory.getReferralLetter("Dr. Yang");

        assertEquals("Dr. Yang",letter.getReferral_doctorName());
    }

}