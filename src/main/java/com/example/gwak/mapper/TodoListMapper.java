package com.example.gwak.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.gwak.dto.TodoList;

@Mapper
public interface TodoListMapper {
	List<TodoList>getTIL(String id);	
}
