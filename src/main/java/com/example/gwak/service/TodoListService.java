package com.example.gwak.service;

import java.util.List;

import com.example.gwak.dto.TodoList;

public interface TodoListService {
	List<TodoList>selectTil(String id);
	
	void insertTil(TodoList til);
	
	void updateTil(List<TodoList> til);
	
	void deleteTil(TodoList til);
}
