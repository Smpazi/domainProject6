package com.mpazi.domain.users;

public class Receptionist extends ClinicEmployee {
    private String job_type;

    private Receptionist(){

    }

    private Receptionist (Builder builder){
        super();
        this.job_type =builder.job_type;

    }

    @Override
    public String getEmp_Id() {
        return super.getEmp_Id();
    }

    public String getJob_type() {
        return job_type;
    }

    public static class Builder{
        private String job_type;

        public Builder job_type(String job_type){
            this.job_type =job_type;
            return this;
        }

        public Receptionist build(){
            return new Receptionist(this);
        }
    }

    @Override
    public String toString()
    {
        return "ReceptionistRepository{" +
                "ReceptionistID=" + getEmp_Id() + '\'' +
                ", Receptionist_JobTitle='" + getJob_type() + '\'' +
                '}';
    }
}
