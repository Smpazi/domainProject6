package com.mpazi.domain.register.login;

import java.util.Date;

public class UserPasswordReset {
    private String email,userId;
    private int oldPassword,newPassword;

    private UserPasswordReset(){

    }

    private UserPasswordReset(Builder builder){

    }

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public int getOldPassword() {
        return oldPassword;
    }

    public int getNewPassword() {
        return newPassword;
    }

    public static class Builder{
        private String email,userId;
        private int oldPassword,newPassword;

        public Builder userId(String userId){
            this.userId =userId;
            return this;
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }
        public Builder oldPassword(int oldPassword){
            this.oldPassword = oldPassword;
            return this;
        }
        public Builder newPassword(int newPassword){
            this.newPassword = newPassword;
            return this;
        }

        public UserPasswordReset build(){
            return new UserPasswordReset(this);
        }
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
