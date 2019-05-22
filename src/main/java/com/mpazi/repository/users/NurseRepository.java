package com.mpazi.repository.users;

import com.mpazi.domain.users.Nurse;
import com.mpazi.repository.IRepository;

import java.util.Map;

public interface NurseRepository extends IRepository<Nurse, String> {
    Map<String, Nurse> getAll();
}
