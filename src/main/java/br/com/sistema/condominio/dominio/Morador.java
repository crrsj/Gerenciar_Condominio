package br.com.sistema.condominio.dominio;




import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.sistema.condominio.dto.MoradorDto;
import br.com.sistema.condominio.dto.MoradoresDto;
import br.com.sistema.condominio.enums.Bloco;
import br.com.sistema.condominio.enums.Garagem;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	private String dataHora;
	private String nome;
	private String cpf;
	private String fone;	
	private Bloco bloco;
	private Integer apartamento;	
	private Garagem garagem;	
	@OneToMany(mappedBy = "morador",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Ocorrencia> ocorrencia = new ArrayList<>();		
    @OneToMany(mappedBy = "morador",cascade = CascadeType.ALL,orphanRemoval = true)  
    @JsonIgnore
	private List<Lazer> lazer = new ArrayList<>();
    @OneToMany(mappedBy = "morador",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Visitante> visitante = new ArrayList<>();
	
    public Morador(MoradorDto morador) {
    	this.dataHora = morador.getDataHora();
		this.nome = morador.getNome();
		this.cpf = morador.getCpf();
		this.fone = morador.getFone();
		this.bloco = morador.getBloco();
		this.apartamento = morador.getApartamento();
		this.garagem = morador.getGaragem();
		this.ocorrencia = morador.getOcorrencia();
		this.lazer = morador.getLazer();
    }

	public Morador(MoradoresDto moradores) {
	     this.id = moradores.getId();
	     this.dataHora  =moradores.getDataHora();
	     this.nome = moradores.getNome();
	     this.fone = moradores.getFone();
	     this.bloco = moradores.getBloco();
	     this.apartamento = moradores.getApartamento();
	     this.garagem = moradores.getGaragem();
	     this.ocorrencia = moradores.getOcorrencia();
	     this.lazer = moradores.getLazer();
	}	
}
