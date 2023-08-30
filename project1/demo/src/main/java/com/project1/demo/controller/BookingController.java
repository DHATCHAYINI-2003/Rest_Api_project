package com.project1.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project1.demo.model.Booking;
import com.project1.demo.service.BookingService;

@RestController
public class BookingController {
    @Autowired
    BookingService bookingservice;

    @GetMapping("show")
    public List<Booking> getBookingsByHotel() {
        return bookingservice.show();
    }

    @PostMapping("add")
    public Booking createBooking(@RequestBody Booking b) {
        return bookingservice.addinfo(b);
    }
    @PutMapping("update")
    public Booking updatebooking(@RequestBody Booking b) {
    	return bookingservice.updateinfo(b);
    }
    @DeleteMapping("delete")
    public void deletebooking(@RequestBody Booking b ) {
    	bookingservice.delete(b);
    }
   
	
	@GetMapping("bookingSort/{field}")
	public List<Booking> sort(@PathVariable String field)
	{
		return bookingservice.sort(field);
	}
	
	@GetMapping("bookingPage/{pno}/{psize}")
	public List<Booking> sort(@PathVariable int pno, @PathVariable int psize)
	{
		return bookingservice.page(pno, psize);
	}
	
	@GetMapping("bookingPageAndSort/{pno}/{psize}/{field}")
	public List<Booking> pageAndSort(@PathVariable int pno, @PathVariable int psize , @PathVariable String field)
	{
		return bookingservice.pageAndSort(pno, psize, field);
	}
}