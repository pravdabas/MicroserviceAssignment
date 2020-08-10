package com.ms.assignment.service;

import java.util.List;

import com.ms.assignment.entity.Order;

public interface IOrderService {
	Order findOrderByOrderId(Long orderId);

	List<Order> findOrdersByUserId(Long userId);

}
