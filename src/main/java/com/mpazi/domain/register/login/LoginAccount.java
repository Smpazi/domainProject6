package com.mpazi.domain.register.login;

public class LoginAccount {
    private String staffId,userId;
    private int password;
    private Role roleType;


    private LoginAccount(){

    }

    private LoginAccount (Builder builder){
        this.staffId =builder.staffId;
        this.userId =builder.userId;
        this.password= builder.password;
        this.roleType =builder.roleType;

    }

    public String getStaffId() {
        return staffId;
    }

    public String getUserId() {
        return userId;
    }

    public int getPassword() {
        return password;
    }

    public Role getRoleType() {
        return roleType;
    }

    public static class Builder{
        private String staffId,userId;
        private int password;
        private Role roleType;

        public Builder staffId(String staffId){
            this.staffId =staffId;
            return this;
        }

        public Builder userId(String userId){
            this.staffId = staffId;
            return this;
        }
        public Builder password(int password){
            this.password = password;
            return this;
        }
        public Builder roleType(Role roleType){
            this.roleType = roleType;
            return this;
        }

        public LoginAccount build(){
            return new LoginAccount(this);
        }
    }

    @Override
    public String toString() {
        return "LoginAccountRepository{" +
                "UserId=" + getStaffId() + '\'' +
                '}';
    }
}
