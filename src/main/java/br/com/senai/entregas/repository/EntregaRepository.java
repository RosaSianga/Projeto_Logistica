package br.com.senai.entregas.repository;

import br.com.senai.entregas.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega,Integer> {
}
