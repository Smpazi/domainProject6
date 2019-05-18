package com.mpazi.domain.medication;

import java.util.Objects;

public class Prescription {
    String  visitTime, prescriptionId;

    private Prescription() {
    }

    private Prescription (Builder builder){

        this.prescriptionId=builder.prescriptionId;
        this.visitTime =builder.visitTime;
    }

    public String getPrescriptionId() {
        return prescriptionId;
    }

    public String getVisitTime() {
        return visitTime;
    }

    public static class Builder{

        String prescriptionId,visitTime;

        public Builder prescriptionId(String prescriptionId){
            this.prescriptionId =prescriptionId;
            return this;
        }

        public Builder visitTime(String visitTime){
            this.visitTime = visitTime;
            return this;
        }

        public Prescription build(){
            return new Prescription(this);
        }
    }

    @Override
    public String toString() {
        return "Prescription {" +
                "Prescription_Id = " +getPrescriptionId()+ '\'' +
                "VisitTime = " + getVisitTime() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prescription prescription = (Prescription) o;
        return prescriptionId.equals(prescription.prescriptionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prescriptionId);
    }
}
