package com.mpazi.domain.medication;

import java.util.Objects;

public class Pill extends Medication {
    private int pillQuantity;

    private Pill(){

    }

    private Pill (Builder builder){
        super();
        this.pillQuantity =builder.pillQuantity;
    }

    @Override
    public String getMed_Id() {
        return super.getMed_Id();
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
      /*  public Builder pill_ID(String pill_ID){
            this.pill_ID = pill_ID;
            return this;
        }*/

        public Pill build(){
            return new Pill(this);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pill pill= (Pill) o;
        return getMed_Id().equals(pill.getMed_Id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMed_Id());
    }
}
