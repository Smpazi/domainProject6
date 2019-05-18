package com.mpazi.repository.template;

import com.mpazi.domain.template.Treatment;
import com.mpazi.repository.IRepository;

import java.util.Set;

public interface TreatmentRepository extends IRepository<Treatment, String> {
    Set<Treatment> getAll();
}
