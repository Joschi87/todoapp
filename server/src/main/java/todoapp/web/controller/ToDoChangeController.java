package todoapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import todoapp.web.service.ToDoService;

@RestController
public class ToDoChangeController {
	
	@Autowired
	ToDoService todoService;

	@PostMapping("/changeToDo")
	public ResponseEntity<String> changeToDo(@RequestParam String id, @RequestParam String title, @RequestParam String date, @RequestParam String time, @RequestParam String priority, @RequestParam String text) {
		return todoService.todoChange(title, id, date, time, priority, text);
	}
	
}
