package com.mpazi.domain.information;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
@EntityScan
public class PatientNote {
    private String patientNoteId, patientNoteType;

    private PatientNote(){

    }

    private PatientNote (Builder builder){
        this.patientNoteId= builder.patientNoteId;
        this.patientNoteType =builder.patientNoteType;

    }

    public String getPatientNoteId() {
        return patientNoteId;
    }

    public String getPatientNoteType() {
        return patientNoteType;
    }

    public static class Builder{
        private String patientNoteId, patientNoteType;

        public Builder patientNoteId(String patientNoteId){
            this.patientNoteId =patientNoteId;
            return this;
        }

        public Builder patientNoteType(String patientNoteType){
            this.patientNoteType = patientNoteType;
            return this;
        }


        public PatientNote build(){
            return new PatientNote(this);
        }
    }

    @Override
    public String toString() {
        return "PatientNoteService{" +
                "PatientNoteId=" + getPatientNoteId() + '\'' +
                ", PatientNoteType='" + getPatientNoteType() + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientNote patientNote = (PatientNote) o;
        return patientNoteId.equals(patientNote.patientNoteId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientNoteId);
    }
}
