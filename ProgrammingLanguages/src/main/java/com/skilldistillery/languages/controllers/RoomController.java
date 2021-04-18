package com.skilldistillery.languages.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.languages.entities.Room;
import com.skilldistillery.languages.services.RoomService;

@CrossOrigin({"*", "http://localhost:4300"})
@RequestMapping("api")
@RestController
public class RoomController {

	private int userId = 1;
	
	@Autowired
	private RoomService svc;
	
	@GetMapping("rooms")
	public List<Room> listAllRoomsForUser( 
										   HttpServletResponse resp) {
		List<Room> rooms = svc.listRoomsForUserId(userId);
		if (rooms == null) {
			resp.setStatus(404);
		}
		return rooms;
	}
	@PostMapping("rooms")
	public Room addRoomToUser(
							  @RequestBody Room room,
							  HttpServletRequest req,
							  HttpServletResponse resp) {
		room = svc.createRoom(userId, room);
			if(room != null) {
				resp.setStatus(201);
				StringBuffer url = req.getRequestURL();
				url.append("/").append(room.getId());
				resp.setHeader("Location", url.toString());
			}
			else {
				resp.setStatus(404);
				room = null;
			}
		return room;
	}
	@DeleteMapping("rooms/{roomId}")
	public void deleteRoomFromUser (@PathVariable Integer roomId,
									HttpServletResponse resp) {
		if (svc.deleteRoom(userId, roomId)) {
			resp.setStatus(204);
		}
		else {
			resp.setStatus(404);
		}
	}
}
