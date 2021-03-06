package todoapp.web.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import todoapp.web.entity.ToDoEntity;
import todoapp.web.lib.ifs.ToDoRepository;
import todoapp.web.lib.utils.ToDoCookies;
import todoapp.web.lib.web.BasicHtmlStuff;

@Service
public class ToDoService {
	
	@Autowired
	ToDoRepository toDoRepository;
	
	@Autowired
	ListAllToDoFromSpecialDateService databaseJSONService;
	
	public ResponseEntity<String> createToDo(String titleOfToDo, String dateOfToDo, String timeOfToDo, String priorityOfToDo, String textForToDo, HttpServletRequest request) {
		//ToDoEntity createEntity = new ToDoEntity();
		List<ToDoEntity> listCreatingNewToDo = new ArrayList<>();
		String username = ToDoCookies.getUserCookie(request);

		if(username.isEmpty()){
			return new ResponseEntity<>("No User Cookie found", HttpStatus.CONFLICT);
		}

		ToDoEntity entity = new ToDoEntity(titleOfToDo, dateOfToDo, timeOfToDo, priorityOfToDo, textForToDo, "New ToDo")
		
		listCreatingNewToDo.add(entity);
		toDoRepository.saveAll(listCreatingNewToDo);

		return new ResponseEntity<>("ToDo Created!", HttpStatus.OK);
	}
	
	public ResponseEntity<String> todoChange(String title, String id, String date, String time, String priority, String text) {
		Integer deleteID = Integer.parseInt(id);
		
		toDoRepository.deleteById(deleteID);
		
		if (toDoRepository.existsById(deleteID) != true) {
			
			List<ToDoEntity> listNewToDo = new ArrayList<>();
			
			ToDoEntity entity = new ToDoEntity(title, date, time, priority, text, "done");

			listNewToDo.add(entity);
			
			toDoRepository.saveAll(listNewToDo);
			
			System.out.println("Change ToDo successfully!");
			
			//output += "<script>alert('Change of ToDo Information are successfully!');window.close();</script>";
			
			return new ResponseEntity<>("Change ToDo successfully!", HttpStatus.CREATED);
			
		}else {
			System.out.println("Error by deleting the ToDo");
			//output += "<script>alert('Change of ToDo Information are <b>not</b> successfully!');window.close();</script>";
			return new ResponseEntity<>("Error cant change ToDo", HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	public ResponseEntity<String> todoDelete(String id) {
		int deleteID = Integer.parseInt(id);
		toDoRepository.deleteById(deleteID);
		return new ResponseEntity<>("ToDo deleted!", HttpStatus.OK);
	}
	
	public ResponseEntity<String> todoDone(String id, String title, String dateOfToDo, String timeOfToDo, String priority, String textOfToDo) {
		Integer deleteID = Integer.parseInt(id);
		
		toDoRepository.deleteById(deleteID);
		
		if (toDoRepository.existsById(deleteID) != true) {	
			
			List<ToDoEntity> listNewToDo = new ArrayList<>();
			
			ToDoEntity entity = new ToDoEntity(title, dateOfToDo, timeOfToDo, priority, textOfToDo, "ToDo Done");

			listNewToDo.add(entity);
			
			toDoRepository.saveAll(listNewToDo);

			return new ResponseEntity<>("ToDo Done", HttpStatus.OK);
			
			//output += "<script>alert('ToDo Done!');window.close();</script>";
		}else {
			System.out.println("Error by done the ToDo");
			//output += "<script>alert('ToDo <b>can not</b> change the status to Done');window.close();</script>";
			return new ResponseEntity<>("Error todo cant set to done", HttpStatus.CONFLICT);
		}
	}
	
	public String representDatabaseTranslatedFromJSON() {
		JSONArray jsonArray = new JSONArray(databaseJSONService.getAllToDoForASpecialDateAsJson());
		String output = BasicHtmlStuff.htmlHead + BasicHtmlStuff.navBarForIFrame + BasicHtmlStuff.listGroupStart + "\n";
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject obj = new JSONObject(jsonArray.get(i).toString());
			output += "<li class='list-group-item'>" +obj.getString("Title") + " | " + obj.getString("Date") + " | " + obj.getString("Time") + " | " + obj.getString("Status") + "<div class='float-right'><a href='/toDoDone?id="+ obj.get("ID") + "&title=" + obj.getString("Title") + "&dateOfToDo=" + obj.getString("Date") + "&timeOfToDo=" + obj.getString("Time") + "&priority=" + obj.getString("Priority") + "&textOfToDo=" + obj.getString("Text") + "' target='iFrameForRestController'><button type='button' class='btn btn-success'>Done</button></a>"
					+ "&nbsp;&nbsp;&nbsp;<a href='/workingAtToDo?id=" + obj.get("ID") + "&title=" + obj.getString("Title") + "&dateOfToDo=" + obj.getString("Date") +"&timeOfToDo=" + obj.getString("Time") +"&priority=" + obj.getString("Priority") + "&textOfToDo="+ obj.getString("Text") + "'><button type='button' class='btn btn-warning'>Open/Edit</button></a>"
					+ "&nbsp;&nbsp;&nbsp;<a href='/deleteToDo?id="+ obj.get("ID") +"&title="+ obj.getString("Title") + "' target='_blank'><button type='button' class='btn btn-danger'>Delete</button></a></div></li>\n";
		}
		output += "</ul></script></html>";
		return output;
	}
}
