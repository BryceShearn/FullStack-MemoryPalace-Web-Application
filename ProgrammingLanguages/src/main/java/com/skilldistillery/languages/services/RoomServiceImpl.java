package com.skilldistillery.languages.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.languages.entities.User;
import com.skilldistillery.languages.repositories.UserRepository;

@Service
@Transactional
public class RoomServiceImpl implements UserService{

	@Autowired
	private UserRepository repo;
	
	@Override
	public List<User> allUsers() {
		return repo.findAll();
	}
	
	@Override
	public User retrieveMainLocation(String mainLocation) {
		return retrieveMainLocation(mainLocation);
	}
}
