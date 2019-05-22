package com.mpazi.domain.medication;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
@EntityScan
public class DrugPrescription {

    String drugName,drug_prescriptionId;
    String drugType;
    String drugAdvice;

    private DrugPrescription() {
    }

    public DrugPrescription (Builder builder){
        this.drug_prescriptionId= builder.drug_prescriptionId;
        this.drugName =builder.drugName;
        this.drugType=builder.drugType;
        this.drugAdvice=builder.drugAdvice;
    }

    public String getDrug_prescriptionId() {
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
        String drugName,drug_prescriptionId;
        String drugType;
        String drugAdvice;

        public Builder drug_prescriptionId(String drug_prescriptionId){
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
        return "DrugPrescriptionController {" +
                "DrugPrescription_Id = " +getDrug_prescriptionId()+ '\'' +
                "DrugName = " + getDrugName() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DrugPrescription drugPrescription = (DrugPrescription) o;
        return drug_prescriptionId.equals(drugPrescription.drug_prescriptionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(drug_prescriptionId);
    }
}
