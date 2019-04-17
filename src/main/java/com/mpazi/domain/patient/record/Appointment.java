package com.mpazi.domain.patient.record;

import javafx.util.Builder;

import java.util.Date;

public class Appointment {
    private String appointmentId,appointmentName;
    private Date appointmentDate;

    private Appointment(){

    }

    private Appointment (Builder builder){
        this.appointmentId = builder.appointmentId;
        this.appointmentName =builder.appointmentName;
        this.appointmentDate =builder.appointmentDate;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public String getAppointmentName() {
        return appointmentName;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public static class Builder{
        private String appointmentId,appointmentName;
        private Date appointmentDate;

        public Builder appointmentId(String appointmentId){
            this.appointmentId =appointmentId;
            return this;
        }

        public Builder appointmentName(String appointmentName){
            this.appointmentName =appointmentName;
            return this;
        }
        public Builder appointmentDate(Date appointmentDate){
            this.appointmentDate =appointmentDate;
            return this;
        }

        public Appointment build(){
            return new Appointment(this);
        }
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "ApppintmentDate=" + getAppointmentDate() + '\''  +
                '}';  }
}
