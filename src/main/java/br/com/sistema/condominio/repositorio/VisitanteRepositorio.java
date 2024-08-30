package br.com.sistema.condominio.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sistema.condominio.dominio.Visitante;

public interface VisitanteRepositorio extends JpaRepository<Visitante, Long> {

}
