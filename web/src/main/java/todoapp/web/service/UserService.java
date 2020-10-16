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
import todoapp.web.lib.utils.GenerateCookie;

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
	
	public String loginUser(String username, String password, HttpServletResponse response) throws LoginException{
		String output = "";
		String usernameAsEncryptedString = username;/*Cryption.encrypt(username, password); */
		String passwordAsEncryptedString = password;/*Cryption.encrypt(password, password);*/
		System.out.println(userRepository.getUsername(usernameAsEncryptedString));
		System.out.println(userRepository.getPassword(passwordAsEncryptedString));
		
		try {
			if(userRepository.getUsername(usernameAsEncryptedString).toString().equals(userRepository.getPassword(passwordAsEncryptedString).toString())){
				GenerateCookie.setUsernameCookie(usernameAsEncryptedString, response);
				output = "<script>alert('Login successful')</script>";
				System.out.println("Angemeldet!");
			}else {
				output = "<script>alert('Login unsuccessful')</script>";
				throw new LoginException("Login failed by Username: " + username);
			}
		}catch(LoginException e) {
			System.out.println(e.getMessage());
		}
		return output;
	}

}
