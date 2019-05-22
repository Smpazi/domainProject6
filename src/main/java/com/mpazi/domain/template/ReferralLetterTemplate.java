package com.mpazi.domain.template;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
@EntityScan
public class ReferralLetterTemplate {

    private String referral_ID,referralNote, referral_HospitalName;

    private ReferralLetterTemplate(){

    }

    private ReferralLetterTemplate(Builder builder){
        this.referral_ID =builder.referral_ID;
        this.referral_HospitalName =builder.referral_HospitalName;
        this.referralNote=builder.referralNote;

    }

    public String getReferral_ID() {
        return referral_ID;
    }

    public String getReferralNote() {
        return referralNote;
    }

    public String getReferral_HospitalName() {
        return referral_HospitalName;
    }



    public static class Builder{
        private String referral_ID,referralNote, referral_HospitalName;

        public Builder referral_ID(String referral_ID){
            this.referral_ID =referral_ID;
            return this;
        }
        public Builder referralNote(String referralNote){
            this.referralNote =referralNote;
            return this;
        }
        public Builder referral_HospitalName(String referral_HospitalName){
            this.referral_HospitalName =referral_HospitalName;
            return this;
        }
        public ReferralLetterTemplate build(){
            return new ReferralLetterTemplate(this);
        }
    }

    @Override
    public String toString() {
        return "ReferralNote {" +
                "Referral_ID = " +getReferral_ID()+ '\'' +
                "Referral_HospitalName = " + getReferral_HospitalName() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReferralLetterTemplate referralLetterTemplate = (ReferralLetterTemplate) o;
        return referral_ID.equals(referralLetterTemplate.referral_ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(referral_ID);
    }

}
