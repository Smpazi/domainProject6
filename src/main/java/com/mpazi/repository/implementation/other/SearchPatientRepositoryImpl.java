package com.mpazi.repository.implementation.other;

import com.mpazi.domain.templete.SearchPatient;
import com.mpazi.repository.other.SearchPatientRepository;

import java.util.HashMap;
import java.util.Map;

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
