package br.com.sistema.condominio.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sistema.condominio.dominio.Morador;

public interface MoradorRepositorio extends JpaRepository<Morador, Long>{

}
