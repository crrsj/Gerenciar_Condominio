package br.com.sistema.condominio.dominio;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.com.sistema.condominio.dto.MoradorDto;
import br.com.sistema.condominio.enums.Bloco;
import br.com.sistema.condominio.enums.Garagem;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="moradores")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Morador {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	private String nome;
	private String cpf;
	private String fone;
	private Bloco bloco;
	private Integer apartamento;
	private Garagem garagem;	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Ocorrencia> ocorrencia = new ArrayList<>();	
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "morador_id", referencedColumnName = "id")
	private Lazer lazer;
	
    public Morador(MoradorDto morador) {
    	this.dataHora = morador.getDataHora();
		this.nome = morador.getNome();
		this.cpf = morador.getCpf();
		this.fone = morador.getFone();
		this.bloco = morador.getBloco();
		this.apartamento = morador.getApartamento();
		this.garagem = morador.getGaragem();
    }	
}
