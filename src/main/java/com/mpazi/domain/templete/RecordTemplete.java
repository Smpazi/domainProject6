package com.mpazi.domain.templete;


public class RecordTemplete {
    private int templeteId;
    private String templateName;
    private String templeteNote;

    private RecordTemplete(){

    }

    private RecordTemplete (Builder builder){
        this.templeteId =builder.templeteId;
        this.templateName =builder.templateName;
        this.templeteNote=builder.templeteNote;

    }

    public int getTempleteId() {
        return templeteId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public String getTempleteNote() {
        return templeteNote;
    }

    public static class Builder{
        private int templeteId;
        private String templateName;
        private String templeteNote;

        public Builder templeteId(int templeteId){
            this.templeteId =templeteId;
            return this;
        }

        public Builder templateName(String checkUpName){
            this.templateName = templateName;
            return this;
        }
        public Builder templeteNote(String templeteNote){
            this.templeteNote = templeteNote;
            return this;
        }

        public RecordTemplete build(){
            return new RecordTemplete(this);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
