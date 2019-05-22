package com.mpazi.service.medication;

import com.mpazi.domain.medication.Pill;
import com.mpazi.service.IService;

import java.util.Map;

public interface PillService extends IService<Pill, String> {

    Map<String, Pill> getAll();
}
