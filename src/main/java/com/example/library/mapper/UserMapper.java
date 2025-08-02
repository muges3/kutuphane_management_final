package com.example.library.mapper;

import com.example.library.dto.UserDTO;
import com.example.library.entity.User;

public class UserMapper {
	
	public static UserDTO toDTO (User user) {
		
		UserDTO dto= new UserDTO();
		
		dto.setEmail(user.getEmail());
		dto.setName(user.getName());
		
		return dto;
	}

}
