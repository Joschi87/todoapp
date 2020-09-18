package todoapp.web.controller.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import todoapp.web.service.UserService;

@RestController
public class CreateAccountController {
	
	@Autowired
	UserService userService;

	@PostMapping(path="/register")
	public String createAccount(@RequestParam String username, @RequestParam String password) {
		return userService.registerNewUser(username, password);
	}
	
}