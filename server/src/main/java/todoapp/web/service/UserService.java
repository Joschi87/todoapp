package todoapp.web.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todoapp.web.entity.UserEntity;
import todoapp.web.lib.ifs.UserRepository;
import todoapp.web.lib.utils.Cryption;
import todoapp.web.lib.utils.ToDoCookies;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public void registerNewUser(String username, String password, String key) {
		UserEntity userEntity = new UserEntity();
		List<UserEntity> list = new ArrayList<>();
		
		userEntity.setUsername(Cryption.encrypt(username, key));
		userEntity.setPassword(Cryption.encrypt(password, key));
		
		list.add(userEntity);
		userRepository.saveAll(list);
	}
	
	public String loginUser(String username, String password, String key, HttpServletResponse response){
		String output = "";
		String usernameAsEncryptedString = Cryption.encrypt(username, key); 
		String passwordAsEncryptedString = Cryption.encrypt(password, key);
		
		if(userRepository.getUsername(usernameAsEncryptedString).toString().equals(userRepository.getPassword(passwordAsEncryptedString).toString())){
			ToDoCookies.setUsernameCookie(usernameAsEncryptedString, response);
			ToDoCookies.setKey(key, response);
			output = "<script>alert('Login successful')</script>";
		}else {
			output = "<script>alert('Login unsuccessful')</script>";
		}
		return output;
	}
	
	public String logoutUser(HttpServletRequest request, HttpServletResponse response) {
		String output = "";
		ToDoCookies.deleteUserCookie(response);
		ToDoCookies.deleteKeyCookie(response);
		if(!ToDoCookies.findCookie(request, "ToDoAppUser") && !ToDoCookies.findCookie(request, "key")) {
			
			output = "<script>alert('Logout successful')</script>";
		}else {
			output = "<script>alert('Logout failed!!!')</script>";
		}
		return output;
	}
}
