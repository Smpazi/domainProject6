package com.mpazi.repository.users;

import com.mpazi.domain.users.Receptionist;
import com.mpazi.repository.IRepository;

import java.util.Map;

public interface ReceptionistRepository extends IRepository<Receptionist, String> {
    Map<String, Receptionist> getAll();
}
