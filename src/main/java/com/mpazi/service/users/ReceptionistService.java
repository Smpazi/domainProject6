package com.mpazi.service.users;

import com.mpazi.domain.users.Receptionist;
import com.mpazi.service.IService;

import java.util.Set;

public interface ReceptionistService extends IService<Receptionist, String> {
    Set<Receptionist> getAll();
}
