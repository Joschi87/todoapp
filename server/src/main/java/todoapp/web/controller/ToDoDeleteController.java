package todoapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import todoapp.web.service.ToDoService;

@RestController
public class ToDoDeleteController {

	@Autowired
	ToDoService todoService;
	
	@GetMapping("/deleteToDo")
	public String todoDelete(@RequestParam String id){
		return todoService.todoDelete(id);
	}
}
