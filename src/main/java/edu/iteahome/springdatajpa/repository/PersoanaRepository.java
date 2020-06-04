package edu.iteahome.springdatajpa.repository;

import edu.iteahome.springdatajpa.model.Persoana;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PersoanaRepository extends JpaRepository<Persoana, Long> {


    @Query("select p from Persoana p where p.identificator= :id")
    List findByCeva(@Param("id") long id);

    @Transactional
    void deletePersoanaByNume(String nume);

    // finding all persons that having one care that matches with param 'marca'
    List findByMasinaMarca(String marca);
}
