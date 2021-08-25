package com.prueba.basedatos.repositories;

import com.prueba.basedatos.entities.PaisEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<PaisEntity,Integer> {

}
