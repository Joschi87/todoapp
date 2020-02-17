package todoapp.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todoapp.web.entity.BasicHtmlStuff;
import todoapp.web.entity.CreateToDoEntity;
import todoapp.web.repository.CreateToDoRepository;

@Service
public class ListAllToDoFromSpecialDateService extends BasicHtmlStuff{
	
	@Autowired
	CreateToDoRepository todoRepo;
	
	public String getAllToDoForASpecialDate(String dateOfToDo) {
		
		String output = "";
		
		List<CreateToDoEntity> allToDoForTheDate = new ArrayList<>();
		todoRepo.findByDateOfToDo(dateOfToDo).forEach(CreateToDoEntity -> allToDoForTheDate.add(CreateToDoEntity));
		
		Object[] allToDoForTheDateObj = allToDoForTheDate.toArray();
		
		output += htmlHead + listGroupStart;
		
		for(int counter = 0; counter < allToDoForTheDateObj.length; counter++) {
			output += "<li class='list-group-item'>" + allToDoForTheDateObj[counter] + "</li>";
		}
		
		output += "</ul></html>";
		
		System.out.println(output);
		
		return output;
		
	}

}
