package com.mpazi.domain.information;

import java.util.Objects;

public class Appointment {
    private String appointmentId,appointmentName;
    private String appointmentDate;

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

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public static class Builder{
        private String appointmentId,appointmentName;
        private String appointmentDate;

        public Builder appointmentId(String appointmentId){
            this.appointmentId =appointmentId;
            return this;
        }

        public Builder appointmentName(String appointmentName){
            this.appointmentName =appointmentName;
            return this;
        }
        public Builder appointmentDate(String appointmentDate){
            this.appointmentDate =appointmentDate;
            return this;
        }

        public Appointment build(){
            return new Appointment(this);
        }
    }

    @Override
    public String toString() {
        return "AppointmentService{" +
                "Apppintment_ID = " + getAppointmentId() + '\''  +
                "ApppintmentDate= " + getAppointmentDate() + '\''  +
                '}';  }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment appointment = (Appointment) o;
        return appointmentId.equals(appointment.appointmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(appointmentId);
    }
}
