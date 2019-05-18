package com.mpazi.domain.information;

import java.util.Objects;
import java.util.Set;

public  class  Patient {
    private int phoneNum, age;
    private String patientId,patientName,email,gender,address;

    private Set<MedicalHistory> medicalHistories;
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
                "PatientId=" + patientId + '\'' +
                ",PatientName='" + patientName + '\'' +
                ", Patient_Age ='" + getAge() + '\'' +
                '}';    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return patientId.equals(patient.patientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId);
    }
}
