package com.mpazi.domain.users;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
@EntityScan
public class ClinicEmployee {

    private String emp_Id,empName, empEmail;
    private long empPhoneNum;

    protected ClinicEmployee(){

    }

    private ClinicEmployee (Builder builder){
        this.emp_Id =builder.emp_Id;
        this.empName=builder.empName;
        this.empPhoneNum=builder.empPhoneNum;
        this.empEmail=builder.empEmail;
    }

    public String getEmp_Id() {
        return emp_Id;
    }

    public String getEmpName() {
        return empName;
    }

    public long getEmpPhoneNum() {
        return empPhoneNum;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public static class Builder{
        private String emp_Id,empName, empEmail;
        private long empPhoneNum;

        public Builder emp_Id(String emp_Id){
            this.emp_Id = emp_Id;
            return this;
        }

        public Builder empName(String empName){
            this.empName = empName;
            return this;
        }

        public  Builder empEmail(String empEmail){
            this.empEmail = empEmail;
            return this;
        }
        public Builder empPhoneNum(long empPhoneNum){
            this.empPhoneNum = empPhoneNum;
            return  this;
        }

        public ClinicEmployee build(){
            return new ClinicEmployee(this);
        }


    }
    @Override
    public String toString() {
        return "Employee{" +
                ", Employee_Id =' " + getEmp_Id() + '\'' +
                ", Employee_Name =' " + getEmpName() + '\'' +
                ", EmpPhone_Num =' " + getEmpPhoneNum() + '\'' +
                ", Employee_Email =' " + getEmpEmail() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClinicEmployee clinicEmployee = (ClinicEmployee) o;
        return emp_Id.equals(clinicEmployee.emp_Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmp_Id());
    }

}
