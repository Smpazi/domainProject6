package com.mpazi.domain.users;

public class ClinicEmployee {

    private String emp_Id,empName, empEmail;
    private int empPhoneNum;

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

    public int getEmpPhoneNum() {
        return empPhoneNum;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public static class Builder{
        private String emp_Id,empName, empEmail;
        private int empPhoneNum;

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
        public Builder empPhoneNum(int empPhoneNum){
            this.empPhoneNum = empPhoneNum;
            return  this;
        }

        public ClinicEmployee build(){
            return new ClinicEmployee(this);
        }
    }

}
