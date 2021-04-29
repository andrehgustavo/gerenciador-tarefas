package br.com.esig.gerenciador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.esig.gerenciador.model.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long>{

}
