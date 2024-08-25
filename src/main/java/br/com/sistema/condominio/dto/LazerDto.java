package br.com.sistema.condominio.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.sistema.condominio.dominio.Lazer;
import br.com.sistema.condominio.dominio.Morador;
import br.com.sistema.condominio.enums.Area;
import br.com.sistema.condominio.enums.Status;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LazerDto {
	
	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
	private LocalDate dataEvento;
	private LocalTime horaInicio;
	private LocalTime horaFim;  	
	private Area area;
	private Status status;
	@OneToOne
	private Morador morador;
	
	
	public LazerDto(Lazer alugar) {
		this.id = alugar.getId();
		this.dataEvento = alugar.getDataEvento();
		this.horaInicio = alugar.getHoraInicio();
		this.horaFim = alugar.getHoraFim();
		this.area = alugar.getArea();
		this.status = alugar.getStatus();
		this.morador = alugar.getMorador();
	}
}
