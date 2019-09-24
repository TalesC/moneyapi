	package com.example.money.api.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
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

import com.example.money.api.event.ControllerCreatedEvent;
import com.example.money.api.model.Categoria;
import com.example.money.api.repository.CategoriaRepository;

@RestController
@CrossOrigin
@RequestScope
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Categoria> findAll() {
		return repository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Categoria> create(@Valid @RequestBody Categoria categoria, HttpServletResponse response) {
		Categoria criada = repository.save(categoria);
		publisher.publishEvent(new ControllerCreatedEvent(this, response, criada.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(criada);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> findByI(@PathVariable Long id) {
		Optional<Categoria> categoria = repository.findById(id); 
		return categoria.isPresent()? ResponseEntity.ok(categoria.get()) : ResponseEntity.notFound().build();
	}
	
}
