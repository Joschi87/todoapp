package todoapp.web.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "listofalldates")
public class ListOfAllToDoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Integer id;
	@NotNull
	private String toDoDate;

	//Getter and Setter method for creating and insert into the list of all ToDos
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getToDoDate() {
		return toDoDate;
	}

	public void setToDoDate(String toDoDate) {
		this.toDoDate = toDoDate;
	}
	
	
}
