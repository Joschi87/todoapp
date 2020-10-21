package todoapp.web.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todoapp.web.entity.UserEntity;
import todoapp.web.lib.exception.LoginException;
import todoapp.web.lib.ifs.UserRepository;
import todoapp.web.lib.utils.Cryption;
import todoapp.web.lib.utils.ToDoCookies;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public void registerNewUser(String username, String password) {
		UserEntity userEntity = new UserEntity();
		List<UserEntity> list = new ArrayList<>();
		
		userEntity.setUsername(Cryption.encrypt(username, password));
		userEntity.setPassword(Cryption.encrypt(password, password));
		userEntity.setRole(" ");
		
		list.add(userEntity);
		
		userRepository.saveAll(list);
		
	}
	
	public String loginUser(String username, String password, HttpServletResponse response) {
		String output = "";
		String usernameAsEncryptedString = Cryption.encrypt(username, password); 
		String passwordAsEncryptedString = Cryption.encrypt(password, password);
		
		if(userRepository.getUsername(usernameAsEncryptedString).toString().equals(userRepository.getPassword(passwordAsEncryptedString).toString())){
			ToDoCookies.setUsernameCookie(usernameAsEncryptedString, response);
			output = "<script>alert('Login successful');$('#login').modal('hide')</script>";
			System.out.println("Angemeldet!");
		}else {
			output = "<script>alert('Login unsuccessful')</script>";
			
		}
	
		return output;
	}
	
	public String logoutUser(HttpServletRequest request, HttpServletResponse response) {
		String output = "";
		if(!ToDoCookies.getUserCookie(request).isEmpty()) {
			ToDoCookies.deleteUserCookie(response);
			if(!ToDoCookies.findUserCookie(request)) {
				output = "<script>alert('Logout successful')</script>";
			}else {
				output = "<script>alert('Logout failed!!!')</script>";
			}
		}
		return output;
	}

}
