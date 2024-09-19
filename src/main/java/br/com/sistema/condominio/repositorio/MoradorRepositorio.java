package br.com.sistema.condominio.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sistema.condominio.dominio.Morador;


public interface MoradorRepositorio extends JpaRepository<Morador, Long>{

	@Query(value = "select m from Morador m where upper(trim(m.nome)) like %?1% ") 
	List<Morador> findByNome(String nome);

	

}
