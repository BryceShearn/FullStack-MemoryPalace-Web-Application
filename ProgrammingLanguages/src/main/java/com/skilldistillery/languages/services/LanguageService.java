package com.skilldistillery.languages.services;

import java.util.List;

import com.skilldistillery.languages.entities.User;

public interface LanguageService {

	List <User> allLanguages();
	User retrieveLanguage(int languageId);
}
