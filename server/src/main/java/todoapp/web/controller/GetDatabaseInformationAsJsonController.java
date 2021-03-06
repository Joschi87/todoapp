package todoapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import todoapp.web.service.ListAllToDoFromSpecialDateService;

@RestController
public class GetDatabaseInformationAsJsonController {

	@Autowired
	ListAllToDoFromSpecialDateService service;
	
	@GetMapping(path="/json/getDatabase")
	public String getDatabaseInfromationAsJson() {
		return service.getAllToDoForASpecialDateAsJson();
	}
	
}
