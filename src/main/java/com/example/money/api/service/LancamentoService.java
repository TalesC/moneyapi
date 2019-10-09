package com.example.money.api.service;

import java.util.List;

import com.example.money.api.model.Lancamento;

public interface LancamentoService {
	
	public List<Lancamento> findAll();
	public Lancamento findById(Long id);
	
}
