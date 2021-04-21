package todoapp.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import todoapp.web.service.ToDoService;

@RestController
public class CreatingToDoController {
	
	@Autowired
	ToDoService todoService;
	
	@PostMapping(path = "/newToDo")
	public ResponseEntity<String> NewToDo(@RequestParam String titleOfToDo, @RequestParam String dateOfToDo, @RequestParam String timeOfToDo, @RequestParam String priorityOfToDo, @RequestParam String textForToDo, HttpServletRequest request){
		return todoService.createToDo(titleOfToDo, dateOfToDo, timeOfToDo, priorityOfToDo, textForToDo, request);
	}

}
