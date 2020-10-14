package com.example.gwak.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.gwak.dto.TodoList;
import com.example.gwak.service.TodoListService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TodoListController {
	private final TodoListService todoListService;
	
	@GetMapping("/api/selectTil")
	public ResponseEntity<List<TodoList>> selectTil(String id) {
		List<TodoList>todoList = todoListService.selectTil(id);
		return ResponseEntity.ok(todoList);
	}
	
	@PostMapping("/api/insertTil")
	public ResponseEntity<String> insertTil(TodoList til) {
		try {
			todoListService.insertTil(til);
			return ResponseEntity.ok("Success");
		} catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PostMapping("/api/updateTil")
	public ResponseEntity<String> updateTil(TodoList til) {
		try {
			todoListService.updateTil(til);
			return ResponseEntity.ok("Success");
		} catch(Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
