package com.ms.assignment.service;

import com.ms.assignment.model.UserOrder;

public interface IUserOrderService {

	UserOrder findUserOrderByUserId(Long userId);

}
