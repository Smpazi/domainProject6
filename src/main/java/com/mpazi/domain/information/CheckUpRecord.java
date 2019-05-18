package com.mpazi.domain.information;

import java.util.Objects;

public class CheckUpRecord {
    private String checkUpRecordId, checkUpRecordName, checkUp_description;

    private CheckUpRecord(){

    }

    private CheckUpRecord (Builder builder){
        this.checkUpRecordId = builder.checkUpRecordId;
        this.checkUpRecordName = builder.checkUpRecordName;
        this.checkUp_description = builder.checkUp_description;

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
                "checkUpRecordId= " + checkUpRecordId + '\'' +
                ", CheckUpRecordName= '" + getCheckUpRecordName() + '\'' +
                ", CheckUp_description= '" + getCheckUp_description() + '\'' +
                '}'; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckUpRecord checkUpRecord = (CheckUpRecord) o;
        return checkUpRecordId.equals(checkUpRecord.checkUpRecordId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(checkUpRecordId);
    }
}
