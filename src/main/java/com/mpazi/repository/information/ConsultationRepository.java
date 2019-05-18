package com.mpazi.repository.information;

import com.mpazi.domain.information.Consultation;
import com.mpazi.repository.IRepository;

import java.util.Set;

public interface ConsultationRepository extends IRepository<Consultation , String> {
    Set<Consultation> getAll();
}
