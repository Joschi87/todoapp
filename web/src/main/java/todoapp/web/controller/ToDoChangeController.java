package todoapp.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import todoapp.web.entity.CreateToDoEntity;
import todoapp.web.repository.CreateToDoRepository;

@RestController
public class ToDoChangeController {
	
	@Autowired
	CreateToDoRepository createRepo;

	@PostMapping("/changeToDo")
	public String changeToDo(@RequestParam String id, @RequestParam String title, @RequestParam String date, @RequestParam String time, @RequestParam String priority, @RequestParam String text) {
		
		Integer deleteID = Integer.parseInt(id);
		
		String output = "";
		
		createRepo.deleteById(deleteID);
		
		if (createRepo.existsById(deleteID) != true) {
			
			CreateToDoEntity createNewToDo = new CreateToDoEntity();
			List<CreateToDoEntity> listNewToDo = new ArrayList<>();
			
			createNewToDo.setTitleOfToDo(title);
			createNewToDo.setDateOfToDo(date);
			createNewToDo.setTimeOfToDo(time);
			createNewToDo.setPriorityOfToDo(priority);
			createNewToDo.setTextForToDo(text);
			
			listNewToDo.add(createNewToDo);
			
			createRepo.saveAll(listNewToDo);
			
			System.out.println("Change ToDo successfully!");
			
			output += "<script>alert('Change of ToDo Information are successfully!');window.close();</script>";
			
			
		}else {
			System.out.println("Error by deleting a ToDo");
			output += "<script>alert('Change of ToDo Information are <b>not</b> successfully!');window.close();</script>";
		}
		return output;
	}
	
}
