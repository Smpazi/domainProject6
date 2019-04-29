package com.mpazi.domain;

public class Treatment {

    private String treatment_ID, treat_description;
    private int drugDosage;

    private Treatment(){

    }

    private Treatment(Builder builder){
        this.treat_description =builder.treat_description;
        this.treatment_ID = builder.treatment_ID;
        this.drugDosage =builder.drugDosage;
    }

    public String getTreatment_ID() {
        return treatment_ID;
    }

    public String getTreat_description() {
        return treat_description;
    }

    public int getDrugDosage() {
        return drugDosage;
    }

    public static class Builder{
        private String treatment_ID,treat_description;
           private  int drugDosage;

        public Builder treatment_ID(String treatment_ID){
            this.treatment_ID =treatment_ID;
            return this;
        }

        public Builder treat_description(String treat_description){
            this.treat_description =treat_description;
            return this;
        }

        public Builder drugDosage(int drugDosage){
            this.drugDosage = drugDosage;
            return this;
        }

        public Treatment build(){
            return new Treatment(this);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
