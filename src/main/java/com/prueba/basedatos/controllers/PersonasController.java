package com.prueba.basedatos.controllers;

import com.prueba.basedatos.dtos.PersonaQueryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.prueba.basedatos.responses.PersonasResponse;
import com.prueba.basedatos.entities.PersonasEntity;
import com.prueba.basedatos.services.PersonasService;

import java.util.List;


@RestController
public class PersonasController {

  @Autowired
  private PersonasService personasService;

  @GetMapping("/personasentity")
  public ResponseEntity<PersonasResponse> getPersonas() {
     return personasService.getPersonas();
  }

  @PostMapping("/personasentity")
  public ResponseEntity<PersonasResponse> addPersonas(@RequestBody PersonasEntity personas) {
     return personasService.createEditPersonas(personas);
  }

  @PutMapping("/personasentity")
  public ResponseEntity<PersonasResponse> editPersonas(@RequestBody PersonasEntity personas) {
     return personasService.createEditPersonas(personas);
  }

  @DeleteMapping("/personasentity/{id}")
  public ResponseEntity<PersonasResponse> delPersonas(@PathVariable(value = "id") Long idPersonas) {
     return personasService.removePersonas(idPersonas);
  }
    @GetMapping("/personasentity/{nombre}")
    public List<PersonaQueryDto> busqPersonas(@PathVariable(value = "nombre") String nombre) {
        return personasService.getPersonas(nombre);
    }
}
