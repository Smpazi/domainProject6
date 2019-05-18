package com.mpazi.repository.medication;

import com.mpazi.domain.medication.Pill;
import com.mpazi.repository.IRepository;

import java.util.Set;

public interface PillRepository extends IRepository<Pill, String> {
    Set<Pill> getAll();
}
