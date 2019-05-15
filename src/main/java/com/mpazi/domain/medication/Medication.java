package com.mpazi.domain.medication;

import java.util.Objects;

public class  Medication{
    private String med_Id, med_Name, med_description;

    protected Medication(){
    }

    private Medication (Builder builder){
        this.med_Id =builder.med_Id;
        this.med_Name =builder.med_Name;
        this.med_description =builder.med_description;
    }

    public String getMed_Id() {
        return med_Id;
    }

    public String getMed_Name() {
        return med_Name;
    }

    public String getMed_desription() {
        return med_description;
    }

    public static class Builder{
        private String med_Id, med_Name, med_description;

        public Builder med_Id(String med_Id){
            this.med_Id =med_Id;
            return this;
        }

        public Builder med_Name(String med_Name){
            this.med_Name = med_Name;
            return this;
        }
        public Builder med_description(String med_description){
            this.med_description = med_description;
            return this;
        }


        public Medication build(){
            return new Medication(this);
        }
    }

    @Override
    public String toString() {
        return "Medication{" +
                "MedicationId=" + med_Id + '\'' +
                ", MedicationName='" + med_Name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medication medication = (Medication) o;
        return med_Id.equals(medication.med_Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(med_Id);
    }
}
