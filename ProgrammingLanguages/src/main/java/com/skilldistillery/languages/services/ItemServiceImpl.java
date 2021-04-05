package com.skilldistillery.languages.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.languages.entities.Item;
import com.skilldistillery.languages.entities.Room;
import com.skilldistillery.languages.repositories.ItemRepository;
import com.skilldistillery.languages.repositories.RoomRepository;

@Service
@Transactional
public class ItemServiceImpl implements ItemService{

	@Autowired
	private ItemRepository itemRepo;
	
	@Autowired
	private RoomRepository roomRepo;

	
	@Override
	public List<Item> listItemsForRoomId(int roomId) {
		if (! roomRepo.existsById(roomId)) {
		return null;
		}
	return itemRepo.findByRoom_Id(roomId);
	}
	
	
	@Override
	public Item createItem(int roomId, Item item) {
		Optional <Room> roomOpt = roomRepo.findById(roomId);
		if (roomOpt.isPresent()) {
			item.setRoom(roomOpt.get());
			return itemRepo.saveAndFlush(item);
		}
		return null;
	}

	
	@Override
	public boolean deleteItem(Integer itemId, Integer roomId) {
		boolean deleted = false;
		Optional<Item> itemOpt = itemRepo.findById(itemId);
		if(itemOpt.isPresent()) {
			if (itemOpt.get().getRoom().getId() == roomId) {
				itemRepo.deleteById(itemId);
				deleted = true;
			}
		}
		return deleted;
	}
}
