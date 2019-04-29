package com.mpazi.factory.record.factory;

import com.mpazi.domain.patient.record.Consultation;
import com.mpazi.util.Misc;

public class ConsultationFactory {

    public static Consultation getConsultation(String descrip){
        return new Consultation.Builder().consultId(Misc.generateId())
                .consult_description(descrip)
                .build();

    }
}
