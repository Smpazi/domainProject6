package com.mpazi.domain.login;

import java.util.Objects;

public class Registration {
    private String reg_Id, staffName;

    private Registration(){

    }

    private Registration(Builder builder){
        this.reg_Id =builder.reg_Id;
        this.staffName= builder.staffName;
    }

    public String getReg_Id() {
        return reg_Id;
    }

    public String getStaffName() {
        return staffName;
    }

    public static class Builder{
        private String reg_Id, staffName;

        public Builder reg_Id(String reg_Id){
            this.reg_Id =reg_Id;
            return this;
        }

        public Builder staffName(String staffName){
            this.staffName = staffName;
            return this;
        }


        public Registration build(){
            return new Registration(this);
        }
    }

    @Override
    public String toString() {
        return "RegistrationService{" +
                "RegistrationId= " + getReg_Id() + '\'' +
                "UserName= " + getStaffName() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Registration registration = (Registration) o;
        return reg_Id.equals(registration.reg_Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reg_Id);
    }
}
