package com.mpazi.domain.medication;

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

    @Override
    public String getMed_Id() {
        return super.getMed_Id();
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
        return super.toString();
    }
}
