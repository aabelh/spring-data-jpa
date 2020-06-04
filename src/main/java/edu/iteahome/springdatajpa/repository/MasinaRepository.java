package edu.iteahome.springdatajpa.repository;

import edu.iteahome.springdatajpa.model.Masina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasinaRepository extends JpaRepository<Masina, String> {

    boolean existsByMarca(String marca);
}
