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
	
	private String title;
	
	private String contents;
	
	private String createAt; // 만든 날짜
	
	private Integer completed; // 0:Not Completed 1:Completed
}
