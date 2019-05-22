package com.mpazi.domain.login;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
@EntityScan
public class LoginAccount {
    private String staffId;
    private int password;
    private Role roleType;

    private LoginAccount(){

    }

    private LoginAccount (Builder builder){
        this.staffId =builder.staffId;
        this.password= builder.password;
        this.roleType =builder.roleType;

    }

    public String getStaffId() {
        return staffId;
    }


    public int getPassword() {
        return password;
    }

    public Role getRoleType() {
        return roleType;
    }

    public static class Builder{
        private String staffId;
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
        return "LoginAccountService{" +
                "StaffId = " + getStaffId() + '\'' +
                "UserPassword = " + getPassword() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginAccount loginAccount= (LoginAccount) o;
        return staffId.equals(loginAccount.staffId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staffId);
    }

}
