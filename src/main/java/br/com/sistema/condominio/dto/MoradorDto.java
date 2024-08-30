package br.com.sistema.condominio.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.com.sistema.condominio.dominio.Lazer;
import br.com.sistema.condominio.dominio.Morador;
import br.com.sistema.condominio.dominio.Ocorrencia;
import br.com.sistema.condominio.enums.Bloco;
import br.com.sistema.condominio.enums.Garagem;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class MoradorDto {
	
	private String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	@NotBlank(message = "Não pode estar em branco")
	private String nome;
	@NotBlank(message = "Não pode estar em branco")
	private String cpf;
	@NotBlank(message = "Não pode estar em branco")
	private String fone;
	@Enumerated(EnumType.STRING)
	private Bloco bloco;
	private Integer apartamento;
	@Enumerated(EnumType.STRING)
	private Garagem garagem;
	

	private List<Ocorrencia> ocorrencia = new ArrayList<>();	
	
   	private List<Lazer>  lazer;
	
	
	public MoradorDto(Morador cadastro) {
		this.nome = cadastro.getNome();
		this.cpf = cadastro.getCpf();
		this.fone = cadastro.getFone();
		this.bloco = cadastro.getBloco();
		this.apartamento = cadastro.getApartamento();
		this.garagem = cadastro.getGaragem();
		this.ocorrencia = cadastro.getOcorrencia();
		this.lazer = cadastro.getLazer();
	}

}
