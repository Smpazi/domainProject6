package com.mpazi.domain.template;

import java.util.Objects;

public class TransferLetterTemplate {

    private String transfer_ID,transferNote,  transfer_DoctorName, transfer_HospitalName;

    private TransferLetterTemplate(){

    }

    private TransferLetterTemplate(Builder builder){
        this.transferNote =builder.transferNote;
        this.transfer_ID = builder.transfer_ID;
        this.transfer_DoctorName = builder.transfer_DoctorName;
        this.transfer_HospitalName = builder.transfer_HospitalName;

    }

    public String getTransfer_ID() {
        return transfer_ID;
    }

    public String getTransferNote() {
        return transferNote;
    }

    public String getTransfer_DoctorName() {
        return transfer_DoctorName;
    }

    public String getTransfer_HospitalName() {
        return transfer_HospitalName;
    }

    public static class Builder{
        private String transfer_ID,transferNote,  transfer_DoctorName, transfer_HospitalName;

        public Builder transfer_ID(String transfer_ID){
            this.transfer_ID =transfer_ID;
            return this;
        }

        public Builder transferNote(String transferNote){
            this.transferNote =transferNote;
            return this;
        }
        public Builder transfer_DoctorName(String transfer_DoctorName){
            this.transfer_DoctorName =transfer_DoctorName;
            return this;
        }
        public Builder transfer_HospitalName(String transfer_HospitalName){
            this.transfer_HospitalName =transfer_HospitalName;
            return this;
        }


        public TransferLetterTemplate build(){
            return new TransferLetterTemplate(this);
        }
    }

    @Override
    public String toString() {
        return "TransferNote {" +
                "Transfer_ID = " +getTransfer_ID()+ '\'' +
                "Transfer_DoctorName = " + getTransfer_DoctorName()+ '\'' +
                "Transfer_HospitalName = " + getTransfer_HospitalName() + '\'' +
                "TransferNote = " + getTransferNote() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransferLetterTemplate transferLetterTemplate = (TransferLetterTemplate) o;
        return transfer_ID.equals(transferLetterTemplate.transfer_ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transfer_ID);
    }
}
