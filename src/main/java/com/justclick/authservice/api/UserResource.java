package com.justclick.authservice.api;

import java.net.URI;
import java.util.List;

import javax.servlet.Servlet;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.justclick.authservice.domains.Role;
import com.justclick.authservice.domains.User;
import com.justclick.authservice.services.UserService;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserResource {
    private final UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>>getUsers(){
        return ResponseEntity.ok(userService.getAllUser());
    }

    @PostMapping("/create")
    public ResponseEntity<User>createUser(@RequestBody User user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/create").toUriString());
        return ResponseEntity.created(uri).body(userService.writeUser(user));
    }

    @PostMapping("/role/create")
    public ResponseEntity<Role>createRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/role/create").toUriString());
        return ResponseEntity.created(uri).body(userService.writeRole(role));
    }

    @PostMapping("/role/map")
    public ResponseEntity<?>mapRole(@RequestBody  RoleMappingForm form){
        userService.addRoleToUser(form.getUsername(), form.getRolename());
        return ResponseEntity.ok().build();
    }
}

@Data
    class RoleMappingForm {
        private String username;
        private String rolename;
    }
