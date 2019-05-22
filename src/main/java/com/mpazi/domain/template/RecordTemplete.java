package com.mpazi.domain.template;


import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
@EntityScan
public class RecordTemplete {

    private String templeteId ,templateName, diagnosis;
    private int timeVisit;


    private RecordTemplete(){

    }

    private RecordTemplete (Builder builder){
        this.templeteId =builder.templeteId;
        this.templateName =builder.templateName;
        this.diagnosis=builder.diagnosis;
        this.timeVisit = builder.timeVisit;

    }

    public String getTempleteId() {
        return templeteId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public int getTimeVisit() {
        return timeVisit;
    }

    public static class Builder{
        private String templeteId ,templateName, diagnosis;
        private int timeVisit;

        public Builder templeteId(String  templeteId){
            this.templeteId =templeteId;
            return this;
        }

        public Builder templateName(String checkUpName){
            this.templateName = templateName;
            return this;
        }
        public Builder diagnosis(String diagnosis){
            this.diagnosis = diagnosis;
            return this;
        }
        public Builder timeVisit(int timeVisit){
            this.timeVisit = timeVisit;
            return this;
        }

        public RecordTemplete build(){
            return new RecordTemplete(this);
        }
    }

    @Override
    public String toString() {
        return "RecordTempleteController {" +
                "TemplateId = " +getTempleteId()+ '\'' +
                "TimeVisit = " + getTimeVisit() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecordTemplete recordTemplete = (RecordTemplete) o;
        return templeteId.equals(recordTemplete.templeteId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(templeteId);
    }
}
