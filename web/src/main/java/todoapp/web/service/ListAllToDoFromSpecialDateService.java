package todoapp.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todoapp.web.entity.ToDoEntity;
import todoapp.web.lib.ifs.ToDoRepository;
import todoapp.web.lib.web.BasicHtmlStuff;

@Service
public class ListAllToDoFromSpecialDateService extends BasicHtmlStuff{
	
	@Autowired
	ToDoRepository todoRepo;
	
	public  String getAllToDoForASpecialDateAsJson() {
		String output = "";
		List<ToDoEntity> allToDoForTheDate = new ArrayList<>();
		todoRepo.findAll().forEach(ToDoEntity -> allToDoForTheDate.add(ToDoEntity));
		output = allToDoForTheDate.toString();
		return output;
	}
	
	public String getAllToDosByUsername() {
		return "";
	}

}
