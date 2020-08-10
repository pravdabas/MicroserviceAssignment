package com.ms.assignment.service;

import java.util.List;

import com.ms.assignment.entity.User;

public interface IUserService {

	User findUserByUserId(Long userId);

	List<User> findUsersByUserId(List<Long> userIds);

	List<User> findUsersByEmail(String email);

}
