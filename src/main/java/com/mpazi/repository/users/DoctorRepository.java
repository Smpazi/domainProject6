package com.mpazi.repository.users;

import com.mpazi.domain.users.Doctor;
import com.mpazi.repository.IRepository;

import java.util.Set;

public interface DoctorRepository extends IRepository<Doctor, String> {
    Set<Doctor> getAll();

}
