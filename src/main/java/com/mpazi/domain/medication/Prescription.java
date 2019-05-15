package com.mpazi.domain.medication;

public class Prescription {

    int prescriptionId;
    String prescriptionAdvice;


    private Prescription() {
    }

    private Prescription (Builder builder){

        this.prescriptionId=builder.prescriptionId;
        this.prescriptionAdvice =builder.prescriptionAdvice;
    }

    public int getPrescriptionId() {
        return prescriptionId;
    }

    public String getPrescriptionAdvice() {
        return prescriptionAdvice;
    }

    public static class Builder{
        int prescriptionId;
        String prescriptionAdvice;

        public Builder prescriptionId(int prescriptionId){
            this.prescriptionId =prescriptionId;
            return this;
        }

        public Builder prescriptionAdvice(String prescriptionAdvice){
            this.prescriptionAdvice = prescriptionAdvice;
            return this;
        }

        public Prescription build(){
            return new Prescription(this);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
