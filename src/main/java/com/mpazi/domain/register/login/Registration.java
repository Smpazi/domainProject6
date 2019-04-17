package com.mpazi.domain.register.login;

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
        return "Registration{" +
                "RegistrationId=" + getReg_Id() + '\'' +
                ", UserName='" + getStaffName() + '\'' +
                '}';
    }
}
