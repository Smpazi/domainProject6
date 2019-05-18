package com.mpazi.repository.users;

import com.mpazi.domain.users.Nurse;
import com.mpazi.repository.IRepository;

import java.util.Set;

public interface NurseRepository extends IRepository<Nurse, String> {
    Set<Nurse> getAll();
}
