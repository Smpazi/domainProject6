package com.mpazi.domain.medication;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
@EntityScan
public class Pill {
    private int pillQuantity;
    private String pill_ID;

    private Medication medication = new Medication();

    private Pill(){

    }

    private Pill (Builder builder){
        this.pillQuantity =builder.pillQuantity;
        this.pill_ID = builder.pill_ID;
    }

    public String getPill_ID() {
        return pill_ID;
    }

    public int getPillQuantity() {
        return pillQuantity;
    }

    public static class Builder{
        private int pillQuantity;
       private String pill_ID;

        public Builder pillQuantity(int pillQuantity){
            this.pillQuantity =pillQuantity;
            return this;
        }
        public Builder pill_ID(String pill_ID){
            this.pill_ID = pill_ID;
            return this;
        }

        public Pill build(){
            return new Pill(this);
        }
    }

    @Override
    public String toString() {
        return "PillController{" +
                ", Pill_ID=' " + getPill_ID() + '\'' +
                ", PillQuantity=' " + getPillQuantity() + '\'' +
                '}';
    }

}
