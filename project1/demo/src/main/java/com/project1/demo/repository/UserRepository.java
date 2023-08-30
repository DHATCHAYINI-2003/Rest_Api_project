package com.project1.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.project1.demo.model.User;
public interface UserRepository extends JpaRepository<User, Integer> {
	
}
