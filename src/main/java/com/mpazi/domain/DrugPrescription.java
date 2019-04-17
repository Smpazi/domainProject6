package com.mpazi.domain;

public class DrugPrescription {

    int drug_prescriptionId;
    String drugName;
    String drugType;
    String drugAdvice;

    private DrugPrescription() {
    }

    private DrugPrescription (Builder builder){
        this.drug_prescriptionId=builder.drug_prescriptionId;
        this.drugName =builder.drugName;
        this.drugType=builder.drugAdvice;
        this.drugAdvice=builder.drugAdvice;
    }

    public int getDrug_prescriptionId() {
        return drug_prescriptionId;
    }

    public String getDrugName() {
        return drugName;
    }

    public String getDrugType() {
        return drugType;
    }

    public String getDrugAdvice() {
        return drugAdvice;
    }

    public static class Builder{
        int drug_prescriptionId;
        String drugName;
        String drugType;
        String drugAdvice;

        public Builder drug_prescriptionId(int prescriptionId){
            this.drug_prescriptionId =drug_prescriptionId;
            return this;
        }

        public Builder drugName(String drugName){
            this.drugName = drugName;
            return this;
        }
        public Builder drugType(String drugType){
            this.drugType = drugType;
            return this;
        }
        public Builder drugAdvice(String drugAdvice){
            this.drugAdvice = drugAdvice;
            return this;
        }

        public DrugPrescription build(){
            return new DrugPrescription(this);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }


}
