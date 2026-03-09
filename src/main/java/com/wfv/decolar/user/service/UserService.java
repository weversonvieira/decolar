package com.wfv.decolar.user.service;

import com.wfv.decolar.user.dto.UserDTO;
import com.wfv.decolar.user.entity.User;
import com.wfv.decolar.user.exception.RequiredObjectIsNullException;
import com.wfv.decolar.user.exception.ResourceNotFoundException;
import com.wfv.decolar.user.exception.UsernameNotFoundException;
import com.wfv.decolar.user.repository.UserRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

	private final UserRepository repository;

	public UserService(UserRepository userRepository){
		this.repository = userRepository;
	}

//	public User loadUserByUsername(String username) throws UsernameNotFoundException {
//		var user = repository.findByUserName(username);
//		if(user != null){
//			return  user;
//		}else {
//			throw new UsernameNotFoundException("Username " + username + " not found");
//		}
//	}

	public Optional<UserDTO> findById(Long id) throws UsernameNotFoundException {
		return Optional.of(UserDTO.toDto(repository.findById(id)));
	}

	public List<UserDTO> findAll() {

		return UserDTO.userDTOList(repository.findAll());
	}

	public UserDTO save(UserDTO userDTO) throws UsernameNotFoundException {
		User userParaAtualizar = UserDTO.toEntity(userDTO);
		return UserDTO.toDto(Optional.of(repository.save(userParaAtualizar)));
	}

	public void  deleteById(Long id) throws UsernameNotFoundException {
		repository.deleteById(id);
	}

	public UserDTO update(UserDTO user) throws UsernameNotFoundException {

		if (user == null) {
			throw new RequiredObjectIsNullException();
		}

		Optional<UserDTO> userAtual = Optional.ofNullable(findById(user.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID")));;
		User userParaAtualizar = UserDTO.toEntity(userAtual.get());
		if(userAtual.isPresent()){
			userParaAtualizar.setEmail(user.getEmail());
			userParaAtualizar.setName(user.getName());
			userParaAtualizar.setPassword(user.getPassword());
			return UserDTO.toDto(Optional.of(repository.save(userParaAtualizar)));
		}
		return UserDTO.toDto(Optional.of(repository.save(userParaAtualizar)));
	}
}
