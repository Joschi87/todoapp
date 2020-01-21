package todoapp.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import todoapp.web.entity.ListOfAllToDoEntity;
import todoapp.web.service.ListOfAllToDosService;

@RestController
public class ListOfAllToDoController {
	
	@Autowired
	ListOfAllToDosService listService;

	@RequestMapping(
					path="/allToDoAsList",
					method = RequestMethod.GET)
	public List<String> getAllToDosFromDatabase() {
		
		JSONArray listArray = new JSONArray(listService.getAllToDos());
		List<String> test = new ArrayList<>();
		for(int i = 0; i < listArray.length(); i++) {
			test.add(listArray.getJSONObject(i).getString("toDoDate"));
		}
		
		return test;
		
	}
	
}
