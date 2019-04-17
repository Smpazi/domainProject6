package com.mpazi.domain.users;

public class Doctor extends ClinicEmployee{

    private String doc_practiceNum;

    private Doctor() {

    }

    private Doctor (Builder builder){
        super();
        this.doc_practiceNum =builder.doc_practiceNum;

    }

    public String getDoc_practiceNum() {
        return doc_practiceNum;
    }

    public static class Builder{
        private String doc_practiceNum;


        public Builder doc_practiceNum(String doc_practiceNum){
            this.doc_practiceNum =doc_practiceNum;
            return this;
        }

        public Doctor build(){
            return new Doctor(this);
        }

    }// end of builder class

    @Override
    public String toString() {
        return "Doctor{" +
                "DoctorPracticeNum=" + doc_practiceNum + '\'' +
                ", DoctorName='" + getEmpName() + '\'' +
                '}';
    }

}
