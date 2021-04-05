package com.skilldistillery.languages.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.languages.entities.Room;

public interface RoomRepository extends JpaRepository<Room, Integer>{

	List<Room> findByUser_Id(int userId);
	
	Optional<Room> findById(int Id);
}
