package todoapp.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todoapp.web.entity.ListOfAllToDoEntity;
import todoapp.web.repository.ListOfAllToDoRepository;

@Service
public class ListOfAllToDosService {
	
	@Autowired
	static ListOfAllToDoRepository listOfAllToDoRepo;
	
	public static List<ListOfAllToDoEntity> getAllToDos(){
		List<ListOfAllToDoEntity> listAllToDo = new ArrayList<>();
		listOfAllToDoRepo.findAll().forEach(ListOfAllToDoEntity -> listAllToDo.add(ListOfAllToDoEntity));
		return listAllToDo;
	}

}
