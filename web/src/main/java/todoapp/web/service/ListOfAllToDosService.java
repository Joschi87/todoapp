package todoapp.web.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todoapp.web.entity.ListOfAllToDoEntity;
import todoapp.web.repository.ListOfAllToDoRepository;

@Service
public class ListOfAllToDosService {
	
	@Autowired
	ListOfAllToDoRepository listOfAllToDoRepo;
	
	public String getAllToDos(){
		
		String outputString = "";
		
		List<ListOfAllToDoEntity> listAllToDo = new ArrayList<>();
		listOfAllToDoRepo.findAll().forEach(listOfAllToDoEntity -> listAllToDo.add(listOfAllToDoEntity));
		
		Object[] test = listAllToDo.toArray();
		
		for(int counter = 0; counter < test.length; counter ++ ) {
			outputString += test[counter];
		}
		
		return outputString;
	}

}
