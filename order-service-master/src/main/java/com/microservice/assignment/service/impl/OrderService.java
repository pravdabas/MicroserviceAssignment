package com.ms.assignment.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.assignment.entity.Order;
import com.ms.assignment.repo.OrderRepository;
import com.ms.assignment.service.IOrderService;

@Service
public class OrderService implements IOrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Order findOrderByOrderId(Long orderId) {
		return orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("No order found"));
	}

	@Override
	public List<Order> findOrdersByUserId(Long userId) {
		List<Order> orderByUser = orderRepository.findAllByUserId(userId);
		return orderByUser.stream().map(order -> {
			order.setUserId(null);
			return order;
		}).collect(Collectors.toList());
	}

}
