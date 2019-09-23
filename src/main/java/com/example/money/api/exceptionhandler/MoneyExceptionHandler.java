package com.example.money.api.exceptionhandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.naming.Binding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.money.api.model.Categoria;

@ControllerAdvice 
public class MoneyExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String menssagemUsuario = messageSource.getMessage("menssagem.invalida", null, LocaleContextHolder.getLocale());
		String menssagemDesenvolvedor = ex.getCause().toString();
		
		return handleExceptionInternal(ex, new Erro(menssagemUsuario, menssagemDesenvolvedor)
				, headers, status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<Erro> erros = buildErroList(ex.getBindingResult());
		return handleExceptionInternal(ex, 	erros, headers, status, request);
	}
	
	private List<Erro> buildErroList(BindingResult bindingResult){
		
		List<Erro> erros = new ArrayList<MoneyExceptionHandler.Erro>();
		bindingResult.getFieldErrors().forEach(err -> 
			erros.add(new Erro(
					messageSource.getMessage(err, LocaleContextHolder.getLocale()),
					err.toString())
					)
		);
		
		return erros;
	}
	
	
	public static class Erro {
		
		private String menssagemUsuario;
		private String menssagemDesenvolvedor;
		
		public Erro(String menssagemUsuario, String menssagemDesenvolvedor) {
			super();
			this.menssagemUsuario = menssagemUsuario;
			this.menssagemDesenvolvedor = menssagemDesenvolvedor;
		}

		public String getMenssagemUsuario() {
			return menssagemUsuario;
		}

		public String getMenssagemDesenvolvedor() {
			return menssagemDesenvolvedor;
		}

	}

	
}
