package com.mpazi.domain.medication;


public class Medicine extends Medication {
    private String medicine_genricName,medicine_createdAt;

    private Medicine(){
    }

    private Medicine (Builder builder){
        super();
        this.medicine_genricName =builder.medicine_genricName;
        this.medicine_createdAt= builder.medicine_createdAt;

    }

    public String getMedicine_genricName() {
        return medicine_genricName;
    }

    public String getMedicine_createdAt() {
        return medicine_createdAt;
    }

    public static class Builder{
        private String medicine_genricName,medicine_createdAt;

        public Builder medicine_genricName(String medicine_createdAt){
            this.medicine_genricName=medicine_genricName;
            return this;
        }

        public Builder medicine_createdAt(String medicine_createdAt){
            this.medicine_createdAt =medicine_createdAt;
            return this;
        }


        public Medicine build(){
            return new Medicine(this);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
