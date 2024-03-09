package com.gestionStudent.gestionStudent.controller.role;


import lombok.Data;
import lombok.Getter;

@Getter
@Data
class UserRoleForm {
    private String username;
    private String roleName;

    // Getters and setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}

