package todoapp.web.lib.ifs;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import todoapp.web.entity.CreateToDoEntity;

@Repository
public interface CreateToDoRepository extends CrudRepository<CreateToDoEntity, Integer> {

	public List<CreateToDoEntity> findByDateOfToDo(String dateOfToDo);
	
}
