package com.example.money.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.money.api.model.Lancamento;
import com.example.money.api.service.LancamentoService;

@RestController
@CrossOrigin
@RequestScope
@RequestMapping("/lancamento")
public class LancamentoController {

	@Autowired
	private LancamentoService service;
	
	@GetMapping
	public List<Lancamento> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Lancamento> findById(@PathVariable Long id){
		Lancamento lancamento = service.findById(id);
		return ResponseEntity.ok(lancamento);
	}
	
}
