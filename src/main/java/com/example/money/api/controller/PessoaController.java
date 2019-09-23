package com.example.money.api.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.money.api.model.Pessoa;
import com.example.money.api.repository.PessoaRepository;

@RestController
@CrossOrigin
@RequestScope
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaRepository repository;
	
	@GetMapping
	public List<Pessoa> findAllPessoa() {
		return repository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Pessoa> createPessoa(@Valid @RequestBody Pessoa pessoa) {
		Pessoa resp = repository.save(pessoa);
		
		URI uri =  ServletUriComponentsBuilder
				.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(resp.getId()).toUri();
		
		return ResponseEntity.created(uri).body(resp);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pessoa> findAllPessoa(@PathVariable Long id) {
		Optional<Pessoa> resp = repository.findById(id);
		return resp.isPresent() ? ResponseEntity.ok(resp.get()) : ResponseEntity.notFound().build();
	}
	
}
