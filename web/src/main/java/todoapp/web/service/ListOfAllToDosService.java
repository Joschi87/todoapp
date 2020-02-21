package todoapp.web.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todoapp.web.BasicHtmlStuff;
import todoapp.web.entity.ListOfAllToDoEntity;
import todoapp.web.repository.ListOfAllToDoRepository;

@Service
public class ListOfAllToDosService extends BasicHtmlStuff{
	
	@Autowired
	ListOfAllToDoRepository listOfAllToDoRepo;
	
	public String getAllToDos(){
		
		String outputString = "";
		
		List<ListOfAllToDoEntity> listAllToDo = new ArrayList<>();
		listOfAllToDoRepo.findAll().forEach(listOfAllToDoEntity -> listAllToDo.add(listOfAllToDoEntity));
		
		Object[] listAllToDoObj = listAllToDo.toArray();
		
		outputString += htmlHead + listGroupStart;
		
		for(int counter = 0; counter < listAllToDoObj.length; counter ++ ) {
			outputString += "<li class='list-group-item'>" + listAllToDoObj[counter] + "</li>";
		}
		
		outputString += "</ul></html>";
		
		return outputString;
	}

}
