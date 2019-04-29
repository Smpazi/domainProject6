package com.mpazi.domain.medication;

public class Medication{
    private String med_Id, med_Name, med_desription;

    protected Medication(){
    }

    private Medication (Builder builder){
        this.med_Id =builder.med_Id;
        this.med_Name =builder.med_Name;
        this.med_desription =builder.med_desription;
    }

    public String getMed_Id() {
        return med_Id;
    }

    public String getMed_Name() {
        return med_Name;
    }

    public String getMed_desription() {
        return med_desription;
    }

    public static class Builder{
        private String med_Id, med_Name, med_desription;

        public Builder med_Id(String med_Id){
            this.med_Id =med_Id;
            return this;
        }

        public Builder med_Name(String med_Name){
            this.med_Name = med_Name;
            return this;
        }
        public Builder med_description(String med_desription){
            this.med_desription = med_desription;
            return this;
        }


        public Medication build(){
            return new Medication(this);
        }
    }

    @Override
    public String toString() {
        return "MedicationRepository{" +
                "MedicationId=" + med_Id + '\'' +
                ", MedicationName='" + med_Name + '\'' +
                '}';
    }
}
