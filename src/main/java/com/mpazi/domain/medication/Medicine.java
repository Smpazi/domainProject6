package com.mpazi.domain.medication;


import java.util.Objects;

public class Medicine extends Medication {
    private String medicine_genricName,medicine_createdAt;


    private Medicine(){
    }

    private Medicine (Builder builder){
        this.medicine_genricName =builder.medicine_genricName;
        this.medicine_createdAt= builder.medicine_createdAt;

    }

    @Override
    public String getMed_Id() {
        return super.getMed_Id();
    }

    public String getMedicine_genricName() {
        return medicine_genricName;
    }

    public String getMedicine_createdAt() {
        return medicine_createdAt;
    }

    public static class Builder{
        private String medicine_genricName,medicine_createdAt;

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
        return "Medicine{" +
                "MedicineId=" + super.getMed_Id()+ '\'' ;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return getMed_Id().equals(medicine.getMed_Id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMed_Id());
    }
}
