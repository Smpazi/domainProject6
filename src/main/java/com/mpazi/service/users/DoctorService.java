package com.mpazi.service.users;

import com.mpazi.domain.users.Doctor;
import com.mpazi.service.IService;

import java.util.Map;

public interface DoctorService extends IService<Doctor, String> {

    Map<String, Doctor> getAll();

}
