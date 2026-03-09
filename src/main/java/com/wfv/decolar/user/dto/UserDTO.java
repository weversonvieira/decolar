package com.wfv.decolar.user.dto;

import com.wfv.decolar.user.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class UserDTO {

	private Long id;
	private String name;
	private String email;
	private String password;

	public static UserDTO toDto(Optional<User> user) {
		UserDTO userDTO = new UserDTO();
		if(user.isPresent()) {
			userDTO.setId(user.get().getId());
			userDTO.setName(user.get().getName());
			userDTO.setEmail(user.get().getEmail());
			userDTO.setPassword(user.get().getPassword());
		}
		return userDTO;
	}

	public static User toEntity(UserDTO dto) {
		User user = new User();
		user.setId(dto.getId());
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		return user;
	}

	public static List<UserDTO>  userDTOList(List<User> users) {
		List<UserDTO> userDTOList = new ArrayList<>();
		for (User user : users) {
			UserDTO userDTO = UserDTO.toDto(Optional.of(user));
			userDTOList.add(userDTO);
		}
		return userDTOList;

	}

	public static List<User>  userList(List<UserDTO> usersDTO) {
		List<User> userList = new ArrayList<>();
		for (UserDTO dto : usersDTO) {
			User user = UserDTO.toEntity(dto);
			userList.add(user);
		}
		return userList;
	}


}
