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
	
	public String getAllToDoForASpecialDate() {
		
		String output = "";
		
		List<ToDoEntity> allToDoForTheDate = new ArrayList<>();
		todoRepo.findAll().forEach(CreateToDoEntity -> allToDoForTheDate.add(CreateToDoEntity));
		
		Object[] allToDoForTheDateObj = allToDoForTheDate.toArray();
		
		output += htmlHead + navBarForIFrame + "<br />" +  listGroupStart;
		
		for(int counter = 0; counter < allToDoForTheDateObj.length; counter++) {
			output += "<li class='list-group-item'>" + allToDoForTheDateObj[counter] + "</li>";
		}
		
		output += "</ul></script></html>";
		
		return output;
		
	}
	
	public String getAllToDosByUsername() {
		return "";
	}

}
