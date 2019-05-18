package com.mpazi.domain.information;

public class Consultation  {
    private String  consult_description;

    Patient patient = new Patient();

    private Consultation(){
    }

    private Consultation (Builder builder){
        this.consult_description= builder.consult_description;
    }


    public String getConsult_description() {
        return consult_description;
    }

    public static class Builder{
        private String  consult_description;


        public Builder consult_description(String consult_description){
            this.consult_description =consult_description;
            return this;
        }

        public Consultation build(){
            return new Consultation(this);
        }
    }

    @Override
    public String toString() {
        return "Consultation_Patient{" +
                "Patient_ID= " + patient.getPatientId() + '\'' +
                "Patient_Name= " + patient.getPatientName() + '\'' +
                ", Consultation_Description='" + getConsult_description() + '\'' +
                '}';
    }


}
