package todoapp.web.controller.Users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import todoapp.web.service.UserService;

@RestController
public class LogoutController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(path="/logout")
	public String logoutUserController(HttpServletRequest request, HttpServletResponse response) {
		return userService.logoutUser(request, response);
	}

}
