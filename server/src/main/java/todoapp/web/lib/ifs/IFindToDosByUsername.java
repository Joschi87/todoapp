package todoapp.web.lib.ifs;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFindToDosByUsername<T> {

	@Query("select p.titleOfToDo from #{#entityName} p where p.author =:username")
	public List<String> getAllTitleOfToDoByAuthor(@Param("username")String username);
	
	@Query("select p.timeOfToDo from #{#entityName} p where p.author =:username")
	public List<String> getAllTimeOfToDoByAuthor(@Param("username")String usernmae);
	
	@Query("select p.dateOfToDo from #{#entityName} p where p.author =:username")
	public List<String> getAllDateOfToDoByAuthor(@Param("username")String username);
	
	@Query("select p.priorityOfToD from #{#entityName} p where p.author =:username")
	public List<String> getAllPriorityOfToDoByAuthor(@Param("username")String username);
	
	@Query("select p.textOfToDo from #{#entityName} p where p.author =:username")
	public List<String> getTextOfToDoByAuthor(@Param("username")String username);
	
	@Query("select p.status from #{#entityName} p where p.author =:username")
	public List<String> getStatusOfToDosByUsername(@Param("username")String username);
	
}
