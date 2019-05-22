package com.mpazi.repository.information;

import com.mpazi.domain.information.Consultation;
import com.mpazi.repository.IRepository;

import java.util.Map;

public interface ConsultationRepository extends IRepository<Consultation , String> {
    Map<String, Consultation> getAll();
}
