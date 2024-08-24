package br.com.sistema.condominio.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.com.sistema.condominio.dominio.Lazer;
import br.com.sistema.condominio.dominio.Ocorrencia;
import br.com.sistema.condominio.enums.Bloco;
import br.com.sistema.condominio.enums.Garagem;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class MoradorDto {
		
	private String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	private String nome;
	private String cpf;
	private String fone;
	@Enumerated(EnumType.STRING)
	private Bloco bloco;
	private Integer apartamento;
	private Garagem garagem;
	

	private List<Ocorrencia> ocorrencia = new ArrayList<>();	
	
   	private Lazer lazer;
	
	
}
