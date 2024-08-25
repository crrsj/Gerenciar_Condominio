package br.com.sistema.condominio.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sistema.condominio.dominio.Lazer;
import br.com.sistema.condominio.enums.Status;

public interface LazerRepositorio extends JpaRepository<Lazer, Long>{

	Lazer findByStatus(Status reservado);

}
