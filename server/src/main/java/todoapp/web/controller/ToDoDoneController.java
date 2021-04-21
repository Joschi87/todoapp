package todoapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import todoapp.web.service.ToDoService;

@RestController
public class ToDoDoneController {
	
	@Autowired
	ToDoService todoService;
	
	@GetMapping("/toDoDone")
	public ResponseEntity<String> todoDone(@RequestParam String id, @RequestParam String title, @RequestParam String dateOfToDo, @RequestParam String timeOfToDo, @RequestParam String priority, @RequestParam String textOfToDo){
		return todoService.todoDone(id, title, dateOfToDo, timeOfToDo, priority, textOfToDo);
	}
}
