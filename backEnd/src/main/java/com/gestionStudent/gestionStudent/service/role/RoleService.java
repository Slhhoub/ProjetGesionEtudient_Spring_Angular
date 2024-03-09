package com.gestionStudent.gestionStudent.service.role;

import com.gestionStudent.gestionStudent.entity.Role;
import com.gestionStudent.gestionStudent.entity.User;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    List<Role> getAllRole();

    Optional<Role> getRoleById(Integer id);

    Role creteRole(Role role);

    void deleteRole(Integer id);

    Role updateRole(Role role,Integer id);

    void addRoleToUser(String username,String roleName);
}
