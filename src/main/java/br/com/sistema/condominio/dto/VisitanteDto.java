package br.com.sistema.condominio.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.sistema.condominio.dominio.Morador;
import br.com.sistema.condominio.dominio.Visitante;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitanteDto {	   
		
	
		private Long id;
		private String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
		@NotBlank(message = "Não pode estar em branco")
		private String nome;
		@NotBlank(message = "Não pode estar em branco")
		private String rg;
		@NotBlank(message = "Não pode estar em branco")
		private String fone;		
		private Morador morador;
		
		public VisitanteDto(Visitante cadastrar) {
			this.id = cadastrar.getId();
			this.dataHora = cadastrar.getDataHora();
			this.nome = cadastrar.getNome();
			this.rg = cadastrar.getRg();
			this.fone = cadastrar.getFone();
			this.morador = cadastrar.getMorador();
		}

}
