
package com.justclick.authservice;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.justclick.authservice.domains.Role;
import com.justclick.authservice.domains.User;
import com.justclick.authservice.services.UserService;

@SpringBootApplication
public class AuthserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthserviceApplication.class, args);
	}

	@Bean
	BCryptPasswordEncoder encoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.writeUser(new User(null, "John Doe", "johndoe", "password", new ArrayList<>()));
			userService.writeUser(new User(null, "John Travolta", "johntravolta", "password", new ArrayList<>()));
			userService.writeUser(new User(null, "John Cena", "johncena", "password", new ArrayList<>()));
			userService.writeRole(new Role(null, "manager"));
			userService.writeRole(new Role(null, "employee"));
			userService.writeRole(new Role(null, "guest"));
			userService.addRoleToUser("johndoe", "guest");
			userService.addRoleToUser("johncena", "employee");
			userService.addRoleToUser("johntravolta", "manager");
			userService.addRoleToUser("johntravolta", "employee");
		};
	}

}
