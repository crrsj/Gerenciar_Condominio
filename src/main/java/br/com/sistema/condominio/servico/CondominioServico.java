package br.com.sistema.condominio.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sistema.condominio.dominio.Morador;
import br.com.sistema.condominio.dto.MoradorDto;
import br.com.sistema.condominio.repositorio.LazerRepositorio;
import br.com.sistema.condominio.repositorio.MoradorRepositorio;
import br.com.sistema.condominio.repositorio.OcorrenciaRepositorio;

@Service
public class CondominioServico {
    
	@Autowired
	private MoradorRepositorio moradorRepositorio;
	@Autowired
	private OcorrenciaRepositorio ocorrenciaRepositorio;
	@Autowired
	private LazerRepositorio lazerRepositorio;
	
	public Morador cadastrarMorador(MoradorDto morador) {
		var cadastro = new Morador(morador);
	    return moradorRepositorio.save(cadastro);
	}
}
