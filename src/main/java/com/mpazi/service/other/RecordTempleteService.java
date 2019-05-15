package com.mpazi.service.other;

import com.mpazi.domain.templete.RecordTemplete;
import com.mpazi.service.IService;

import java.util.Set;

public interface RecordTempleteService extends IService<RecordTemplete, String> {
    Set<RecordTemplete> getAll();
}
