package com.mpazi.domain.users;

import java.util.Date;

public class Nurse extends ClinicEmployee {
    private String nursing_type;
    private Nurse(){

    }

    private Nurse (Builder builder){
        super();
        this.nursing_type=builder.nursing_type;
    }

    @Override
    public String getEmp_Id() {
        return super.getEmp_Id();
    }

    @Override
    public String getEmpName() {
        return super.getEmpName();
    }

    public String getNursing_type() {
        return nursing_type;
    }

    public static class Builder{
        private String nursing_type;

        public Builder nursing_type(String nursing_type){
            this.nursing_type =nursing_type;
            return this;
        }



        public Nurse build(){
            return new Nurse(this);
        }
    }

    @Override
    public String toString() {
        return "NurseRepository{" +
                ", NurseType='" + getNursing_type() + '\'' +
                '}';
    }
}
