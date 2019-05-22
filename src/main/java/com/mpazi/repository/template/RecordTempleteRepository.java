package com.mpazi.repository.template;

import com.mpazi.domain.template.RecordTemplete;
import com.mpazi.repository.IRepository;

import java.util.Map;

public interface RecordTempleteRepository extends IRepository<RecordTemplete, String> {
    Map<String, RecordTemplete> getAll();
}
