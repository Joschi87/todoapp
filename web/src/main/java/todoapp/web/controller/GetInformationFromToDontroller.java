package todoapp.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import todoapp.web.entity.BasicHtmlStuff;

@RestController
public class GetInformationFromToDontroller extends BasicHtmlStuff{
	
	@GetMapping("/workingAtToDo")
	public String getAllInformation(@RequestParam String title, @RequestParam String dateOfToDo, @RequestParam String timeOfToDo, @RequestParam String pririty, @RequestParam String textOfToDo) {
		
		String output = "";
		
		output += htmlHead;
		
		output += "";
		
		return output;
		
	}


}
