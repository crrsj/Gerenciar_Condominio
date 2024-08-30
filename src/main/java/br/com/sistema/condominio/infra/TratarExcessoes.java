package br.com.sistema.condominio.infra;

import java.util.NoSuchElementException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



import br.com.sistema.condominio.dto.MensagemDeErros;
import br.com.sistema.condominio.dto.TratandoErros;


@ControllerAdvice
public class TratarExcessoes {
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<MensagemDeErros>idNaoEncontrado(){ 
		var erros = new MensagemDeErros(HttpStatus.NOT_FOUND, "ID não encontrado !");
		return new ResponseEntity<>(erros,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<MensagemDeErros>reservarMaisDeUmAaRea(){ 
		var erros = new MensagemDeErros(HttpStatus.CONFLICT, " Área já reservada nesta data ! ");
		return new ResponseEntity<>(erros,HttpStatus.CONFLICT);
		
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?>tratador400(MethodArgumentNotValidException ex){
		var erros = ex.getFieldErrors();
		return ResponseEntity.badRequest().body(erros.stream().map(TratandoErros::new).toList());		
	}
}
