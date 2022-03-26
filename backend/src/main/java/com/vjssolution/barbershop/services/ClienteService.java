package com.vjssolution.barbershop.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vjssolution.barbershop.models.ClienteModel;
import com.vjssolution.barbershop.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Transactional
	public ClienteModel salvarCliente(ClienteModel clienteModel) {
		return clienteRepository.save(clienteModel);
	}
	
	public Page<ClienteModel> findAll(Pageable pageable) {
		return clienteRepository.findAll(pageable);
	}
	
	public Optional<ClienteModel> findById(Long id) {
		return clienteRepository.findById(id);
	}
	
	@Transactional
	public void deleleCliente(ClienteModel clienteModel) {
		clienteRepository.delete(clienteModel);
	}
}
