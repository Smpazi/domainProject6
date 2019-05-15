package com.mpazi.repository.other;

import com.mpazi.domain.templete.RecordTemplete;
import com.mpazi.repository.IRepository;

import java.util.Set;

public interface RecordTempleteRepository extends IRepository<RecordTemplete, String> {
    Set<RecordTemplete> getAll();
}
