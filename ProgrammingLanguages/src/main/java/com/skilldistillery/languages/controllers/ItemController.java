package com.skilldistillery.languages.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.languages.entities.Item;
import com.skilldistillery.languages.services.ItemService;

@RestController
@RequestMapping("api")
public class ItemController {

	@Autowired
	private ItemService svc;
	
	@GetMapping("rooms/{roomId}/items")
	public List<Item> listAllItemsForRoom(@PathVariable Integer roomId,
										   HttpServletResponse resp) {
		List<Item> items = svc.listItemsForRoomId(roomId);
		if (items == null) {
			resp.setStatus(404);
		}
		return items;
	}
	@PostMapping("rooms/{roomId}/items")
	public Item addItemToRoom(@PathVariable Integer roomId,
							  @RequestBody Item item,
							  HttpServletRequest req,
							  HttpServletResponse resp) {
		item = svc.createItem(roomId, item);
			if(item != null) {
				resp.setStatus(201);
				StringBuffer url = req.getRequestURL();
				url.append("/").append(item.getId());
				resp.setHeader("Location", url.toString());
			}
			else {
				resp.setStatus(404);
				item = null;
			}
		return item;
	}
	@DeleteMapping("rooms/{roomId}/items/{itemId)")
	public void deleteItemFromRoom (Integer roomId, 
									Integer itemId,
									HttpServletResponse resp) {
		if (svc.deleteItem(roomId, itemId)) {
			resp.setStatus(204);
		}
		else {
			resp.setStatus(404);
		}
	}
}