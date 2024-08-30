package br.com.sistema.condominio.dominio;

import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.sistema.condominio.dto.OcorrenciaDto;
import jakarta.persistence.Column;
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
@Table(name = "ocorrencias")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ocorrencia {
    
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate data;  
	@Column(length = 500)
    private String descricao;
    private Double multa;
    @ManyToOne
    @JoinColumn(name = "morador_id")
    @JsonIgnore
    private Morador morador;
    
    public Ocorrencia(OcorrenciaDto ocorrencia) {
		this.id = ocorrencia.getId();
		this.data = ocorrencia.getData();
		this.descricao = ocorrencia.getDescricao();
		this.multa = ocorrencia.getMulta();
		this.morador = ocorrencia.getMorador();
	}

}
