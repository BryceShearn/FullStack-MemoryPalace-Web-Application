package com.skilldistillery.languages.services;

import java.util.List;

import com.skilldistillery.languages.entities.Room;

public interface RoomService {

	public List<Room> listRoomsForUserId(int userId);
	
	Room createRoom(int roomId, Room Room);

	public boolean deleteRoom(Integer roomId, Integer userId); 
}
