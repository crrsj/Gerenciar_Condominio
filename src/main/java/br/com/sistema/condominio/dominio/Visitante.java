package br.com.sistema.condominio.dominio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.sistema.condominio.dto.VisitanteDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "visitantes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Visitante {
    
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	private String nome;
	private String rg;
	private String fone;
	@ManyToOne
	@JoinColumn(name = "morad_id")
	@JsonIgnore
	private Morador morador;
	
	public Visitante(VisitanteDto visitante) {
		this.dataHora = visitante.getDataHora();
		this.nome = visitante.getNome();
		this.rg = visitante.getRg();
		this.fone = visitante.getFone();
	}
}

