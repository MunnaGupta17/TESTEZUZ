package com.userManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.userManagement.exceptions.UserException;
import com.userManagement.models.User;
import com.userManagement.services.UserServices;

@RestController
public class UserController {
	
	@Autowired
	private UserServices userServices;
	
	@PostMapping("/users")
	public ResponseEntity<User> registerUserHandler(@RequestBody User user) throws UserException{
		
			return new ResponseEntity<>(userServices.registerUser(user),HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserByIdHandler(@PathVariable("id") Integer id) throws UserException{
		return new ResponseEntity<User>(userServices.getUser(id),HttpStatus.OK);
	}
	
	@PostMapping("/users/update")
	public ResponseEntity<String> updateUserHandler(@RequestBody User user) throws UserException{
		return new ResponseEntity<String>(userServices.updateUser(user),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/users")
	public ResponseEntity<String> deleteUserHandler(@PathVariable("id") Integer id) throws UserException{
		return new ResponseEntity<String>(userServices.deleteUser(id),HttpStatus.OK);
	}
	
	@GetMapping("/users/all")
	public ResponseEntity<List<User>> getAllUsersHandler() throws UserException{
		return new ResponseEntity<List<User>>(userServices.getAllUsers(),HttpStatus.OK);
	}

	
}
