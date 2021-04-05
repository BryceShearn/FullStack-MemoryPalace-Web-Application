package com.skilldistillery.languages.services;

import java.util.List;

import com.skilldistillery.languages.entities.Item;

public interface ItemService {

	public List<Item> listItemsForRoomId(int roomId);
	
	Item createItem(int itemId, Item item);
	
	public boolean deleteItem(Integer itemId, Integer roomId);
	
}
