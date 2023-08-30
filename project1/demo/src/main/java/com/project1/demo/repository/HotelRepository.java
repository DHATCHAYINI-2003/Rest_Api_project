package com.project1.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project1.demo.model.Hotel;
public interface HotelRepository extends JpaRepository<Hotel, Long> {
	
}