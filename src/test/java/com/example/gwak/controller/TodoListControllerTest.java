package com.example.gwak.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.gwak.dto.TodoList;
import com.fasterxml.jackson.databind.ObjectMapper;

/* SpringSecurity doesn't restirct for this Test */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoListControllerTest {

	@Autowired
	private TodoListController todoListController;

	@Autowired
	private ObjectMapper objectMapper;

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(todoListController).build();
	}

	@Test
	public void createTodoList() throws Exception {
		TodoList todoList = TodoList.builder()
				.id("Gwakheewon12")
				.title("Title1")
				.contents("Content5")
				.createdat("20201022")
				.build();
		mockMvc.perform(post("/api/insertTil")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(objectMapper.writeValueAsString(todoList)))
		.andDo(print())
		.andExpect(status().isOk());
	}

	@Test
	public void updateTodoList() {

	}

	@Test
	public void selectTodoList() throws Exception {
		//given
		String id = "Gwakheewon12";

		MvcResult result =  
				mockMvc.perform(get("/api/selectTil")
						.content(id))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
		String content = result.getResponse().getContentAsString();

		List<TodoList> todoList = Arrays.asList(objectMapper.readValue(content, TodoList[].class));

		Assert.assertTrue(todoList.get(0).getTitle().equals("Title1"));
	}

	@Test
	public void deleteTodoList() throws Exception {
		//given
		TodoList todoList = TodoList.builder()
				.id("Gwakheewon12")
				.tilno(1)
				.build();
		
		mockMvc.perform(post("/api/deleteTil")
						.contentType(MediaType.APPLICATION_JSON_UTF8)
						.content(objectMapper.writeValueAsString(todoList)))
				.andDo(print())
				.andExpect(status().is(200));

	}

}
