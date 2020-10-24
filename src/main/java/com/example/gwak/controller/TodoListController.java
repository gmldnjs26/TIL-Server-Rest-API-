package com.example.gwak.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.gwak.dto.TodoList;
import com.example.gwak.service.TodoListService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class TodoListController {
	
	private final TodoListService todoListService;
	
	//private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/api/selectTil")
	public ResponseEntity<List<TodoList>> selectTil(@RequestBody String id) {
		try {
			List<TodoList>todoList = todoListService.selectTil(id);
			return ResponseEntity.ok(todoList);
		} catch (Exception e) {
			log.error("ErrorMessage" + e);
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PostMapping("/api/insertTil")
	public ResponseEntity<String> insertTil(@RequestBody TodoList todoList) {
		try {
			todoListService.insertTil(todoList);
			return ResponseEntity.ok("Success");
		} catch(Exception e) {
			log.error("ErrorMessage" + e);
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PostMapping("/api/updateTil")
	public ResponseEntity<String> updateTil(TodoList til) {
		try {
			todoListService.updateTil(til);
			return ResponseEntity.ok("Success");
		} catch(Exception e) {
			log.error("ErrorMessage" + e);
			return ResponseEntity.badRequest().build();
		}
	}
}
