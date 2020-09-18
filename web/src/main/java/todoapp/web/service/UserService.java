package todoapp.web.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todoapp.web.entity.UserEntity;
import todoapp.web.lib.ifs.UserRepository;
import todoapp.web.lib.utils.Cryption;
import todoapp.web.lib.utils.GenerateCookie;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public String registerNewUser(String username, String password) {
		UserEntity userEntity = new UserEntity();
		List<UserEntity> list = new ArrayList<>();
		String output;
		
		userEntity.setUsername(Cryption.encrypt(username, password));
		userEntity.setPassword(Cryption.encrypt(password, password));
		userEntity.setRole("");
		
		list.add(userEntity);
		
		userRepository.saveAll(list);
		
		if(userRepository.getID(username).toString() != "" ) {
			output = "Account created!";
		}else{
			output = "Registration faild! Please try it again";
		}
		
		return output;
	}
	
	public String loginUser(String username, String password, HttpServletResponse response) {
		String output = "";
		String usernameAsEncryptedString = Cryption.encrypt(username, password); 
		String passwordAsEncryptedString = Cryption.encrypt(password, password);
		System.out.println(userRepository.getUsername(usernameAsEncryptedString));
		System.out.println(userRepository.getPassword(passwordAsEncryptedString));
		
		if(userRepository.getUsername(usernameAsEncryptedString).toString().equals(userRepository.getPassword(passwordAsEncryptedString).toString())){
			GenerateCookie.setUsernameCookie(username, response);
			output = "<script>alert('Login successful')</script>";
		}else {
			output = "<script>alert('Login unsuccessful')</script>";
		}
		return output;
	}

}
