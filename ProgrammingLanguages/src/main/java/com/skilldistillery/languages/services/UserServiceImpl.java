package com.skilldistillery.languages.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.languages.entities.Room;
import com.skilldistillery.languages.entities.User;
import com.skilldistillery.languages.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	
	@Override
	public List<Room> listRoomsForUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Room createRoom(int userId, Room room) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteRoom(Integer roomId, Integer userId) {
		// TODO Auto-generated method stub
		return false;
	}
}
