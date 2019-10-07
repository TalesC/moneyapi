package com.example.money.api.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.money.api.model.Pessoa;
import com.example.money.api.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;
	
	public Pessoa findById(Long id) {
		Optional<Pessoa> existente = repository.findById(id);
		if(existente.isEmpty()) throw new EmptyResultDataAccessException(1);
		else return existente.get();
	}
	
	public Pessoa updatePessoa(Long id, Pessoa pessoa) {
		Pessoa pessoaSalva = this.findById(id);
		BeanUtils.copyProperties(pessoa, pessoaSalva, "id");
		return repository.save(pessoaSalva);
	}

	public void updatePessoaAtivo(Long id, Boolean ativo) {
		Pessoa pessoaSalva = this.findById(id);
		pessoaSalva.setAtivo(ativo);
		repository.save(pessoaSalva);
	}
	
	
}
