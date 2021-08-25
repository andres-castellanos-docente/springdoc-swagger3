package com.prueba.basedatos.repositories;

import com.prueba.basedatos.dtos.PersonaQueryDto;
import com.prueba.basedatos.entities.CiudadEntity;
import com.prueba.basedatos.entities.PersonasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonasRepository extends JpaRepository<PersonasEntity,Long> {



    @Query(value = "SELECT p.id, p.pnombre, p.papellido,p.telefono, p.email, c.nombre as nombreciudad FROM public.personas p inner join public.ciudad c on p.idciudad = c.id where p.pnombre = :nombre", nativeQuery = true)
    List<PersonaQueryDto> findByNameEndsWithNative(String nombre);



}
