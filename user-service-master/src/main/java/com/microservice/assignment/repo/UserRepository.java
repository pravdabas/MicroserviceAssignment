package com.ms.assignment.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.assignment.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByEmail(String email);

}
