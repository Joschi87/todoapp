package todoapp.web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import todoapp.web.entity.ListOfAllToDoEntity;

@Repository
public interface ListOfAllToDoRepository extends CrudRepository<ListOfAllToDoEntity, Integer> {

}
