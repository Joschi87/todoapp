package todoapp.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todoapp.web.entity.UserEntity;
import todoapp.web.lib.ifs.UserRepository;
import todoapp.web.lib.utils.Cryption;

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

}
