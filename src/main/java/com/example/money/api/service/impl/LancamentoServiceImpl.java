package com.example.money.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.money.api.model.Lancamento;
import com.example.money.api.repository.LancamentoRepository;
import com.example.money.api.service.LancamentoService;

@Service
public class LancamentoServiceImpl implements LancamentoService {

	@Autowired
	private LancamentoRepository repository;
	
	@Override
	public List<Lancamento> findAll() {
		List<Lancamento> lancamentos = repository.findAll();
		if(lancamentos == null || lancamentos.isEmpty()) throw new EmptyResultDataAccessException(1);
		return lancamentos;
	}

	@Override
	public Lancamento findById(Long id) {
		return repository.findById(id).orElseThrow();
	}

	@Override
	public Lancamento create(Lancamento lancamento) {
		return repository.save(lancamento);		
	}

	

}
