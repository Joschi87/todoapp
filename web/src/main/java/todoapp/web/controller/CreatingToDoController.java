package todoapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import todoapp.web.service.ToDoService;

@RestController
public class CreatingToDoController {
	
	@Autowired
	ToDoService todoService;
	
	@PostMapping(path = "/newToDo")
	public void NewToDo(@RequestParam String titleOfToDo, @RequestParam String dateOfToDo, @RequestParam String timeOfToDo, @RequestParam String priorityOfToDo, @RequestParam String textForToDo){
		todoService.createToDo(titleOfToDo, dateOfToDo, timeOfToDo, priorityOfToDo, textForToDo);
	}

}
