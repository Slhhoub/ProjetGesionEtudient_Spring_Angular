package com.gestionStudent.gestionStudent.controller.role;

import com.gestionStudent.gestionStudent.entity.Role;
import com.gestionStudent.gestionStudent.service.role.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/list")
    public ResponseEntity<List<Role>> getAllRole(){
        return ResponseEntity.ok(roleService.getAllRole());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Role>> getRoleById(@PathVariable Integer id){
        return ResponseEntity.ok(roleService.getRoleById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        return  ResponseEntity.ok(roleService.creteRole(role));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Role> updateRole(@RequestBody Role role,@PathVariable Integer id){
        return ResponseEntity.ok(roleService.updateRole(role,id)) ;
    }

    @DeleteMapping("/{id}")
    private void deleteRole(@PathVariable Integer id){
       roleService.deleteRole(id);
    }

    @PostMapping("/roleToUser")
    public void roleToUser(@RequestBody UserRoleForm userRoleForm){
        roleService.addRoleToUser(userRoleForm.getUsername(), userRoleForm.getRoleName());
    }


}
