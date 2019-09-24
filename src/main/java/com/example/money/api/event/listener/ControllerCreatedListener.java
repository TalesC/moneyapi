package com.example.money.api.event.listener;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.money.api.event.ControllerCreatedEvent;

@Component
public class ControllerCreatedListener implements ApplicationListener<ControllerCreatedEvent> {

	@Override
	public void onApplicationEvent(ControllerCreatedEvent event) {
		HttpServletResponse response = event.getResponse();
		Long codigo = event.getCodigo();
		
		URI uri =  ServletUriComponentsBuilder
				.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(codigo).toUri();
		
		response.setHeader("Location", uri.toASCIIString());
	}

}
