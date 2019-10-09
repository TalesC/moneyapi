package com.example.money.api.service;

import com.example.money.api.model.Pessoa;

public interface PessoasService {

	public Pessoa findById(Long id);
	public Pessoa updatePessoa(Long id, Pessoa pessoa);
	public void updatePessoaAtivo(Long id, Boolean ativo);
	
}
