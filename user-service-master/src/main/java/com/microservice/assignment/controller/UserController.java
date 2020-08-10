package com.ms.assignment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.assignment.entity.User;
import com.ms.assignment.service.IUserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private IUserService userService;

	@GetMapping("/{user-id}")
	public User findUserByUserId(@PathVariable("user-id") Long userId) {
		LOGGER.debug("New request for userid- {}", userId);
		return userService.findUserByUserId(userId);
	}

}
