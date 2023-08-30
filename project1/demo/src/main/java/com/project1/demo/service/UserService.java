package com.project1.demo.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.project1.demo.model.User;
import com.project1.demo.repository.UserRepository;

@Service
public class UserService {
@Autowired
UserRepository userrepository;
public User addinfo(User use) {
	return userrepository.save(use);
}
public List<User> show(){
	return userrepository.findAll();
}
public User updateinfo(User use) {
	return userrepository.saveAndFlush(use);
}
public void delete(User use) {
	userrepository.delete(use);
}


public List<User> sort(String s)
{
	return userrepository.findAll(Sort.by(Sort.DEFAULT_DIRECTION,s));
}

public List<User> page(int pageno, int pagesize)
{
	Page<User> page= userrepository.findAll(PageRequest.of(pageno,pagesize));
	return page.getContent();
}

	
public List<User> pageAndSort(int pageno, int pagesize, String s)
{
	Page<User> page= userrepository.findAll(PageRequest.of(pageno,pagesize,Sort.by(Sort.DEFAULT_DIRECTION, s)));
	return page.getContent();
}

public User saveUser(User user) {
	return userrepository.save(user);
}

}

