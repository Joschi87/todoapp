package todoapp.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import todoapp.web.BasicHtmlStuff;

@RestController
public class GetInformationFromToDontroller extends BasicHtmlStuff{
	
	@GetMapping("/workingAtToDo")
	public String getAllInformation(@RequestParam String title, @RequestParam String dateOfToDo, @RequestParam String timeOfToDo, @RequestParam String priority, @RequestParam String textOfToDo) {
		
		String output = "";
		
		output += htmlHead;
		
		output += "<div class='container'><br />\n"
				+ "		<form action='/changeToDo' target='iFrameForRestController' method='post'>\n"
				+ "			<div class='alert alert-warning'><label>You are working at a ToDo</label></div>\n"
				+ "			<div class='input-group mb-3'>\n"
				+ "				<label>ToDo Title:&nbsp;&nbsp;&nbsp;</label>\n"
				+ "				<input type='text' class='form-control' name='title' value='" + title + "' style='width: 200px;' />\n"
				+ "			</div>\n"
				+ "			<div class='input-group mb-3'>\n"
				+ "				<label>ToDo Date:&nbsp;&nbsp;&nbsp;</label>\n"
				+ "				<input type='date' class='form-control' name='date' value='" + dateOfToDo + "' />\n"
				+ "				<label>&nbsp;&nbsp;&nbsp;ToDo Time:&nbsp;&nbsp;&nbsp;</label>\n"
				+ "				<input type='time' class='form-control' name='time' value='" + timeOfToDo + "' />\n"
				+ "			</div>\n"
				+ "			<div class='input-group mb-3'>\n"
				+ "				<label>Priority of ToDo:&nbsp;&nbsp;&nbsp;</label>\n"
				+ "				<select name='priority' id ='priorityOfToDo'>\n"
				+ "					<option value='" + priority+ "'>" + priority + "</option>\n"
				+ "					<option value='low'>Low</option>\n" 
				+ "					<option value='middle'>Middle</option>\n" 
				+ "					<option value='high'>High</option>\n" 
				+ "					<option value='critical'>Critical</option>\n" 
				+ "				</select>\n"
				+ "			</div>\n"
				+ "			<div class='input-group mb3'>\n"
				+ "				<label>Text of ToDo:&nbsp;&nbsp;&nbsp;</label>\n"
				+ "				<textarea name='text' rows='5' clos='30'>" + textOfToDo + "</textarea>\n"
				+ "			</div>"
				+ "			<button type='submit' class='btn btn-success'>Save</button>\n"
				+ "		</form>\n"
				+ "</div>\n";
		
		return output;
		
	}
}
