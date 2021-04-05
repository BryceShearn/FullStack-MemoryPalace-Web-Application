package com.skilldistillery.languages.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.languages.entities.User;
import com.skilldistillery.languages.services.UserService;

@RequestMapping("api")
@RestController
public class UserController {

	@Autowired
	private UserService svc;
	
	@GetMapping("ping")
	public String ping() {
		return "pong";
	}
	
	@GetMapping("languages")
	public List<User> listAll() {
		return svc.allLanguages();
	}



}
