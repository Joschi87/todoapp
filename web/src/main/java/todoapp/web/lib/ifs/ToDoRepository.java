package todoapp.web.lib.ifs;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import todoapp.web.entity.ToDoEntity;

@Repository
public interface ToDoRepository extends CrudRepository<ToDoEntity, Integer>{

	public List<ToDoEntity> findByDateOfToDo(String dateOfToDo);
	
}
