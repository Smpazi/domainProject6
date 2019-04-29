package com.mpazi.repository;

import com.mpazi.domain.RecordTemplete;

import java.util.Set;

public interface RecordTempleteRepository extends IRepository<RecordTemplete, String> {
    Set<RecordTemplete> getAll();
}
