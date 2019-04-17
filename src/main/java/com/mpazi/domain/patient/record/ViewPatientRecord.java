package com.mpazi.domain.patient.record;

import java.util.Date;

public class ViewPatientRecord {
    private String recordId;

    private ViewPatientRecord(){

    }

    private ViewPatientRecord (Builder builder){

        this.recordId =builder.recordId;
    }

    public String getRecordId() {
        return recordId;
    }

    public static class Builder{
        private String recordId;


        public Builder recordId(String recordId){
            this.recordId =recordId;
            return this;
        }


        public ViewPatientRecord build(){
            return new ViewPatientRecord(this);
        }
    }

    @Override
    public String toString() {
        return "ViewRecords{" +
                "ViewIdRecord=" + getRecordId() + '\'' +
                '}';
    }
}
