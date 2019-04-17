package com.mpazi.domain.clinic.medication;

public class Pill extends Medication {
    private int pillQuantity;

    private Pill(){

    }

    private Pill (Builder builder){
        super();
        this.pillQuantity =builder.pillQuantity;
    }

    public int getPillQuantity() {
        return pillQuantity;
    }

    public static class Builder{
        private int pillQuantity;

        public Builder pillQuantity(int pillQuantity){
            this.pillQuantity =pillQuantity;
            return this;
        }


        public Pill build(){
            return new Pill(this);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
