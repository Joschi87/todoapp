package todoapp.web.controller.Users;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import todoapp.web.lib.exception.LoginException;
import todoapp.web.service.UserService;

@RestController
public class LoginController {
	
	@Autowired
	UserService userService;

	@GetMapping(path="/login")
	public String loginUserController(@RequestParam String username, @RequestParam String password, @RequestParam HttpServletResponse response) throws LoginException {
		System.out.println("Test");
		return userService.loginUser(username, password, response);
	}
	
}
