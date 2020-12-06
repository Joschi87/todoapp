package todoapp.web.lib.ifs;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFindPassword<T> {

	@Query("select p.id from #{#entityName} p where password =:password")
	public List<String> getPassword(@Param("password")String password);
	
}
