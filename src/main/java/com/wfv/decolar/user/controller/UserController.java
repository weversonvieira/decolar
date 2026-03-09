package com.wfv.decolar.user.controller;

import com.wfv.decolar.user.dto.UserDTO;
import com.wfv.decolar.user.exception.UsernameNotFoundException;
import com.wfv.decolar.user.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/person/v1")
public class UserController {

	@Resource
	private UserService service;

	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE})
	public List<UserDTO> findAll() {
		return service.findAll();

	}

	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE})
	public UserDTO findById(@PathVariable("id") Long id) throws UsernameNotFoundException {
		Optional<UserDTO> person = service.findById(id);
		return person.get();

	}


	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public UserDTO create(@RequestBody UserDTO person) throws UsernameNotFoundException {

		return service.save(person);

	}

	@PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public UserDTO update(@RequestBody UserDTO person) throws UsernameNotFoundException {

		return service.update(person);

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) throws UsernameNotFoundException {
		service.deleteById(id);
		return ResponseEntity.noContent().build();

	}
}
