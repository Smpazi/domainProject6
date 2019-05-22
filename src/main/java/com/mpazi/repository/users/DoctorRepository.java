package com.mpazi.repository.users;

import com.mpazi.domain.users.Doctor;
import com.mpazi.repository.IRepository;

import java.util.Map;

public interface DoctorRepository extends IRepository<Doctor, String> {
    Map<String, Doctor> getAll();

}
