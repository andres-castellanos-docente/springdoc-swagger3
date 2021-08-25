package com.prueba.basedatos.servicesimp;

import java.util.*;

import com.prueba.basedatos.dtos.PersonaQueryDto;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prueba.basedatos.services.PersonasService;
import org.springframework.http.ResponseEntity;
import com.prueba.basedatos.entities.PersonasEntity;
import com.prueba.basedatos.responses.PersonasResponse;
import com.prueba.basedatos.repositories.PersonasRepository;

@Service
public class PersonasServiceImp implements PersonasService {

@Autowired
private PersonasRepository personasRepository;

  @Override
  public ResponseEntity<PersonasResponse> getPersonas() {
    List<String> listMess = new ArrayList<>();
    try {
      List<PersonasEntity> personasAll = personasRepository.findAll();
      listMess.add("Se consulta ok");
      return new ResponseEntity<>(new PersonasResponse(1, listMess, personasAll, HttpStatus.OK.value()), HttpStatus.OK);
    } catch (Exception e) {
        listMess.add("Ocurrió un error al consultar");
        return new ResponseEntity<>(new PersonasResponse(-1, listMess, HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @Override
  public List<PersonaQueryDto> getPersonas(String nombre) {


    try {
      List<PersonaQueryDto> personasAll = personasRepository.findByNameEndsWithNative(nombre);

       return personasAll;
    } catch (Exception e) {

      return null;
    }

  }

  @Override
  public ResponseEntity<PersonasResponse> createEditPersonas(PersonasEntity personasEntity) {
    List<String> listMess = new ArrayList<>();
    try {
      List<PersonasEntity> listPersonasSaved = new ArrayList<>();
      PersonasEntity personasSaved = personasRepository.save(personasEntity);
      listPersonasSaved.add(personasSaved);
      listMess.add("Se guardó ok");
      return new ResponseEntity<>(new PersonasResponse(1, listMess,listPersonasSaved,  HttpStatus.OK.value()), HttpStatus.OK);
    } catch (Exception e) {
        listMess.add("Ocurrió un error al guardar");
        return new ResponseEntity<>(new PersonasResponse(-1, listMess, HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @Override
  public ResponseEntity<PersonasResponse> removePersonas(Long idPersonas) {
    List<String> listMess = new ArrayList<>();
    try {
      personasRepository.deleteById(idPersonas);
      listMess.add("Se elimina ok");
      return new ResponseEntity<>(new PersonasResponse(1, listMess,  HttpStatus.OK.value()), HttpStatus.OK);
    } catch (Exception e) {
        listMess.add("Ocurrió un error al eliminar");
        return new ResponseEntity<>(new PersonasResponse(-1, listMess, HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
