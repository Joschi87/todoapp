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

	@GetMapping(path="/ListOfToDoAt")
	public String testMethod(@RequestParam String date) {
		
		 return specailDateService.getAllToDoForASpecialDate(date);

	}
	
}
