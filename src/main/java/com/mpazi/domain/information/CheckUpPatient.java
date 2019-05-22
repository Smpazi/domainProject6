package com.mpazi.domain.information;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class CheckUpPatient {
    private String checkUp_Reason, checkUp_Id;
    private String returnDate;

    Patient patient = new Patient();

    private CheckUpPatient(){

    }

    private CheckUpPatient (Builder builder) {
        this.checkUp_Reason=builder.checkUp_Reason;
        this.returnDate=builder.returnDate;
        this.checkUp_Id = builder.checkUp_Id;
    }

    public String getCheckUp_Id() {
        return checkUp_Id;
    }

    public String getCheckUp_Reason() {
        return checkUp_Reason;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public static class Builder {
        private String checkUp_Id, checkUp_Reason;
        private String returnDate;

        public Builder checkUp_Id(String checkUp_Id){
            this.checkUp_Id = checkUp_Id;
            return this;
        }
        public Builder checkUp_Reason(String checkUp_Reason){
            this.checkUp_Reason = checkUp_Reason;
            return this;
        }
        public Builder returnDate(String returnDate){
            this.returnDate = returnDate;
            return this;
        }

        public CheckUpPatient build(){
            return new CheckUpPatient(this);
        }
    }

    @Override
    public String toString() {
        return "CheckUp_Patient{" +
                "Patient_ID= " + getCheckUp_Id()+ '\'' +
                "Patient_Name= " + patient.getPatientName() + '\'' +
                "CheckUp_Reason= " + getCheckUp_Reason() + '\'' +
                "CheckUpDate= " + getReturnDate() + '\'' +
                '}';
    }

}
