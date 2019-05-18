package com.mpazi.factory.information.factory;

import com.mpazi.domain.information.Consultation;
import com.mpazi.util.Misc;

import java.util.Map;

public class ConsultationFactory {

    public static Consultation getConsultation(Map<String, String> values){
        return new Consultation.Builder()
                .consult_description(values.get("Consultation_Description"))
                .build();

    }
}
