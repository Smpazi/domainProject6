package com.mpazi.domain;

public class TreatmentHistory {

    private String treat_description, drugDosage;

    private TreatmentHistory(){

    }

    private TreatmentHistory (Builder builder){
        this.treat_description =builder.treat_description;
        this.drugDosage =builder.drugDosage;
    }

    public String getTreat_description() {
        return treat_description;
    }

    public String getDrugDosage() {
        return drugDosage;
    }

    public static class Builder{
        private String treat_description, drugDosage;

        public Builder treat_description(String treat_description){
            this.treat_description =treat_description;
            return this;
        }

        public Builder drugDosage(String drugDosage){
            this.drugDosage = drugDosage;
            return this;
        }

        public TreatmentHistory build(){
            return new TreatmentHistory(this);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
