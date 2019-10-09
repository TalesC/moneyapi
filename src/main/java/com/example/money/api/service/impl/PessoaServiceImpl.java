package com.example.money.api.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.money.api.model.Pessoa;
import com.example.money.api.repository.PessoaRepository;
import com.example.money.api.service.PessoasService;

@Service
public class PessoaServiceImpl  implements PessoasService{

	@Autowired
	private PessoaRepository repository;
	
	@Override
	public Pessoa findById(Long id) {
		Optional<Pessoa> existente = repository.findById(id);
		if(existente.isEmpty()) throw new EmptyResultDataAccessException(1);
		else return existente.get();
	}
	
	@Override
	public Pessoa updatePessoa(Long id, Pessoa pessoa) {
		Pessoa pessoaSalva = this.findById(id);
		BeanUtils.copyProperties(pessoa, pessoaSalva, "id");
		return repository.save(pessoaSalva);
	}

	@Override
	public void updatePessoaAtivo(Long id, Boolean ativo) {
		Pessoa pessoaSalva = this.findById(id);
		pessoaSalva.setAtivo(ativo);
		repository.save(pessoaSalva);
	}
	
	
}
