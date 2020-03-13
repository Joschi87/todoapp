package todoapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import todoapp.web.service.ListAllToDoFromSpecialDateService;

@RestController
public class ListAllToDoFromSpecialDateController {
	
	@Autowired
	ListAllToDoFromSpecialDateService specailDateService;

	@GetMapping(path="/allToDoAsList")
	public String testMethod() {
		
		 return specailDateService.getAllToDoForASpecialDate();

	}
	
}
