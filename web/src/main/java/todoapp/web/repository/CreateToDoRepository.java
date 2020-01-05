package todoapp.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import todoapp.web.entity.CreateToDoEntity;

public interface CreateToDoRepository extends JpaRepository<CreateToDoEntity, Integer> {

}
