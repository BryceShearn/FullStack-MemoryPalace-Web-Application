package com.skilldistillery.languages.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.languages.entities.User;

public interface LanguageRepository extends JpaRepository<User, Integer>{

}
