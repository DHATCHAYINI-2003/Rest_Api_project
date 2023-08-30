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

import com.project1.demo.model.Hotel;
import com.project1.demo.service.HotelService;

@RestController
public class HotelController {
    @Autowired
   HotelService hotelservice;

    @GetMapping("showhotels")
    public List<Hotel> getAllHotels() {
        return hotelservice.show();
    }
    
    @PostMapping("addhotels")
    public Hotel createHotel(@RequestBody Hotel h) {
        return hotelservice.addinfo(h);
    }
    @PutMapping("updatehotels")
    public Hotel updatehotel(@RequestBody Hotel h) {
    	return hotelservice.updateinfo(h);
    }
    @DeleteMapping("deletehotels")
    public void deletehotel(@RequestBody Hotel h) {
    	hotelservice.del(h);
    }
   
	
	@GetMapping("hotelSort/{field}")
	public List<Hotel> sort(@PathVariable String field)
	{
		return hotelservice.sort(field);
	}
	
	@GetMapping("hotelPage/{pno}/{psize}")
	public List<Hotel> sort(@PathVariable int pno, @PathVariable int psize)
	{
		return hotelservice.page(pno, psize);
	}
	
	@GetMapping("hotelPageAndSort/{pno}/{psize}/{field}")
	public List<Hotel> pageAndSort(@PathVariable int pno, @PathVariable int psize , @PathVariable String field)
	{
		return hotelservice.pageAndSort(pno, psize, field);
	}
}