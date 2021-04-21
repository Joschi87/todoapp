package todoapp.web.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import todoapp.web.entity.UserEntity;
import todoapp.web.lib.ifs.UserRepository;
import todoapp.web.lib.utils.Cryption;
import todoapp.web.lib.utils.ToDoCookies;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public ResponseEntity<String> registerNewUser(String username, String password, String key) {

		if(username.isEmpty() || password.isEmpty() || key.isEmpty()){
			return new ResponseEntity<>("One or many parameters are empty", HttpStatus.BAD_REQUEST);
		}

		UserEntity userEntity = new UserEntity();
		List<UserEntity> list = new ArrayList<>();
		
		userEntity.setUsername(Cryption.encrypt(username, key));
		userEntity.setPassword(Cryption.encrypt(password, key));
		
		list.add(userEntity);
		userRepository.saveAll(list);

		return new ResponseEntity<>("Account created", HttpStatus.CREATED);
	}
	
	public ResponseEntity<String> loginUser(String username, String password, String key, HttpServletResponse response){
		String usernameAsEncryptedString = Cryption.encrypt(username, key); 
		String passwordAsEncryptedString = Cryption.encrypt(password, key);
		
		if(userRepository.getUsername(usernameAsEncryptedString).toString().equals(userRepository.getPassword(passwordAsEncryptedString).toString())){
			ToDoCookies.setUsernameCookie(usernameAsEncryptedString, response);
			ToDoCookies.setKey(key, response);
			return new ResponseEntity<>("Login successful", HttpStatus.ACCEPTED);
			//output = "<script>alert('Login successful')</script>";
		}else {
			return new ResponseEntity<>("LOgin unsuccessful", HttpStatus.BAD_REQUEST);
			//output = "<script>alert('Login unsuccessful')</script>";
		}
	}
	
	public ResponseEntity<String> logoutUser(HttpServletRequest request, HttpServletResponse response) {
		ToDoCookies.deleteUserCookie(response);
		ToDoCookies.deleteKeyCookie(response);
		if(!ToDoCookies.findCookie(request, "ToDoAppUser") && !ToDoCookies.findCookie(request, "key")) {
			return new ResponseEntity<>("Logout successful", HttpStatus.OK);
			//output = "<script>alert('Logout successful')</script>";
		}else {
			return new ResponseEntity<>("Logout failed!", HttpStatus.BAD_REQUEST);
			//output = "<script>alert('Logout failed!!!')</script>";
		}
	}
}
