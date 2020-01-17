package todoapp.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import todoapp.web.entity.CreateToDoEntity;
import todoapp.web.entity.ListOfAllToDoEntity;
import todoapp.web.repository.CreateToDoRepository;
import todoapp.web.repository.ListOfAllToDoRepository;


@RestController
public class CreatingToDoController {
	
	@Autowired
	CreateToDoRepository createToDoRepo;
	
	@Autowired
	ListOfAllToDoRepository listOfAllToDosRepository;
	
	@PostMapping(path = "/newToDo")
	public void NewToDo(@RequestParam String titleOfToDo, @RequestParam String dateOfToDo, @RequestParam String timeOfToDo, @RequestParam String priorityOfToDo, @RequestParam String textForToDo){
		CreateToDoEntity createEntity = new CreateToDoEntity();
		ListOfAllToDoEntity listOfAllToDoEntitiy = new ListOfAllToDoEntity();
		List<CreateToDoEntity> listCreatingNewToDo = new ArrayList<>();
		List<ListOfAllToDoEntity> listOfAllToDos = new ArrayList<>();
		
		createEntity.setTitleOfToDo(titleOfToDo);
		createEntity.setDateOfToDo(dateOfToDo);
		createEntity.setTimeOfToDo(timeOfToDo);
		createEntity.setPriorityOfToDo(priorityOfToDo);
		createEntity.setTextForToDo(textForToDo);
		
		listOfAllToDoEntitiy.setToDoDate(dateOfToDo);
		
		listCreatingNewToDo.add(createEntity);
		
		listOfAllToDos.add(listOfAllToDoEntitiy);
		
		createToDoRepo.saveAll(listCreatingNewToDo);
		listOfAllToDosRepository.saveAll(listOfAllToDos);
		
	}

}
