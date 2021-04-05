package com.skilldistillery.languages.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.languages.services.UserService;

@RequestMapping("api")
@RestController
public class RoomController {

	@Autowired
	private UserService svc;
	
	@GetMapping("")
	
}
