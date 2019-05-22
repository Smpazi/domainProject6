package com.mpazi.domain.users;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Nurse  {
    private String nursing_Department;
    private ClinicEmployee clinicEmployee = new ClinicEmployee();

    private Nurse(){
    }

    private Nurse (Builder builder){
        this.nursing_Department=builder.nursing_Department;
    }

    public String getNursing_Department() {
        return nursing_Department;
    }

    public static class Builder{
        private String nursing_Department;

        public Builder nursing_Department(String nursing_Department){
            this.nursing_Department =nursing_Department;
            return this;
        }

        public Nurse build(){
            return new Nurse(this);
        }
    }

    @Override
    public String toString() {
        return "NurseService{" +
                ", NurseName=' " + clinicEmployee.getEmpName() + '\'' +
                ", Nursing_Department=' " + getNursing_Department() + '\'' +
                '}';
    }
}
