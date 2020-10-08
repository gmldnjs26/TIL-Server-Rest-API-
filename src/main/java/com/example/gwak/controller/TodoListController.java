package com.example.gwak.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.gwak.dto.TodoList;

@Controller
public class TodoListController {
	
	@GetMapping("/api/todolist")
	public ResponseEntity<List<TodoList>> getTIL() {
		return null;
	}
}
