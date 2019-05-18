package com.mpazi.service.medication;

import com.mpazi.domain.medication.Pill;
import com.mpazi.service.IService;

import java.util.Set;

public interface PillService extends IService<Pill, String> {

    Set<Pill> getAll();
}
