package com.mpazi.domain.register.login;

public class Role {
    private int roleId;
    private String roleTitle, roleDescription;

    private Role(){}

    private Role(Builder builder){
        this.roleId =builder.roleId;
        this.roleTitle =builder.roleTitle;
        this.roleDescription =builder.roleDescription;

    }

    public int getRoleId() {
        return roleId;
    }

    public String getRoleTitle() {
        return roleTitle;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public static class Builder{
        private int roleId;
        private String roleTitle, roleDescription;

        public Builder roleId(int roleId){
            this.roleId =roleId;
            return this;
        }
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
        return "RoleRepository{" +
                "=" + getRoleTitle() + '\'' +
                '}';        }
}
