package com.vjssolution.barbershop.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vjssolution.barbershop.dtos.UserDTO;
import com.vjssolution.barbershop.models.UserModel;
import com.vjssolution.barbershop.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public UserModel saveUser(UserModel userModel) {
		return userRepository.save(userModel);
	}
	
	@Transactional(readOnly = true)
	public Page<UserDTO> findAll(Pageable pageable) {
		Page<UserModel> result = userRepository.findAll(pageable);
		Page<UserDTO> page = result.map(x -> new UserDTO(x));
		return page;
	}

	/*
	 * @Transactional(readOnly = true) public UserDTO findById1(Long id) { UserModel
	 * result = userRepository.findById(id).get(); UserDTO dto = new
	 * UserDTO(result); return dto; }
	 */
	
	
	@Transactional(readOnly = true)
	public Optional<UserModel> findById(Long id) {
		return userRepository.findById(id);
	}

	
	@Transactional
	public void delete(UserModel userModel) {
		userRepository.delete(userModel);
	}

}
