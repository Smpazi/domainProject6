package com.mpazi.domain.login;

import java.util.Objects;

public class UserPasswordReset {
    private String email,userId;
    private int oldPassword,newPassword;

    private UserPasswordReset(){

    }

    private UserPasswordReset(Builder builder){
        this.userId = builder.userId;
        this.email = builder.email;
        this.newPassword = builder.newPassword;
        this.oldPassword = builder.oldPassword;
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
        return "PasswordReset {" +
                "UserId = " + getUserId() + '\'' +
                "Email = " + getEmail() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPasswordReset userPasswordReset = (UserPasswordReset) o;
        return userId.equals(userPasswordReset.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
