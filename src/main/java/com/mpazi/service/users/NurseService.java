package com.mpazi.service.users;

import com.mpazi.domain.users.Nurse;
import com.mpazi.service.IService;

import java.util.Map;

public interface NurseService extends IService<Nurse, String> {
    Map<String, Nurse> getAll();
}
