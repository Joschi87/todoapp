package todoapp.web.lib.ifs;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFindUsername<T> {
		@Query("select p.id from #{#entityName} p where p.username =:username")
		public List<String> getUsername(@Param("username")String username);
}
