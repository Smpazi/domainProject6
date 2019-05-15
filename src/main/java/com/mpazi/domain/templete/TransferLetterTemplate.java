package com.mpazi.domain.templete;

public class TransferLetterTemplate {
    private String transferNote;

    private TransferLetterTemplate(){

    }

    private TransferLetterTemplate(Builder builder){
        this.transferNote =builder.transferNote;

    }

    public String getTransferNote() {
        return transferNote;
    }


    public static class Builder{
        private String transferNote;

        public Builder transferNote(String transferNote){
            this.transferNote =transferNote;
            return this;
        }


        public TransferLetterTemplate build(){
            return new TransferLetterTemplate(this);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
