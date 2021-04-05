package com.skilldistillery.languages.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.languages.entities.User;
import com.skilldistillery.languages.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repo;
	
	@Override
	public List<User> allLanguages() {
		return repo.findAll();
	}
	
	@Override
	public User retrieveLanguage(int languageId) {
		return null;
	}
}
