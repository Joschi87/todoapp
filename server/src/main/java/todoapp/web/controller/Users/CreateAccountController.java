package todoapp.web.controller.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import todoapp.web.service.UserService;

@RestController
public class CreateAccountController {
	
	@Autowired
	UserService userService;

	@PostMapping(path="/register")
	public ResponseEntity<String> createAccount(@RequestParam String username, @RequestParam String password, @RequestParam String key) {
		return userService.registerNewUser(username, password, key);
	}
	
}
