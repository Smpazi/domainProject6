package com.mpazi.repository.implementation;

import com.mpazi.domain.SearchPatient;
import com.mpazi.domain.patient.record.Patient;
import com.mpazi.repository.SearchPatientRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SearchPatientRepositoryImpl implements SearchPatientRepository {

    private  static  SearchPatientRepositoryImpl repository = null;
    private Map<String, SearchPatient> searchTable;

    private SearchPatientRepositoryImpl(){

        searchTable = new HashMap<>();
    }

    public static SearchPatientRepositoryImpl getRepository(){
        if(repository == null)
            repository = new SearchPatientRepositoryImpl();
        return repository;
    }

    @Override
    public Map<String, SearchPatient> getAll() {
        return null;
    }

    @Override
    public SearchPatient create(SearchPatient searchPatient) {
        searchTable.put(searchPatient.getSearchId(),searchPatient);
        SearchPatient saveSearchPatient = searchTable.get(searchPatient.getSearchId());
        return saveSearchPatient;
    }

    @Override
    public SearchPatient update(SearchPatient searchPatient) {
        searchTable.put(searchPatient.getSearchId(),searchPatient);
        SearchPatient updateSearch = searchTable.get(searchPatient.getSearchId());
        return updateSearch;
    }

    @Override
    public void delete(String search_ID) {

        searchTable.remove(search_ID);
    }

    @Override
    public SearchPatient read(String search_ID) {
        return null;
    }
}
