package com.mpazi.domain.medication;


import java.util.Objects;

public class Medicine {
    private String medicine_genricName,medicine_createdAt;

    private Medication medication = new Medication();

    private Medicine(){
    }

    private Medicine (Builder builder){
        this.medicine_genricName =builder.medicine_genricName;
        this.medicine_createdAt= builder.medicine_createdAt;

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
        return "Medicine{" + medication.toString() +
                ", medicine_genricName=' " + getMedicine_genricName() + '\'' +
                ", medicine_createdAt =' " + getMedicine_createdAt() + '\'' +
                '}';
    }
   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine med = (Medicine) o;
        return medication.getMed_Id().equals(med.medication.getMed_Id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMed_Id());
    }*/
}
