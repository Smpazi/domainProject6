package com.mpazi.domain.login;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Role {
    private String roleTitle, roleDescription;

    private Role(){}

    private Role(Builder builder){
        this.roleTitle =builder.roleTitle;
        this.roleDescription =builder.roleDescription;

    }



    public String getRoleTitle() {
        return roleTitle;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public static class Builder{
        private String roleTitle, roleDescription;


        public Builder roleTitle(String roleTitle){
            this.roleTitle =roleTitle;
            return this;
        }
        public Builder roleDescription(String roleDescription){
            this.roleDescription = roleDescription;
            return this;
        }

        public Role build(){
            return new Role(this);
        }

    }

    @Override
    public String toString() {
        return "RoleService{" +
                "RoleType = " + getRoleTitle() + '\'' +
                "RoleDescription = " + getRoleDescription() + '\'' +
                '}';
    }
}
