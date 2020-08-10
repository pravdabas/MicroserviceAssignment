package com.ms.assignment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.assignment.entity.User;
import com.ms.assignment.repo.UserRepository;
import com.ms.assignment.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User findUserByUserId(Long userId) {
		return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("No User found"));
	}

	@Override
	public List<User> findUsersByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public List<User> findUsersByUserId(List<Long> userIds) {
		return userRepository.findAllById(userIds);
	}

}
