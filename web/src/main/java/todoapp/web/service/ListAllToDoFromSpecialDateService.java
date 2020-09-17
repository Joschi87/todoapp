package todoapp.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todoapp.web.entity.CreateToDoEntity;
import todoapp.web.lib.web.BasicHtmlStuff;
import todoapp.web.repository.CreateToDoRepository;

@Service
public class ListAllToDoFromSpecialDateService extends BasicHtmlStuff{
	
	@Autowired
	CreateToDoRepository todoRepo;
	
	public String getAllToDoForASpecialDate() {
		
		String output = "";
		
		List<CreateToDoEntity> allToDoForTheDate = new ArrayList<>();
		todoRepo.findAll().forEach(CreateToDoEntity -> allToDoForTheDate.add(CreateToDoEntity));
		
		Object[] allToDoForTheDateObj = allToDoForTheDate.toArray();
		
		output += htmlHead + navBarForIFrame + "<br />" +  listGroupStart;
		
		for(int counter = 0; counter < allToDoForTheDateObj.length; counter++) {
			output += "<li class='list-group-item'>" + allToDoForTheDateObj[counter] + "</li>";
		}
		
		output += "</ul></script></html>";
		
		return output;
		
	}

}
