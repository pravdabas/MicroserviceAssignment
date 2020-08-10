package com.ms.assignment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.ms.assignment.model.Order;
import com.ms.assignment.model.User;
import com.ms.assignment.model.UserOrder;
import com.ms.assignment.service.IUserOrderService;

@Service
public class UserOrderService implements IUserOrderService {

	@Value("${external.url.service.user:localhost:9091}")
	private String urlUserService;

	@Value("${external.url.service.order:localhost:19091}")
	private String urlOrderService;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public UserOrder findUserOrderByUserId(Long userId) {
		UserOrder userOrder;
		try {

			User user = restTemplate.getForEntity(urlUserService + "/" + userId, User.class).getBody();
			List<Order> orders = getOrders(userId);

			userOrder = new UserOrder();
			userOrder.setUserDetails(user);
			userOrder.setOrders(orders);
		} catch (RestClientException e) {
			throw new RuntimeException("Order detail can't be found");
		}
		return userOrder;
	}

	private List<Order> getOrders(Long userId) {
		ParameterizedTypeReference<List<Order>> responseType = new ParameterizedTypeReference<List<Order>>() {
		};
		ResponseEntity<List<Order>> resp = restTemplate.exchange(urlOrderService + "/" + userId, HttpMethod.GET, null,
				responseType);
		return resp.getBody();
	}

}
