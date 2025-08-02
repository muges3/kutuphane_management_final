package com.example.library.controller;

import com.example.library.entity.User;
import com.example.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;



@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
	
	private final UserService userService;
	
	
	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@PostMapping
	public User addUser(@RequestBody User user) {
		
		return userService.addUser(user);
	}
	
	@GetMapping("/{id}")
		public User getUserById(@PathVariable Long id) {
			
		return userService.getUserById(id);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}
	
	

}
