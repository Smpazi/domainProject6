package com.mpazi.service.users;

import com.mpazi.domain.users.Doctor;
import com.mpazi.service.IService;

import java.util.Set;

public interface DoctorService extends IService<Doctor, String> {

    Set<Doctor> getAll();

}
