package todoapp.web.controller.Users;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import todoapp.web.service.UserService;

@RestController
public class LoginController {
	
	@Autowired
	UserService userService;

	@PostMapping(path="/login")
	public String loginUserController(@RequestParam String username, @RequestParam String password, HttpServletResponse response) {
		return userService.loginUser(username, password, response);
	}
	
}
