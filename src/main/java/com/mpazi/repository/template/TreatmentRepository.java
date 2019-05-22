package com.mpazi.repository.template;

import com.mpazi.domain.template.Treatment;
import com.mpazi.repository.IRepository;

import java.util.Map;

public interface TreatmentRepository extends IRepository<Treatment, String> {
    Map<String, Treatment> getAll();
}
