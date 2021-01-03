package com.example.gwak.service;

import java.util.HashMap;
import java.util.List;

import com.example.gwak.dto.TodoList;

public interface TodoListService {
	List<TodoList>selectTil(String id);
	
	void insertTil(TodoList til);
	
	void updateTil(TodoList til);
	
	void deleteTil(TodoList til);
	
	HashMap<String,String> pdfOutPut(String id);
}
