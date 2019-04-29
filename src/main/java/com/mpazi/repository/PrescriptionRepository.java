package com.mpazi.repository;

import com.mpazi.domain.Prescription;

import java.util.Set;

public interface PrescriptionRepository extends IRepository<Prescription, String> {
    Set<Prescription> getAll();
}
