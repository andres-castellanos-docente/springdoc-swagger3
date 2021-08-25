package com.prueba.basedatos.services;

import com.prueba.basedatos.dtos.PaisDto;
import org.springframework.http.ResponseEntity;
import com.prueba.basedatos.entities.PaisEntity;
import com.prueba.basedatos.responses.PaisResponse;

public interface PaisService {

  ResponseEntity<PaisResponse> getPais();
  ResponseEntity<PaisResponse> createEditPais(PaisDto pais);
  ResponseEntity<PaisResponse> removePais(Integer idPais);

}
