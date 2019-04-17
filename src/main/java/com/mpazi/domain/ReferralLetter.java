package com.mpazi.domain;

public class ReferralLetter implements TempleteLetter{
    private int referralId;
    private String referralNote;
    private String referral_doctorName;

    private ReferralLetter(){

    }

    private ReferralLetter (Builder builder){
        this.referralId =builder.referralId;
        this.referral_doctorName=builder.referral_doctorName;
        this.referralNote=builder.referralNote;

    }

    public int getReferralId() {
        return referralId;
    }

    public String getReferralNote() {
        return referralNote;
    }

    public String getReferral_doctorName() {
        return referral_doctorName;
    }

    @Override
    public String writeTemplete() {
        return null;
    }

    public static class Builder{
        private int referralId;
        private String referralNote;
        private String referral_doctorName;

        public Builder referralId(int referralId){
            this.referralId =referralId;
            return this;
        }
        public Builder referralNote(String referralNote){
            this.referralNote =referralNote;
            return this;
        }
        public Builder referral_doctorName(String referral_doctorName){
            this.referral_doctorName =referral_doctorName;
            return this;
        }
        public ReferralLetter build(){
            return new ReferralLetter(this);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }


}
