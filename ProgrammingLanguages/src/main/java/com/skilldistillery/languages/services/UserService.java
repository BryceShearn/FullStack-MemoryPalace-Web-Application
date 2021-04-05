package com.skilldistillery.languages.services;

import java.util.List;

import com.skilldistillery.languages.entities.User;

public interface UserService {

	List <User> allUsers();
	
	User retrieveMainLocation(String mainLocation);
	
}
