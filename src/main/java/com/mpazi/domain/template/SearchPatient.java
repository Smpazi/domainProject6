package com.mpazi.domain.template;

import com.mpazi.domain.information.Patient;

import java.util.Objects;
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
        return "SearchPatient {" +
                "Search_Id = " + getSearchId() + '\'' +
                "Patient_ID = " + getPatients() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchPatient searchPatient = (SearchPatient) o;
        return searchId.equals(searchPatient.searchId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(searchId);
    }
}
