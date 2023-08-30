package com.project1.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.project1.demo.model.Booking;
import com.project1.demo.repository.BookingRepository;

@Service
public class BookingService {
@Autowired
BookingRepository bookingrepository;
public Booking addinfo(Booking book) {
	return bookingrepository.save(book);
}
public List<Booking> show(){
	return bookingrepository.findAll();
}
public Booking updateinfo(Booking book) {
	return bookingrepository.saveAndFlush(book);
}
public void delete(Booking book) {
	bookingrepository.delete(book);
}

public List<Booking> sort(String s)
{
	return bookingrepository.findAll(Sort.by(Sort.DEFAULT_DIRECTION,s));
}

public List<Booking> page(int pno, int psize)
{
	Page<Booking> page= bookingrepository.findAll(PageRequest.of(pno,psize));
	return page.getContent();
}

public List<Booking> pageAndSort(int pno, int psize, String s)
{
	Page<Booking> page= bookingrepository.findAll(PageRequest.of(pno, psize, Sort.by(Sort.DEFAULT_DIRECTION,s)));
	return page.getContent();
}
}
