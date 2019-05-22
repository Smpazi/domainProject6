package com.mpazi.domain.medication;


import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
@EntityScan
public class Medicine {
    private String medicine_genricName,medicine_createdAt;

    private String med_Id ;
    private Medication medication = new Medication();

    private Medicine(){
    }

    private Medicine (Builder builder){
        this.medicine_genricName =builder.medicine_genricName;
        this.medicine_createdAt= builder.medicine_createdAt;
        this.med_Id =builder.med_ID;

    }

    public String getMed_Id() {
        return med_Id;
    }

    public String getMedicine_genricName() {
        return medicine_genricName;
    }

    public String getMedicine_createdAt() {
        return medicine_createdAt;
    }

    public static class Builder{
        private String med_ID, medicine_genricName,medicine_createdAt;

        public Builder med_ID(String med_ID){
            this.med_ID= med_ID;
            return this;
        }
        public Builder medicine_genricName(String medicine_genricName){
            this.medicine_genricName= medicine_genricName;
            return this;
        }

        public Builder medicine_createdAt(String medicine_createdAt){
            this.medicine_createdAt =medicine_createdAt;
            return this;
        }


        public Medicine build(){
            return new Medicine(this);
        }
    }

    @Override
    public String toString() {
        return "MedicineController{" +
                ", medicine_ID=' " + getMed_Id() + '\'' +
                ", medicine_genricName=' " + getMedicine_genricName() + '\'' +
                ", medicine_createdAt =' " + getMedicine_createdAt() + '\'' +
                '}';
    }
   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicineController med = (MedicineController) o;
        return medication.getMed_Id().equals(med.medication.getMed_Id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMed_Id());
    }*/
}
