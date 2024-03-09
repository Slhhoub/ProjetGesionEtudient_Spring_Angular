package com.gestionStudent.gestionStudent.service.role;

import com.gestionStudent.gestionStudent.entity.Role;
import com.gestionStudent.gestionStudent.entity.User;
import com.gestionStudent.gestionStudent.repository.RoleRepository;
import com.gestionStudent.gestionStudent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }
    @Override
    public Optional<Role> getRoleById(Integer id) {
        return roleRepository.findById(id);
    }

    @Override
    public Role creteRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(Integer id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role updateRole(Role role, Integer id) {
        Optional<Role> roleOptional = roleRepository.findById(id);
        if(roleOptional.isPresent()){
            Role existingRole = roleOptional.get();
            existingRole.setRoleName(role.getRoleName());
            return roleRepository.save(existingRole);
        }else {
            throw new RuntimeException("role not found with id: " + id);
        }
    }




    @Override
    public void addRoleToUser(String username, String roleName) {
        if (roleName == null) {
            throw new IllegalArgumentException("Role name cannot be null");
        }
        Optional<User> userOptional = userRepository.findByUsername(username);
        Optional<Role> roleOptional = roleRepository.findByRoleName(roleName);

        if (userOptional.isPresent() && roleOptional.isPresent()) {
            User user = userOptional.get();
            Role role = roleOptional.get();

            // Assurez-vous que l'utilisateur n'a pas déjà ce rôle pour éviter les doublons
            if (!user.getRole().contains(role)) {
                user.getRole().add(role);
                userRepository.save(user); // Sauvegarder les modifications de l'utilisateur
            }
        } else {
            // Gérer le cas où l'utilisateur ou le rôle n'est pas trouvé
            if (!userOptional.isPresent()) {
                throw new RuntimeException("User not found with username: " + username);
            }
            if (!roleOptional.isPresent()) {
                throw new RuntimeException("Role not found with roleName: " + roleName);
            }
        }
    }

}
