package com.mpazi.repository.medication;

import com.mpazi.domain.medication.Pill;
import com.mpazi.repository.IRepository;

import java.util.Map;

public interface PillRepository extends IRepository<Pill, String> {
    Map<String, Pill> getAll();
}
