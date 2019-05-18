package com.mpazi.service.information;

import com.mpazi.domain.information.Consultation;
import com.mpazi.service.IService;

import java.util.Set;

public interface ConsultationService extends IService<Consultation , String> {

    Set<Consultation> getAll();
}
