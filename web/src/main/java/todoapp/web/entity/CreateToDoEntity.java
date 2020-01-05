package todoapp.web.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class CreateToDoEntity {

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
}
