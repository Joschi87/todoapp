package todoapp.web.entity;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.json.JSONObject;

@Entity
@Table(name = "Todos")
public class ToDoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Integer id;
	@NotNull(message = "Forget a title")
	private String titleOfToDo;
	@NotNull(message = "Forget a date")
	private String dateOfToDo;
	@NotNull(message = "Forget a time")
	private String timeOfToDo;
	@NotNull(message = "Forget a priority")
	private String priorityOfToDo;
	@NotNull(message = "Forget a text")
	private String textForToDo;
	@NotNull
	private String status;
	
	public ToDoEntity(String titleOfToDo, String dateOfToDo, String timeOfToDo, String priorityOfToDo, String textForToDo, String status) {
		this.titleOfToDo = titleOfToDo;
		this.dateOfToDo = dateOfToDo;
		this.timeOfToDo = timeOfToDo;
		this.priorityOfToDo = priorityOfToDo;
		this.textForToDo = textForToDo;
		this.status = status;
	}
	//Getter  method for creating a ToDo into a new Table
	public Integer getId() {
		return id;
	}
	public String getTitleOfToDo() {
		return titleOfToDo;
	}
	public String getDateOfToDo() {
		return dateOfToDo;
	}
	public String getTimeOfToDo() {
		return timeOfToDo;
	}
	public String getPriorityOfToDo() {
		return priorityOfToDo;
	}
	public String getTextForToDo() {
		return textForToDo;
	}
	
	@Override
	public String toString() {
		return new JSONObject().put("ID", id).put("Title", titleOfToDo).put("Date", dateOfToDo).put("Time", timeOfToDo).put("Priority", priorityOfToDo).put("Text", textForToDo).put("Status", status).put("Author", author).toString();
	}
}
