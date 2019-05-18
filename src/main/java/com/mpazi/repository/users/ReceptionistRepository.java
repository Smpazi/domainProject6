package com.mpazi.repository.users;

import com.mpazi.domain.users.Receptionist;
import com.mpazi.repository.IRepository;

import java.util.Set;

public interface ReceptionistRepository extends IRepository<Receptionist, String> {
    Set<Receptionist> getAll();
}
