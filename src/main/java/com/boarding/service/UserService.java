package com.boarding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boarding.DTO.UserDTO;
import com.boarding.entity.User;
import com.boarding.exception.UsersException;
import com.boarding.respository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User addUser(UserDTO userDto) {
		User existingUser = userRepository.findByEmail(userDto.getEmail());

		if (existingUser != null) {
			throw new UsersException("Username already exists");
		}

		User user = new User();
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		return userRepository.save(user);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	public Boolean deleteUser(Long id) {
		try {
			userRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			System.err.println(e);
			return false;
		}
	}

	public User authenticateUser(UserDTO user) {
		User userDetails = userRepository.findByEmail(user.getEmail());
		if (userDetails != null && user.getPassword().equals(userDetails.getPassword()))
			return userDetails;
		return null;
	}

}
