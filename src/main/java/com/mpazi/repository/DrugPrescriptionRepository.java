package com.mpazi.repository;

import com.mpazi.domain.DrugPrescription;

import java.util.Set;

public interface DrugPrescriptionRepository extends IRepository<DrugPrescription, String> {
    Set<DrugPrescription> getAll();

}
