package com.vjssolution.barbershop.dtos;

import java.time.LocalDate;

import com.vjssolution.barbershop.models.ClienteModel;

public class ClienteDTO {

	private String nome;
	private String logradouro;
	private String endereco;
	private Integer numero;
	private String cidade;
	private String bairro;
	private String estado;
	private String email;
	private String telefone;
	private LocalDate datanascimento;

	public ClienteDTO() {
	}

	public ClienteDTO(String nome, String logradouro, String endereco, Integer numero, String cidade,
			String bairro, String estado, String email, String telefone, LocalDate datanascimento) {
		this.nome = nome;
		this.logradouro = logradouro;
		this.endereco = endereco;
		this.numero = numero;
		this.cidade = cidade;
		this.bairro = bairro;
		this.estado = estado;
		this.email = email;
		this.telefone = telefone;
		this.datanascimento = datanascimento;
	}

	public ClienteDTO(ClienteModel clienteModel) {
		nome = clienteModel.getNome();
		logradouro = clienteModel.getLogradouro();
		endereco = clienteModel.getEndereco();
		numero = clienteModel.getNumero();
		cidade = clienteModel.getCidade();
		bairro = clienteModel.getBairro();
		estado = clienteModel.getEstado();
		email = clienteModel.getEmail();
		telefone = clienteModel.getTelefone();
		datanascimento = clienteModel.getDatanascimento();
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(LocalDate datanascimento) {
		this.datanascimento = datanascimento;
	}

}
