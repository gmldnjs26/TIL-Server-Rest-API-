package com.example.gwak.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoList {
	
	private String id;
	
	private Integer tilno; // TodoList 번호
	
	private String title;
	
	private String contents;
	
	private String createdat; // 만든 날짜
	
	private Integer completed; // 0:Not Completed 1:Completed
}
