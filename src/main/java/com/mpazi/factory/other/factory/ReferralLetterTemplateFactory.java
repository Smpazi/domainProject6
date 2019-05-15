package com.mpazi.factory.other.factory;

import com.mpazi.domain.templete.ReferralLetterTemplete;

public class ReferralLetterTemplateFactory {

    public static ReferralLetterTemplete getReferralLetter(String docName){
        return new ReferralLetterTemplete.Builder().referral_doctorName(docName)
                .build();

    }
}
