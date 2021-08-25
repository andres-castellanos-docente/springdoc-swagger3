package com.prueba.basedatos.repositories;

import com.prueba.basedatos.entities.CiudadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CiudadRepository extends JpaRepository<CiudadEntity, Integer> {
    @Query("select c from CiudadEntity c where c.nombre like %?1")
    List<CiudadEntity> findByNameEndsWith(String chars);

    @Query(value = "select * from ciudad a where a.nombre= :nombre", nativeQuery = true)
    List<CiudadEntity> findByNameEndsWithNative(String nombre);

    @Modifying
    @Query(value = "update ciudad set activo= :activo where id_pais = :id_pais", nativeQuery = true)
    void updateCiudades(Boolean activo, Integer id_pais) throws  RuntimeException ;


}
