package com.mpazi.domain;

public class TransferLetter implements TempleteLetter{
    private String transferNote;

    private TransferLetter(){

    }

    private TransferLetter (Builder builder){
        this.transferNote =builder.transferNote;

    }

    public String getTransferNote() {
        return transferNote;
    }

    @Override
    public String writeTemplete() {
        return null;
    }

    public static class Builder{
        private String transferNote;

        public Builder transferNote(String transferNote){
            this.transferNote =transferNote;
            return this;
        }


        public TransferLetter build(){
            return new TransferLetter(this);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
