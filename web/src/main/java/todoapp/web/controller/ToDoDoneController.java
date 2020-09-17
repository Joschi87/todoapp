package todoapp.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import todoapp.web.entity.CreateToDoEntity;
import todoapp.web.repository.CreateToDoRepository;

@RestController
public class ToDoDoneController {
	
	@Autowired
	CreateToDoRepository createRepo;
	
	@GetMapping("/toDoDone")
	public String todoDone(@RequestParam String id, @RequestParam String title, @RequestParam String dateOfToDo, @RequestParam String timeOfToDo, @RequestParam String priority, @RequestParam String textOfToDo){
		
		Integer deleteID = Integer.parseInt(id);
		
		String output = "";
		
		createRepo.deleteById(deleteID);
		
		if (createRepo.existsById(deleteID) != true) {
			
			CreateToDoEntity createNewToDo = new CreateToDoEntity();
			List<CreateToDoEntity> listNewToDo = new ArrayList<>();
			
			createNewToDo.setTitleOfToDo(title);
			createNewToDo.setDateOfToDo(dateOfToDo);
			createNewToDo.setTimeOfToDo(timeOfToDo);
			createNewToDo.setPriorityOfToDo(priority);
			createNewToDo.setTextForToDo(textOfToDo);
			createNewToDo.setStatus("ToDo Done");
			
			listNewToDo.add(createNewToDo);
			
			createRepo.saveAll(listNewToDo);
			
			output += "\"<script>alert('ToDo Done!');window.close();</script>\"";
			
		}else {
			System.out.println("Error by done the ToDo");
			output += "<script>alert('ToDo <b>can not</b> change the status to Done');window.close();</script>";
		}
		
		return output;
	}
}
