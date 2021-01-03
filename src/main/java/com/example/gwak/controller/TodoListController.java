package com.example.gwak.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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
	
	private static final String RESULT = "result";
	private static final String PRINT_RESULT = "print_result";
	private static final String FILE_PATH = "filePath";
	private static final String FILE_NAME = "fileName";
	
	private final TodoListService todoListService;
	
	@GetMapping(value = "/api/selectTil", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<TodoList>> selectTil(String id) {
		try {
			List<TodoList>todoList = todoListService.selectTil(id);
			return ResponseEntity.ok(todoList);
		} catch (Exception e) {
			log.error("ErrorMessage" + e);
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PostMapping(value = "/api/insertTil", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> insertTil(@RequestBody TodoList todoList) {
		try {
			todoListService.insertTil(todoList);
			return ResponseEntity.ok("Success");
		} catch(Exception e) {
			log.error("ErrorMessage" + e);
			return ResponseEntity.badRequest().build();
		}
	}
	
	
	/* Update 사양 변경
	      업데이트 버튼 클릭시 
	      현재 리스트들을 내용을 반영  */
	@PostMapping(value = "/api/updateTil", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> updateTil(@RequestBody TodoList til) {
		try {
			todoListService.updateTil(til);
			return ResponseEntity.ok("Success");
		} catch(Exception e) {
			log.error("ErrorMessage" + e);
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PostMapping(value = "/api/deleteTil", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> deleteTil(@RequestBody TodoList til) {
		try {
			todoListService.deleteTil(til);
			return ResponseEntity.ok("Success");
		} catch(Exception e) {
			log.error("ErrorMessage" + e);
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PostMapping(value = "/api/PDFTil", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<InputStreamResource> print(@RequestBody String id) {
		HashMap<String,String> fileInfo = new HashMap<String,String>();
		
		InputStreamResource resource = new InputStreamResource(new FileInputStream(new File()));
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("", "");
		headers.add("", "");
		return ResponseEntity.ok()
				.headers(headers)
				.contentType(MediaType.APPLICATION_PDF)
				.body(resource);
	}
}
