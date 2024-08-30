package br.com.sistema.condominio.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.sistema.condominio.dominio.Lazer;
import br.com.sistema.condominio.dominio.Morador;
import br.com.sistema.condominio.dominio.Ocorrencia;
import br.com.sistema.condominio.enums.Bloco;
import br.com.sistema.condominio.enums.Garagem;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor 
public class MoradoresDto {
	private Long id;	
	private String dataHora;
	private String nome;
	private String fone;
	private Bloco bloco;
	private Integer apartamento;
	private Garagem garagem;	
	private List<Ocorrencia> ocorrencia = new ArrayList<>();	     
	private List<Lazer> lazer = new ArrayList<>();
	
	public MoradoresDto(Morador morador) {
		this.id = morador.getId();
		this.dataHora = morador.getDataHora();
		this.nome = morador.getNome();
		this.fone = morador.getFone();
		this.bloco = morador.getBloco();
		this.apartamento = morador.getApartamento();
		this.garagem = morador.getGaragem();
		this.ocorrencia = morador.getOcorrencia();
		this.lazer = morador.getLazer();
	}
}
