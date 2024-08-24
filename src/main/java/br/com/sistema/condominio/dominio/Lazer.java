package br.com.sistema.condominio.dominio;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.sistema.condominio.enums.Area;
import br.com.sistema.condominio.enums.Status;
import jakarta.persistence.Entity;
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
	private LocalDate horaInicio;
	private LocalDate horaFim;  	
	private Area area;
	private Status status;
	@OneToOne(mappedBy = "lazer")
	private Morador morador;
	
}
