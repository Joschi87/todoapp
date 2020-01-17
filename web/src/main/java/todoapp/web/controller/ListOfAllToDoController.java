package todoapp.web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import todoapp.web.entity.ListOfAllToDoEntity;
import todoapp.web.service.ListOfAllToDosService;

@RestController
public class ListOfAllToDoController {

	@RequestMapping(
					path="/allToDoAsList",
					method = RequestMethod.GET)
	public List<ListOfAllToDoEntity> getAllToDosFromDatabase() {
		
		return ListOfAllToDosService.getAllToDos();
		
	}
	
}
