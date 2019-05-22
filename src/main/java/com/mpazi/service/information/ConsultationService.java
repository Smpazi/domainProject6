package com.mpazi.service.information;

import com.mpazi.domain.information.Consultation;
import com.mpazi.service.IService;

import java.util.Map;

public interface ConsultationService extends IService<Consultation , String> {

    Map<String, Consultation> getAll();
}
