package com.mpazi.domain.patient.record;

import java.util.Date;

public class CheckUpPatient extends Patient {
    private String checkUpId, checkUpName;
    private Date returnDate;

    private CheckUpPatient(){

    }

    private CheckUpPatient (Builder builder){
        this.checkUpId=builder.checkUpId;
        this.checkUpName=builder.checkUpName;
        this.returnDate=builder.returnDate;

    }

    public String getCheckUpId() {
        return checkUpId;
    }

    public String getCheckUpName() {
        return checkUpName;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public static class Builder{
        private String checkUpId, checkUpName;
        private Date returnDate;

        public Builder checkUpId(String checkUpId){
            this.checkUpId =checkUpId;
            return this;
        }

        public Builder checkUpName(String checkUpName){
            this.checkUpName = checkUpName;
            return this;
        }
        public Builder returnDate(Date returnDate){
            this.returnDate = returnDate;
            return this;
        }

        public CheckUpPatient build(){
            return new CheckUpPatient(this);
        }
    }

    @Override
    public String toString() {
        return "CheckUp{" +
                "CheckUpName=" + getCheckUpName() + '\'' +
                "CheckUpDate=" + getReturnDate() + '\'' +
                '}'; }
}
