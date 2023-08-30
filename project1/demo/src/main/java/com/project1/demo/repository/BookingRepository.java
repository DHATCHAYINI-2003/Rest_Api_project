package com.project1.demo.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project1.demo.model.Booking;
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByHotelId(Long hotelId);
}
