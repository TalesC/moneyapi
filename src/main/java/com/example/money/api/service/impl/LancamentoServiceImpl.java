package com.example.money.api.service.impl;

import java.util.List;
import java.util.Optional;

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
		if(lancamentos.isEmpty() || lancamentos == null) throw new EmptyResultDataAccessException(1);
		return lancamentos;
	}

	@Override
	public Lancamento findById(Long id) {
		Optional<Lancamento> lancamento = repository.findById(id);
		if(lancamento.isEmpty()) throw new EmptyResultDataAccessException(1);
		return lancamento.get();
	}

}
