package todoapp.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping(
			method = RequestMethod.GET,
			path="/newToDo"
			)
	public void sayHello(@RequestParam String titleOfToDo, @RequestParam String dateOfToDo, @RequestParam String timeOfToDo, @RequestParam String priorityOfToDo, @RequestParam String textForToDo) {
		//String test = "Das iswt ein Test auf index.html";
		System.out.println(titleOfToDo +"\n"+ dateOfToDo +"\n"+ timeOfToDo + "\n"+ priorityOfToDo +"\n" + textForToDo);
	}
}
