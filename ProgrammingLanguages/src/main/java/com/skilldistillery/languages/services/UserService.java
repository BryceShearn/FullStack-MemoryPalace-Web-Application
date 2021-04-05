package com.skilldistillery.languages.services;

import java.util.List;

import com.skilldistillery.languages.entities.Room;

public interface UserService {

	List<Room> listRoomsForUserId(int userId);

	Room createRoom(int userId, Room room);

	boolean deleteRoom(Integer roomId, Integer userId);


}
