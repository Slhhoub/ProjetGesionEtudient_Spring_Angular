package com.gestionStudent.gestionStudent.controller.auth;

import com.gestionStudent.gestionStudent.entity.User;
import com.gestionStudent.gestionStudent.service.auth.AuthService;
import com.gestionStudent.gestionStudent.service.auth.AuthenticationReponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;


    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody  User user){
        return ResponseEntity.ok(authService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationReponse> login(@RequestBody  User user){
        return ResponseEntity.ok(authService.login(user));
    }

}
