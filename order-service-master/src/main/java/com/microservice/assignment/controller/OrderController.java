package com.ms.assignment.controller;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.assignment.entity.Order;
import com.ms.assignment.service.IOrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	private IOrderService orderService;

	@GetMapping("/{user-id}")
	public List<Order> findOrderByRequestParam(@PathVariable("user-id") Long userId) {
		LOGGER.info("Getting order for user id #{}", userId);
		
		List<Order> orders = null;
		if (userId != null) {
			orders = orderService.findOrdersByUserId(userId);
		} else {
			orders = Collections.emptyList();
		}
		if (CollectionUtils.isEmpty(orders)) {
			throw new RuntimeException("No Orders found");
		}
		return orders;
	}
}
