package com.example.gwak.service;

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
		List<TodoList>todoList = todoListMapper.selectTil(id);
		return todoList;
	}
	
	@Override
	public void insertTil(TodoList til) {
		todoListMapper.insertTil(til);
	}
	
	@Override
	public void updateTil(List<TodoList> til) {
		for(TodoList todoList:til) {
			todoListMapper.updateTil(todoList);
		}
	}
	
	@Override
	public void deleteTil(TodoList til) {
		todoListMapper.deleteTil(til);
	}
}
