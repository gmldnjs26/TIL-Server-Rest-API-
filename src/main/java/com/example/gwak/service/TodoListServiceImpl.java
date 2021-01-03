package com.example.gwak.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gwak.dto.TodoList;
import com.example.gwak.mapper.TodoListMapper;

@Service
public class TodoListServiceImpl implements TodoListService{
	@Autowired
	private TodoListMapper todoListMapper;
	
	@Override
	public List<TodoList> selectTil(String id) {
		List<TodoList> todoList = todoListMapper.selectTil(id);
		return todoList;
	}
	
	@Override
	public void insertTil(TodoList til) {
		todoListMapper.insertTil(til);
	}
	
	@Override
	public void updateTil(TodoList til) {
		todoListMapper.updateTil(til);
	}
	
	@Override
	public void deleteTil(TodoList til) {
		todoListMapper.deleteTil(til);
	}
	
	@Override
	public HashMap<String, String> pdfOutPut(String id) {
		HashMap<String, String> fileInfoMap = new HashMap<String, String>();
		List<TodoList> todoList = todoListMapper.selectTil(id);
		return null;
	}
}
