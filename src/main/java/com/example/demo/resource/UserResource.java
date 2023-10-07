package com.example.demo.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	@Autowired
	public UserService userService;
	
	@GetMapping("/")
	List<User> findAll() {
		return userService.findAll();
	}
	
	@GetMapping("/{id}")
	Optional<User> findById(@PathVariable Long id) {
		return userService.findById(id);
	}
	
	@PostMapping("/")
	User insert(@RequestBody User user) {
		return userService.insert(user);
	}
	
	@DeleteMapping("/{id}")
	void delete(User user) {
		userService.delete(user);
	}
	
	@PutMapping("/{id}")
	public User update(@RequestBody User newUser, @PathVariable Long id) {
		return userService.update(newUser, id);
	}
}
