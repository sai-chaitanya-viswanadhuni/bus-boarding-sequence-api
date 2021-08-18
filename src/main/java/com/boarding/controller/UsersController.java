package com.boarding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boarding.DTO.UserDTO;
import com.boarding.entity.User;
import com.boarding.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("api/v1")
public class UsersController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users/register", method = RequestMethod.POST)
	public User register(@RequestBody UserDTO userDto) {
		return userService.addUser(userDto);
	}

	@RequestMapping(value = "/admin/users", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@RequestMapping(value = "/admin/users", method = RequestMethod.PUT)
	public void updateUser(@RequestBody User user) {
		userService.updateUser(user);
	}

	@RequestMapping(value = "/admin/users/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
	}

	@PostMapping("/user/authenticate")
	public ResponseEntity<User> authenticateUser(@RequestBody UserDTO user) {
		User returnedUser = userService.authenticateUser(user);
		if (returnedUser != null)
			return new ResponseEntity<User>(returnedUser, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}
}