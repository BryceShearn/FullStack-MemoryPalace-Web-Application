package com.skilldistillery.languages.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.languages.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

	List<Item> findByRoom_Id(int roomId);
}
