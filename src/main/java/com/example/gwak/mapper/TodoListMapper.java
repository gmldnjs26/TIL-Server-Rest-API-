package com.example.gwak.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.gwak.dto.TodoList;

@Mapper
public interface TodoListMapper {
	List<TodoList>selectTil(String id); // Get TodoList For ID
	
	void insertTil(TodoList til); // Insert TodoList For ID, TITLE, CONTENTS
	
	void updateTil(TodoList til); // Update TodoList For ID, TILNO
	
	void deleteTil(TodoList til); // Delete TodoList For ID, TILNO
}
