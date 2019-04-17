package com.mpazi.domain.patient.record;

import java.util.Date;

public class CheckUpRecord {
    private String checkUpRecordId, checkUpRecordName, checkUp_description;

    private CheckUpRecord(){

    }

    private CheckUpRecord (Builder builder){

    }

    public String getCheckUpRecordId() {
        return checkUpRecordId;
    }

    public String getCheckUpRecordName() {
        return checkUpRecordName;
    }

    public String getCheckUp_description() {
        return checkUp_description;
    }

    public static class Builder{
        private String checkUpRecordId, checkUpRecordName, checkUp_description;

        public Builder checkUpRecordId(String checkUpRecordId){
            this.checkUpRecordId =checkUpRecordId;
            return this;
        }

        public Builder checkUpRecordName(String checkUpRecordName){
            this.checkUpRecordName = checkUpRecordName;
            return this;
        }
        public Builder checkUp_description(String checkUp_description){
            this.checkUp_description = checkUp_description;
            return this;
        }

        public CheckUpRecord build(){
            return new CheckUpRecord(this);
        }
    }
    @Override
    public String toString() {
        return "Records{" +
                "checkUpRecordId=" + checkUpRecordId + '\'' +
                ", checkUpRecordName='" + getCheckUpRecordName() + '\'' +
                '}'; }
}
