package com.mpazi.service.medication.impl;


import com.mpazi.domain.medication.Medicine;
import com.mpazi.repository.medication.MedicineRepository;
import com.mpazi.repository.medication.impl.MedicineRepositoryImpl;
import com.mpazi.service.medication.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service ("ServiceImpMedicine")
public class MedicineServiceImpl implements MedicineService {

    @Qualifier("InMemoryMedicine")
    private  static MedicineServiceImpl service = null;

    MedicineRepository repository = MedicineRepositoryImpl.getRepository();

    public static MedicineServiceImpl getInstance(){
        if(service == null)
            service =new MedicineServiceImpl();
        return service;
    }

    @Override
    public Medicine create(Medicine medicine) {
        return repository.create(medicine);
    }

    @Override
    public Medicine update(Medicine medicine) {
        return repository.update(medicine);
    }

    @Override
    public void delete(String s) {

        repository.delete(s);
    }

    @Override
    public Medicine read(String s) {
        return repository.read(s);
    }

    @Override
    public Map<String, Medicine> getAll() {
        return repository.getAll();
    }
}
