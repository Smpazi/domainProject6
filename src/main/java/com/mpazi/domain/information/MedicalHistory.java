package com.mpazi.domain.information;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
@EntityScan
public class MedicalHistory {
    private String medHistory_ID, allegies, cronical_Desease;

    private MedicalHistory(){}

    private MedicalHistory(Builder builder){

        this.medHistory_ID= builder.medHistory_ID;
        this.allegies = builder.allegies;
        this.cronical_Desease = builder.cronical_Desease;
    }

    public String getMedHistory_ID() {
        return medHistory_ID;
    }

    public String getAllegies() {
        return allegies;
    }

    public String getCronical_Desease() {
        return cronical_Desease;
    }


    public  static class Builder{
        private String medHistory_ID,allegies, cronical_Desease;

        public Builder medHistory_ID(String medHistory_ID){
            this.medHistory_ID = medHistory_ID;
            return this;
        }

        public Builder allegies(String allegies){
            this.allegies = allegies;
            return this;
        }
        public Builder cronical_Desease(String cronical_Desease){
            this.cronical_Desease = cronical_Desease;
            return this;
        }


        public  MedicalHistory build(){
            return new MedicalHistory(this);
        }
    }

    @Override
    public String toString() {
        return "MedicalHistoryController {" +
                "MedHistory_ID= " + getMedHistory_ID() + '\'' +
                "Allegies = " + getAllegies() + '\'' +
                "Cronical_Desease= " + getCronical_Desease() + '\'' +
                '}';
    }

   @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicalHistory medicalHistory = (MedicalHistory) o;
        return medHistory_ID.equals(medicalHistory.medHistory_ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medHistory_ID);
    }
}
