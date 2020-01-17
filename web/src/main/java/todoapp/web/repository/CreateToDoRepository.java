package todoapp.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import todoapp.web.entity.CreateToDoEntity;

@Repository
public interface CreateToDoRepository extends JpaRepository<CreateToDoEntity, Integer> {

}
