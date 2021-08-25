package com.prueba.basedatos.controllers;

import com.prueba.basedatos.dtos.PaisDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.prueba.basedatos.responses.PaisResponse;
import com.prueba.basedatos.services.PaisService;


@RestController
public class PaisController {

  @Autowired
  private PaisService paisService;

  @GetMapping("/pais")
  public ResponseEntity<PaisResponse> getPais() {
     return paisService.getPais();
  }

  @PostMapping("/pais")
  public ResponseEntity<PaisResponse> addPais(@RequestBody PaisDto pais) {
     return paisService.createEditPais(pais);
  }

  @PutMapping("/pais")
  public ResponseEntity<PaisResponse> editPais(@RequestBody PaisDto pais) {
     return paisService.createEditPais(pais);
  }

  @DeleteMapping("/pais/{id}")
  public ResponseEntity<PaisResponse> delPais(@PathVariable(value = "id") Integer idPais) {
     return paisService.removePais(idPais);
  }

}
