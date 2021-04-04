package com.skilldistillery.languages.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.languages.entities.User;
import com.skilldistillery.languages.repositories.LanguageRepository;

@Service
@Transactional
public class LanguageServiceImpl implements LanguageService{

	@Autowired
	private LanguageRepository repo;
	
	@Override
	public List<User> allLanguages() {
		return repo.findAll();
	}
	
	@Override
	public User retrieveLanguage(int languageId) {
		return null;
	}
}
