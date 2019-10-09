package com.example.money.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.money.api.event.ControllerCreatedEvent;
import com.example.money.api.model.Pessoa;
import com.example.money.api.repository.PessoaRepository;
import com.example.money.api.service.PessoasService;

@RestController
@CrossOrigin
@RequestScope
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaRepository repository;
	
	@Autowired
	private PessoasService service;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Pessoa> findAllPessoa() {
		return repository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> createPessoa(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response) {
		Pessoa resp = repository.save(pessoa);
		
		publisher.publishEvent(new ControllerCreatedEvent(this, response, resp.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(resp);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> findPessoabyId(@PathVariable Long id) {
		Pessoa resp = service.findById(id);
		return ResponseEntity.ok(resp);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePessoaById(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> updatePessoa(@PathVariable Long id, @Valid @RequestBody  Pessoa pessoa) {
		Pessoa pessoaSalva = service.updatePessoa(id, pessoa);
		return ResponseEntity.ok(pessoaSalva);		
	}
	
	@PutMapping("/{id}/ativo")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updatePessoaAtivo(@PathVariable Long id, @RequestBody Boolean ativo) {
		service.updatePessoaAtivo(id, ativo);
	}
	
}
