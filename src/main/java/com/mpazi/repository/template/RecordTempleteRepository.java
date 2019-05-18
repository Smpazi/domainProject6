package com.mpazi.repository.template;

import com.mpazi.domain.template.RecordTemplete;
import com.mpazi.repository.IRepository;

import java.util.Set;

public interface RecordTempleteRepository extends IRepository<RecordTemplete, String> {
    Set<RecordTemplete> getAll();
}
