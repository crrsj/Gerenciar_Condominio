package br.com.sistema.condominio.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.sistema.condominio.dominio.Morador;
import br.com.sistema.condominio.dominio.Ocorrencia;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OcorrenciaDto {

	private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
	private LocalDate data;
    @Column(length = 500)
    private String descricao;
    private Double multa;   
    private Morador morador;
    
    public OcorrenciaDto (Ocorrencia ocorrencia) {
    	this.id = ocorrencia.getId();
    	this.data = ocorrencia.getData();
    	this.descricao = ocorrencia.getDescricao();
    	this.multa = ocorrencia.getMulta();
    	this.morador = ocorrencia.getMorador();
    }
}
