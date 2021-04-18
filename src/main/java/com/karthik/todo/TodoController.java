package com.karthik.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoController {

	@Autowired
	TodoService service;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	/* @ResponseBody */
	public String listTodos(ModelMap map) {

		map.addAttribute("todos", service.retrieveTodos(retirveLoggedInUserName()));
		return "list-todos";
	}
	
	private String retirveLoggedInUserName() {
		return "subject";
	}
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	/* @ResponseBody */
	public String showLoginPage(ModelMap model) {
		/* throw new RuntimeException("Dummy Exception"); */
		model.addAttribute("todo", new Todo(0,"subject","",new Date(),false)); 
		return "todo";
		 
	}
	
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	/* @ResponseBody */
	public String addTodo(ModelMap map,@Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		service.addTodo("subject", todo.getDesc(), new Date(), false);
		map.clear();
		return "redirect:list-todos";
	}
	
	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	/* @ResponseBody */
	public String deleteTodo(ModelMap map,@RequestParam int id) {
		service.deleteTodo(id);
		//service.addTodo("subject", desc, new Date(), false);
		map.clear();
		return "redirect:list-todos";
	}
	
	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	/* @ResponseBody */
	public String updateTodo(ModelMap map,@RequestParam int id) {
		Todo todo=service.retrieveTodo(id);
		map.addAttribute("todo",todo);
		//service.deleteTodo(id);
		//service.addTodo("subject", desc, new Date(), false);
		return "todo";
	}
	
	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	/* @ResponseBody */
	public String updateTodo(@Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		service.updateTodo(todo);
		return "redirect:list-todos";
	}
	
	/*
	 * 
	 * @RequestMapping(value="/list-todos", method=RequestMethod.POST) public String
	 * HandleLoginRequest(@RequestParam String name,@RequestParam String
	 * password,ModelMap model) { if(!service.isUserValid(name, password)) {
	 * model.put("errorMessage", "Invalid Credentials"); return "login"; }
	 * model.put("name", name); model.put("password", password); return "welcome";
	 * 
	 * }
	 */
}
