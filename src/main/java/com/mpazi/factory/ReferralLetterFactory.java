package com.mpazi.factory;

import com.mpazi.domain.ReferralLetter;

public class ReferralLetterFactory {

    public static ReferralLetter getReferralLetter(String docName){
        return new ReferralLetter.Builder().referral_doctorName(docName)
                .build();

    }
}
