package com.mpazi.service.template;

import com.mpazi.domain.template.RecordTemplete;
import com.mpazi.service.IService;

import java.util.Map;

public interface RecordTempleteService extends IService<RecordTemplete, String> {
    Map<String, RecordTemplete> getAll();
}
