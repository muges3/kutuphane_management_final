package com.example.library.service;


import com.example.library.entity.User;
import com.example.library.exception.UserNotFoundException;
import com.example.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	
	
	public User addUser(User user) {
		
		User existingUser=userRepository.findByEmail(user.getEmail()).orElse(null);
		
		if(existingUser!=null) {
			throw new RuntimeException("Bu maile sahip bir kullanıcı zaten var");
			
		}
		
		return userRepository.save(user);
		
		
		
	}
	
	public List<User> getAllUsers(){
		
		return userRepository.findAll();
		
	}
	
	public User getUserById(Long id) {
		
		User user =userRepository.findById(id).orElse(null);
		
		if(user==null) {
			throw new UserNotFoundException("Kullanıcı bulunamadı");
		}
		else {
			return user;
		}
		
		
	}
	
	
	public User getUserByEmail(String email) {
		
		List<User> allUsers=userRepository.findAll();
		
		User foundUser=null;
		
		for(User u: allUsers) {
			
			if(u.getEmail().equals(email)) {
				foundUser=u;
				break;
			}
		}
		
		if(foundUser==null) {
			throw new RuntimeException("Bu mail ile kayıtlı bir kullanıcı bulunamadı");
			
			
		}
		else {
			return foundUser;
		}
		
		
	}
	
	
	public void deleteUser(Long id) {
		
		User user=userRepository.findById(id).orElse(null);
		
		if((user==null)) {
			
			throw new RuntimeException("Silinecek kullanıcı bulunamadı");
			
			
		}
		
		else {
			userRepository.delete(user);
		}
		


	}
	
	
	
}
