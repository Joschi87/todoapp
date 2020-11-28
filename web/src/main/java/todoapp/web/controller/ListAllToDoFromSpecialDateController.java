package todoapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import todoapp.web.service.ListAllToDoFromSpecialDateService;
import todoapp.web.service.ToDoService;

@RestController
public class ListAllToDoFromSpecialDateController {
	
	@Autowired
	ToDoService todoService;

	@GetMapping(path="/allToDoAsList")
	public String allToDoAsList() {
		return todoService.representDatabaseTranslatedFromJSON();
	}
	
}
