package com.mpazi.domain.users;

public class Receptionist  {
    private String job_type;

    private ClinicEmployee clinicEmployee = new ClinicEmployee();

    private Receptionist(){

    }

    private Receptionist (Builder builder){
        super();
        this.job_type =builder.job_type;

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
        return "ReceptionistService{" +
                "ReceptionistID=" +clinicEmployee.getEmp_Id() + '\'' +
                ", Receptionist_JobTitle='" + getJob_type() + '\'' +
                '}';
    }

}
