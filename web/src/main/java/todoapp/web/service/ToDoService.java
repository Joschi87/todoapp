package todoapp.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todoapp.web.entity.ToDoEntity;
import todoapp.web.lib.ifs.ToDoRepository;

@Service
public class ToDoService {
	
	@Autowired
	ToDoRepository toDoRepository;
	
	public void createToDo(String titleOfToDo, String dateOfToDo, String timeOfToDo, String priorityOfToDo, String textForToDo) {
		ToDoEntity createEntity = new ToDoEntity();
		List<ToDoEntity> listCreatingNewToDo = new ArrayList<>();
		
		createEntity.setTitleOfToDo(titleOfToDo);
		createEntity.setDateOfToDo(dateOfToDo);
		createEntity.setTimeOfToDo(timeOfToDo);
		createEntity.setPriorityOfToDo(priorityOfToDo);
		createEntity.setTextForToDo(textForToDo);
		createEntity.setStatus("New ToDo");
		
		listCreatingNewToDo.add(createEntity);
		toDoRepository.saveAll(listCreatingNewToDo);
	}
	
	public String todoChange(String title, String id, String date, String time, String priority, String text) {
		Integer deleteID = Integer.parseInt(id);
		String output = "";
		
		toDoRepository.deleteById(deleteID);
		
		if (toDoRepository.existsById(deleteID) != true) {
			
			ToDoEntity createNewToDo = new ToDoEntity();
			List<ToDoEntity> listNewToDo = new ArrayList<>();
			
			createNewToDo.setTitleOfToDo(title);
			createNewToDo.setDateOfToDo(date);
			createNewToDo.setTimeOfToDo(time);
			createNewToDo.setPriorityOfToDo(priority);
			createNewToDo.setTextForToDo(text);
			createNewToDo.setStatus("ToDo Changed");
			
			listNewToDo.add(createNewToDo);
			
			toDoRepository.saveAll(listNewToDo);
			
			System.out.println("Change ToDo successfully!");
			
			output += "<script>alert('Change of ToDo Information are successfully!');window.close();</script>";
			
			
		}else {
			System.out.println("Error by deleting the ToDo");
			output += "<script>alert('Change of ToDo Information are <b>not</b> successfully!');window.close();</script>";
		}
		
		return output;
	}
	
	public String todoDelete(String id) {
		int deleteID = Integer.parseInt(id);
		toDoRepository.deleteById(deleteID);
		return "<script>alert('ToDo are deleted from database!');window.close();</script>";
	}
	
	public String todoDone(String id, String title, String dateOfToDo, String timeOfToDo, String priority, String textOfToDo) {
		
		Integer deleteID = Integer.parseInt(id);
		String output = "";
		
		toDoRepository.deleteById(deleteID);
		
		if (toDoRepository.existsById(deleteID) != true) {	
			ToDoEntity createNewToDo = new ToDoEntity();
			List<ToDoEntity> listNewToDo = new ArrayList<>();
			
			createNewToDo.setTitleOfToDo(title);
			createNewToDo.setDateOfToDo(dateOfToDo);
			createNewToDo.setTimeOfToDo(timeOfToDo);
			createNewToDo.setPriorityOfToDo(priority);
			createNewToDo.setTextForToDo(textOfToDo);
			createNewToDo.setStatus("ToDo Done");
			
			listNewToDo.add(createNewToDo);
			
			toDoRepository.saveAll(listNewToDo);
			
			output += "<script>alert('ToDo Done!');window.close();</script>";
		}else {
			System.out.println("Error by done the ToDo");
			output += "<script>alert('ToDo <b>can not</b> change the status to Done');window.close();</script>";
		}
		
		return output;
		
	}
}
