package com.example.gwak.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoList {
	private String id;
	private String title;
	private String contents;
	private String createAt; // 만든 날짜
	private Integer completed; // 0:Not Completed 1:Completed
}
