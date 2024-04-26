package com.example.test_many_to_many.model;

public class Role {
    private int idRole;
    private String roleName;

    public Role(int idRole, String roleName) {
        this.idRole = idRole;
        this.roleName = roleName;
    }

    public Role(String role) {
        this.roleName = role;
    }

    public Role(int idRole) {
        this.idRole = idRole;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
