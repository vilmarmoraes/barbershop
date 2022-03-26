package com.vjssolution.barbershop.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vjssolution.barbershop.dtos.ClienteDTO;
import com.vjssolution.barbershop.models.ClienteModel;
import com.vjssolution.barbershop.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@GetMapping
	public ResponseEntity<Page<ClienteModel>> findAll(
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll(pageable));
	}

	@PostMapping
	public ResponseEntity<Object> salvarCliente(@RequestBody @Valid ClienteDTO clienteDTO) {
		var clienteModel = new ClienteModel();
		BeanUtils.copyProperties(clienteDTO, clienteModel);
		clienteModel.setDatacadastro(LocalDateTime.now(ZoneId.of("UTC")));
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.salvarCliente(clienteModel));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
		Optional<ClienteModel> clienteModel = clienteService.findById(id);
		if (!clienteModel.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado ou não cadastrado.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(clienteModel.get());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCliente(@PathVariable(value = "id") Long id,
			@RequestBody @Valid ClienteDTO clienteDTO) {
		Optional<ClienteModel> clienteModelOptional = clienteService.findById(id);
		if (!clienteModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado ou não cadastrado.");
		}
		var clienteModel = new ClienteModel();
		BeanUtils.copyProperties(clienteDTO, clienteModel);
		clienteModel.setId(clienteModelOptional.get().getId());
		clienteModel.setDatacadastro(clienteModelOptional.get().getDatacadastro());
		return ResponseEntity.status(HttpStatus.OK).body(clienteService.salvarCliente(clienteModel));

	}

	// @RequestMapping(value = "/pessoa/{id}", method = RequestMethod.DELETE)
	@DeleteMapping("/id")
	public ResponseEntity<Object> deletarCliente(@PathVariable(value = "id") Long id) {
		Optional<ClienteModel> clienteModelOptional = clienteService.findById(id);
		if (!clienteModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado ou não cadastrado.");
		} else {
			clienteService.deleleCliente(clienteModelOptional.get());
			return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso!");
		}

	}
}
