package com.prueba.basedatos.services;

import com.prueba.basedatos.dtos.PersonaQueryDto;
import org.springframework.http.ResponseEntity;
import com.prueba.basedatos.entities.PersonasEntity;
import com.prueba.basedatos.responses.PersonasResponse;

import java.util.List;

public interface PersonasService {

  ResponseEntity<PersonasResponse> getPersonas();
  List<PersonaQueryDto> getPersonas(String nombre);

  ResponseEntity<PersonasResponse> createEditPersonas(PersonasEntity personas);
  ResponseEntity<PersonasResponse> removePersonas(Long idPersonas);

}
