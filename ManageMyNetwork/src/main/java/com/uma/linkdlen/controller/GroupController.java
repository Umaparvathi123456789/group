package com.uma.linkdlen.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uma.linkdlen.entity.Groups;
import com.uma.linkdlen.repo.GroupRepository;

@RestController
@RequestMapping("/user")
public class GroupController {

	@Autowired
	private GroupRepository userRepository;
	
	@PostMapping("/new/group")
	public Groups newUser(@RequestBody Groups event) {
		return userRepository.save(event);
	}

	@GetMapping("/groups")
	public List<Groups> getAlleventDetails() {
		return userRepository.findAll();
	}

	@GetMapping("/{id}")
	
	 public Optional<Groups> getUserByeventType(@PathVariable Long id) {
		return userRepository.findById(id);
	}
	
	@PutMapping("/event/{id}")
	String updateUser(@RequestBody Groups event, @PathVariable Long id) {
		Groups event1 =userRepository.findById(id).get();
		event1.setGroupName(event1.getGroupName());
		
			event1.setDescription(event1.getDescription());
			 userRepository.save(event1);
		return "updated..";
	}

	@DeleteMapping("/event/delete/{id}")
	String deleteUser(@PathVariable Long id) {
		userRepository.deleteById(id);
		return "User with id " + id + " has been deleted success.";
	}
	@GetMapping("/event")
public String getPage() {
		return "Welcome...";
}
	
}

