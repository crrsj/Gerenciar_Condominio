package br.com.sistema.condominio.dominio;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.sistema.condominio.dto.LazerDto;
import br.com.sistema.condominio.enums.Area;
import br.com.sistema.condominio.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lazer {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
	private LocalDate dataEvento;
	private LocalTime horaInicio;
	private LocalTime horaFim;  
	@Enumerated(EnumType.STRING)
	private Area area;
	@Enumerated(EnumType.STRING)
	private Status status;
	@OneToOne
	@JsonIgnore
	private Morador morador;
	

	public Lazer(LazerDto lazerDto) {
		this.id = lazerDto.getId();
		this.dataEvento = lazerDto.getDataEvento();
		this.horaInicio = lazerDto.getHoraInicio();
		this.horaFim = lazerDto.getHoraFim();
		this.area = lazerDto.getArea();
		this.status = lazerDto.getStatus();
		this.morador = lazerDto.getMorador();
	}
}
