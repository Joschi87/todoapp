package todoapp.web.entity;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Todos")
public class ToDoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Integer id;
	@NotNull
	private String titleOfToDo;
	@NotNull
	private String dateOfToDo;
	@NotNull
	private String timeOfToDo;
	@NotNull
	private String priorityOfToDo;
	@NotNull
	private String textForToDo;
	@NotNull
	private String status;
	private ArrayList<String> release;
	//private String todoForUser;
	private String author;
	
	//Getter and Setter method for creating a ToDo into a new Table
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitleOfToDo() {
		return titleOfToDo;
	}
	public void setTitleOfToDo(String titleOfToDo) {
		this.titleOfToDo = titleOfToDo;
	}
	public String getDateOfToDo() {
		return dateOfToDo;
	}
	public void setDateOfToDo(String dateOfToDo) {
		this.dateOfToDo = dateOfToDo;
	}
	public String getTimeOfToDo() {
		return timeOfToDo;
	}
	public void setTimeOfToDo(String timeOfToDo) {
		this.timeOfToDo = timeOfToDo;
	}
	public String getPriorityOfToDo() {
		return priorityOfToDo;
	}
	public void setPriorityOfToDo(String priorityOfToDo) {
		this.priorityOfToDo = priorityOfToDo;
	}
	public String getTextForToDo() {
		return textForToDo;
	}
	public void setTextForToDo(String textForToDo) {
		this.textForToDo = textForToDo;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	public void setRelease(ArrayList<String> release) {
		this.release = release;
	}
	public ArrayList<String> getRelease() {
		return release;
	}
	/*public void setToDoForUser(String user) {
		this.todoForUser=user;
	}
	public String getToDoForUser() {
		return todoForUser;
	}*/
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAuthor() {
		return author;
	}
	
	@Override
	public String toString() {
		return String.format("%s | %s | %s | %s<div class='float-right'><a href='/toDoDone?id=%s&title=%s&dateOfToDo=%s&timeOfToDo=%s&priority=%s&textOfToDo=%s' target='iFrameForRestController'><button type='button' class='btn btn-success'>Done</button></a>&nbsp;&nbsp;&nbsp;<a href='/workingAtToDo?id=%s&title=%s&dateOfToDo=%s&timeOfToDo=%s&priority=%s&textOfToDo=%s'><button type='button' class='btn btn-warning'>Open/Edit</button></a>&nbsp;&nbsp;&nbsp;<a href='/deleteToDo?id=%s&title=%s' target='_blank'><button type='button' class='btn btn-danger'>Delete</button></a></div>", titleOfToDo, dateOfToDo, timeOfToDo, status, id, titleOfToDo, dateOfToDo, timeOfToDo, priorityOfToDo, textForToDo, id, titleOfToDo, dateOfToDo, timeOfToDo, priorityOfToDo, textForToDo, id, titleOfToDo);
	}
}
