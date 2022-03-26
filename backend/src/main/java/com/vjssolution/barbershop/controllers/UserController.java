package com.vjssolution.barbershop.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vjssolution.barbershop.dtos.UserDTO;
import com.vjssolution.barbershop.models.UserModel;
import com.vjssolution.barbershop.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService userService;

//------------------------------------------------------------------------------------
	@PostMapping
	public ResponseEntity<Object> savaUser(@RequestBody @Valid UserDTO userDTO) {
		var userModel = new UserModel();
		BeanUtils.copyProperties(userDTO, userModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(userModel));
	}

//------------------------------------------------------------------------------------
	@GetMapping
	public Page<UserDTO> findAll(Pageable pageable) {
		return userService.findAll(pageable);
	}

//------------------------------------------------------------------------------------
	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> findById(@PathVariable Long id) {
		Optional<UserModel> userModel = userService.findById(id);
		if (!userModel.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(userModel.get());
	}

//-------------------------------------------------------------------------------------
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") Long id) {
		Optional<UserModel> userOptional = userService.findById(id);
		if (!userOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
		}
		userService.delete(userOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully.");
	}

//--------------------------------------------------------------------------------------	

}
