package com.ms.assignment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.assignment.model.UserOrder;
import com.ms.assignment.service.IUserOrderService;

@RestController
@RequestMapping("/orderdetails")
public class UserOrderController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserOrderController.class);

	@Autowired
	private IUserOrderService userOrderService;

	@GetMapping("/{user-id}")
	public UserOrder findUserByUserId(@PathVariable("user-id") Long userId) {
		LOGGER.debug("New request for userid- {}", userId);
		return userOrderService.findUserOrderByUserId(userId);
	}
	
	@GetMapping("/test")
	public String test() {
		return "App is running...";
	}
}
