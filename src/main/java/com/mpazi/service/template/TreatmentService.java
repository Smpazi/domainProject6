package com.mpazi.service.template;

import com.mpazi.domain.template.Treatment;
import com.mpazi.service.IService;

import java.util.Set;

public interface TreatmentService extends IService<Treatment, String> {
    Set<Treatment> getAll();
}
