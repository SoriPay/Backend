package com.example.backend0.model.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDao { // auto-writing / Data Access Object
	@Autowired
	private UserRepository repository;


	public User save(User user){
		repository.save(user); // repository 함수가 다 자동으로 해줌
		//return user;
		return user;
	}

	public List<User> getAllUsers(){
		List<User> users = new ArrayList<>();
		Streamable.of(repository.findAll()).
				forEach(users::add);
		return users;
	}

	public void delete(String userId){
		repository.deleteById(userId);
	}


}