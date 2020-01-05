package todoapp.web.controller;



import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import todoapp.database.Database;

@RestController
public class CreatingToDoController {
	
	@PostMapping(path = "/newToDo")
	public void NewToDo(@RequestParam String titleOfToDo, @RequestParam String dateOfToDo, @RequestParam String timeOfToDo, @RequestParam String priorityOfToDo, @RequestParam String textForToDo){
		System.out.println(titleOfToDo + "\n" + dateOfToDo + "\n" + timeOfToDo + "\n" + priorityOfToDo + "\n" + textForToDo);
	}

}
