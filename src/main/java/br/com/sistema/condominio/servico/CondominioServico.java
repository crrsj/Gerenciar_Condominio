package br.com.sistema.condominio.servico;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistema.condominio.dominio.Lazer;
import br.com.sistema.condominio.dominio.Morador;
import br.com.sistema.condominio.dominio.Ocorrencia;
import br.com.sistema.condominio.dominio.Visitante;
import br.com.sistema.condominio.dto.LazerDto;
import br.com.sistema.condominio.dto.MoradorDto;
import br.com.sistema.condominio.dto.MoradoresDto;
import br.com.sistema.condominio.dto.OcorrenciaDto;
import br.com.sistema.condominio.dto.VisitanteDto;
import br.com.sistema.condominio.enums.Status;
import br.com.sistema.condominio.repositorio.LazerRepositorio;
import br.com.sistema.condominio.repositorio.MoradorRepositorio;
import br.com.sistema.condominio.repositorio.OcorrenciaRepositorio;
import br.com.sistema.condominio.repositorio.VisitanteRepositorio;

@Service
public class CondominioServico {
    
	@Autowired
	private MoradorRepositorio moradorRepositorio;
	@Autowired
	private OcorrenciaRepositorio ocorrenciaRepositorio;
	@Autowired
	private LazerRepositorio lazerRepositorio;
	
	@Autowired
	private VisitanteRepositorio visitanteRepositorio;
	
	public Morador cadastrarMorador(MoradorDto morador) {
		var cadastro = new Morador(morador);
	    return moradorRepositorio.save(cadastro);
	}
	
	public Ocorrencia cadastrarOcorrencia(OcorrenciaDto ocorrencia,Long moradorId) {
		var newOcorrencia = new Ocorrencia(ocorrencia);
		var morador = moradorRepositorio.findById(moradorId).get();
		newOcorrencia.setMorador(morador);
		return ocorrenciaRepositorio.save(newOcorrencia);
	}
	
	public Lazer alugarEspaco(LazerDto lazerDto,Long moradorId) {		
		var alugar = new Lazer(lazerDto);
		var espaco = moradorRepositorio.findById(moradorId).get();
		alugar.setMorador(espaco);
		return lazerRepositorio.save(alugar);
			
	}
		
	public List<MoradoresDto> listarTodos() {
		var listar = moradorRepositorio.findAll().stream().map(MoradoresDto::new).toList();
		return listar;
	}
	
	public Morador AtualizarMorador(MoradoresDto moradores,Long id) {
		var atualizar = new Morador(moradores);
		atualizar.setId(id);
	return moradorRepositorio.save(atualizar);
	}
	
	public Morador buscarPorId(Long id) {		 
		Optional<Morador>buscar = moradorRepositorio.findById(id);
		return buscar.get();
	}
	
	public void excluir(Long id) {
		moradorRepositorio.deleteById(id);
	}
	
	public Lazer buscarAreaReservada() {
		var buscarArea = lazerRepositorio.findByStatus(Status.RESERVADO);
		return buscarArea;
		
		
	}
	
	public Visitante cadastrarVisitante(VisitanteDto visitante,Long moradorId) {
		var cadastrar = new Visitante(visitante);
		var cadastro = moradorRepositorio.findById(moradorId).get();
		cadastrar.setMorador(cadastro);
		return visitanteRepositorio.save(cadastrar);
	}
	
	public List<Morador> buscarPorNome(String nome) {
		return moradorRepositorio.findByNome(nome.trim().toUpperCase());
	}
}
