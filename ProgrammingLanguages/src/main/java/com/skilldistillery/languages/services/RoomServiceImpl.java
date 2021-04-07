package com.skilldistillery.languages.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.languages.entities.Room;
import com.skilldistillery.languages.entities.User;
import com.skilldistillery.languages.repositories.RoomRepository;
import com.skilldistillery.languages.repositories.UserRepository;

@Service
@Transactional
public class RoomServiceImpl implements RoomService{

	@Autowired
	private RoomRepository roomRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<Room> listRoomsForUserId(int userId) {
		if (! userRepo.existsById(userId)) {
		return null;
		}
	return roomRepo.findByUser_Id(userId);
	}
	
	
	@Override
	public Room createRoom(int userId, Room room) {
		Optional <User> userOpt = userRepo.findById(userId);
		if (userOpt.isPresent()) {
			room.setUser(userOpt.get());
			return roomRepo.saveAndFlush(room);
		}
		return null;
	}

	
	@Override
	public boolean deleteRoom(Integer roomId, Integer userId) {
		boolean deleted = false;
		Optional <Room> roomOpt = roomRepo.findById(roomId);
		if(roomOpt.isPresent()) {
			if (roomOpt.get().getUser().getId() == userId) {
				roomRepo.deleteById(roomId);
				deleted = true;
			}
		}
		return deleted;
	}


	@Override
	public Room updateRoom(int roomId, Room room) {
		Optional <Room> updateRoomOpt = roomRepo.findById(roomId);
		if(updateRoomOpt.isPresent()) {
			Room managedRoom = updateRoomOpt.get();
			managedRoom.setName(room.getName());
			managedRoom.setName(room.getName());
			managedRoom.setName(room.getName());
			managedRoom.setName(room.getName());
			managedRoom.setName(room.getName());
			roomRepo.saveAndFlush(managedRoom);
			return managedRoom;
		}
		return null;
	}
}