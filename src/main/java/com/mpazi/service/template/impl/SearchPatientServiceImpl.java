package com.mpazi.service.template.impl;

import com.mpazi.domain.template.SearchPatient;
import com.mpazi.repository.template.SearchPatientRepository;
import com.mpazi.repository.template.impl.SearchPatientRepositoryImpl;
import com.mpazi.service.template.SearchPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service ("ServiceImpSearchPatient")
public class SearchPatientServiceImpl implements SearchPatientService {
    @Qualifier("InMemorySearchPatient")
    private  static SearchPatientServiceImpl service = null;

    SearchPatientRepository repository = SearchPatientRepositoryImpl.getRepository();

    public static SearchPatientServiceImpl getInstance(){
        if(service == null)
            service =new SearchPatientServiceImpl();
        return service;
    }
    @Override
    public Map<String, SearchPatient> getAll() {
        return repository.getAll();
    }

    @Override
    public SearchPatient create(SearchPatient searchPatient) {
        return repository.create(searchPatient);
    }

    @Override
    public SearchPatient update(SearchPatient searchPatient) {
        return repository.update(searchPatient);
    }

    @Override
    public void delete(String s) {

        repository.delete(s);
    }

    @Override
    public SearchPatient read(String s) {
        return repository.read(s);
    }
}
