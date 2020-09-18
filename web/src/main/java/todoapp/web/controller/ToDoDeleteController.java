package todoapp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import todoapp.web.lib.ifs.CreateToDoRepository;

@RestController
public class ToDoDeleteController {

	
	@Autowired
	CreateToDoRepository creatingRepo;
	
	@GetMapping("/deleteToDo")
	public String todoDone(@RequestParam String id){
		
		int deleteID = Integer.parseInt(id);
		
		creatingRepo.deleteById(deleteID);
		
		return "<script>alert('ToDo are deleted from database!');window.close();</script>";
	}
}
