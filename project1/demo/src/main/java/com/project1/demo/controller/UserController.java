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

import com.project1.demo.model.User;
import com.project1.demo.service.UserService;

@RestController
public class UserController {
    @Autowired
     UserService userservice;
    @GetMapping("showuser")
    public List<User> getBookByUser() {
        return userservice.show();
    }

    @PostMapping("adduser")
    public User createUser(@RequestBody User use) {
        return userservice.addinfo(use);
    }
    @PutMapping("updateuser")
    public User updateUser(@RequestBody User use) {
    	return userservice.updateinfo(use);
    }
    @DeleteMapping("deleteuser")
    public String deleteUser(@RequestBody User use) {
    	userservice.delete(use);
    	return "Deleted";
    }
    
	
	@GetMapping("userSort/{field}")
	public List<User> sort(@PathVariable String field)
	{
		return userservice.sort(field);
	}
	
	@GetMapping("userPage/{pageno}/{pagesize}")
	public List<User> sort(@PathVariable int pageno, @PathVariable int pagesize)
	{
		return userservice.page(pageno, pagesize);
	}
	
	@GetMapping("userPageAndSort/{pageno}/{pagesize}/{field}")
	public List<User> pageAndSort(@PathVariable int pageno, @PathVariable int pagesize , @PathVariable String field)
	{
		return userservice.pageAndSort(pageno, pagesize, field);
	}
	@PostMapping("add1")
	public User saveUser(@RequestBody User user) {
		return userservice.saveUser(user);
	}
	 @GetMapping("show1")
	    public List<User> gethotelbyUsers() {
	        return userservice.show();
	    }
	
}
