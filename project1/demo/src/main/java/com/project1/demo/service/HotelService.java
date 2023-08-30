package com.project1.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.project1.demo.model.Hotel;
import com.project1.demo.repository.HotelRepository;

@Service
public class HotelService {
@Autowired
HotelRepository hotelrepository;
public Hotel addinfo(Hotel hotel) {
	return hotelrepository.save(hotel);
}
public List<Hotel> show(){
	return hotelrepository.findAll();
}
public Hotel updateinfo(Hotel hotel) {
	return hotelrepository.saveAndFlush(hotel);
}
public void del(Hotel hotel) {
	hotelrepository.delete(hotel);
}


public List<Hotel> sort(String s)
{
	return hotelrepository.findAll(Sort.by(Sort.DEFAULT_DIRECTION,s));
}

public List<Hotel> page(int pno, int psize)
{
	Page<Hotel> page= hotelrepository.findAll(PageRequest.of(pno,psize));
	return page.getContent();
}

public List<Hotel> pageAndSort(int pno, int psize, String s)
{
	Page<Hotel> page= hotelrepository.findAll(PageRequest.of(pno, psize, Sort.by(Sort.DEFAULT_DIRECTION,s)));
	return page.getContent();
}
}
