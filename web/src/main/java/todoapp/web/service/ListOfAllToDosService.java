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
	ListOfAllToDoRepository listOfAllToDoRepo;
	
	public List<ListOfAllToDoEntity> getAllToDos(){
		List<ListOfAllToDoEntity> listAllToDo = new ArrayList<>();
		listOfAllToDoRepo.findAll().forEach(listOfAllToDoEntity -> listAllToDo.add(listOfAllToDoEntity));
		return listAllToDo;
	}

}
