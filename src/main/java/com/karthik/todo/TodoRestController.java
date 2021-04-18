package com.karthik.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoRestController {
	@Autowired
	private TodoService service;

	@RequestMapping(value = "/todo/", method = RequestMethod.GET)
	public List<Todo> listAllTodos() {
		List<Todo> users = service.retrieveTodos("subject");
		return users;
	}

	
	@RequestMapping(value = "/todo/{id}")
	public Todo listAllTodos(@PathVariable int id) {
		Todo users = service.retrieveTodo(id);
		return users;
	}

	
}
