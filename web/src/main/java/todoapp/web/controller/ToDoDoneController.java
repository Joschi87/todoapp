package todoapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import todoapp.web.repository.CreateToDoRepository;

@RestController
public class ToDoDoneController {
	
	@Autowired
	CreateToDoRepository creatingRepo;
	
	@GetMapping("/toDoDone")
	public String todoDone(@RequestParam String id){
		
		int deleteID = Integer.parseInt(id);
		
		creatingRepo.deleteById(deleteID);
		
		return "<script>alert('ToDo Done and delete from database!');window.close();</script>";
	}
}
