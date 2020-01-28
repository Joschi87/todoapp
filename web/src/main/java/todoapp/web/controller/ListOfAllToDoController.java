package todoapp.web.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import todoapp.web.entity.ListOfAllToDoEntity;
import todoapp.web.service.ListOfAllToDosService;

@RestController
public class ListOfAllToDoController {
	
	@Autowired
	ListOfAllToDosService listService;

	@RequestMapping(
					path="/allToDoAsList",
					method = RequestMethod.GET)
	public String getAllToDosFromDatabase() {
		
		
		
		return listService.getAllToDos();
		
	}
	
}
