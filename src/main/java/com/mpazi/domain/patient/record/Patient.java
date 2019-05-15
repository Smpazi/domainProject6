package com.mpazi.domain.patient.record;

public  class  Patient {
    private int phoneNum, age;
    private String patientId,patientName,email,gender,address;
    protected Patient(){}

    private Patient(Builder builder){
        this.patientId = builder.patientId;
        this.patientName = builder.patientName;
        this.gender = builder.gender;
        this.age = age;
        this.email = builder.email;
        this.address =builder.address;
        this.phoneNum = builder.phoneNum;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public int getAge() {
        return age;
    }

    public  static class Builder{
        private String patientId,patientName,email,gender,address;
        private int phoneNum, age;

        public Builder patientId(String patientId){
            this.patientId = patientId;
            return this;
        }
        public Builder patientName(String patientName){
            this.patientName= patientName;
            return this;
        }
        public Builder email(String email){
            this.email = email;
            return this;
        }

        public Builder phoneNum(int phoneNum){
            this.phoneNum = phoneNum;
            return this;
        }
        public Builder address(String address){
            this.address = address;
            return this;
        }
        public Builder gender(String gender){
            this.gender = gender;
            return this;
        }
        public Builder age(int age){
            this.age = age;
            return this;
        }

        public  Patient build(){
            return new Patient(this);
        }
    }

    @Override
    public String toString() {
        return "PatientService{" +
                "patientId=" + patientId + '\'' +
                ", patientName='" + patientName + '\'' +
                '}';    }
}
