package br.com.sistema.condominio.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sistema.condominio.dominio.Ocorrencia;

public interface OcorrenciaRepositorio extends JpaRepository<Ocorrencia, Long> {

}
