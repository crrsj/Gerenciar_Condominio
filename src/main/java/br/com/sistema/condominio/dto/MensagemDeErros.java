package br.com.sistema.condominio.dto;

import org.springframework.http.HttpStatus;

public record MensagemDeErros(HttpStatus status,String mensagem) {

}
