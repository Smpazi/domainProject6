package com.mpazi.domain.templete;

import com.mpazi.domain.patient.record.Patient;

import java.util.Set;

public class SearchPatient {
    private String searchId;
    private Set<Patient> patients;

    private SearchPatient(){
    }

    private SearchPatient (Builder builder){
        this.searchId =builder.searchId;
        this.patients =builder.patients;

    }

    public String getSearchId() {
        return searchId;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public static class Builder{
        private String searchId;
        private Set<Patient> patients;


        public Builder searchId(String searchId){
            this.searchId =searchId;
            return this;
        }

        public Builder patients(Set patients){
            this.patients = patients;
            return this;
        }


        public SearchPatient build(){
            return new SearchPatient(this);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
