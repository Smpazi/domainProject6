package com.mpazi.domain.patient.record;

import java.util.Date;

public class Consultation {
    private String consultId, consult_description;

    private Consultation(){

    }

    private Consultation (Builder builder){
        this.consultId =builder.consultId;
        this.consult_description= builder.consultId;
    }

    public String getConsultId() {
        return consultId;
    }

    public String getConsult_description() {
        return consult_description;
    }

    public static class Builder{
        private String consultId, consult_description;

        public Builder consultId(String consultId){
            this.consultId = consultId;
            return this;
        }

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
        return "Consultations{" +
                "ConsultationId=" + getConsultId() + '\'' +
                ", Consultation_Description='" + getConsult_description() + '\'' +
                '}';
    }
}
