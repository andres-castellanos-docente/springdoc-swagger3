package com.prueba.basedatos.servicesimp;

import java.util.*;

import com.prueba.basedatos.dtos.PaisDto;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prueba.basedatos.services.PaisService;
import org.springframework.http.ResponseEntity;
import com.prueba.basedatos.entities.PaisEntity;
import com.prueba.basedatos.responses.PaisResponse;
import com.prueba.basedatos.repositories.PaisRepository;

@Service
public class PaisServiceImp implements PaisService {

@Autowired
private PaisRepository paisRepository;

  @Override
  public ResponseEntity<PaisResponse> getPais() {
    List<String> listMess = new ArrayList<>();
    try {
      List<PaisEntity> paisAll = paisRepository.findAll();
      listMess.add("Se consulta ok");
      return new ResponseEntity<>(new PaisResponse(1, listMess, paisAll, HttpStatus.OK.value()), HttpStatus.OK);
    } catch (Exception e) {
        listMess.add("Ocurrió un error al consultar");
        return new ResponseEntity<>(new PaisResponse(-1, listMess, HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @Override
  public ResponseEntity<PaisResponse> createEditPais(PaisDto paisDto) {
    List<String> listMess = new ArrayList<>();
    try {
      PaisEntity paisEntity = new PaisEntity();
      List<PaisEntity> listPaisSaved = new ArrayList<>();
      if (Objects.isNull(paisDto.getId())==false){
        paisEntity.setId(paisDto.getId());
      }
      paisEntity.setNombre(paisDto.getNombre());

      PaisEntity paisSaved = paisRepository.save(paisEntity);
      listPaisSaved.add(paisSaved);
      listMess.add("Se guardó ok");
      return new ResponseEntity<>(new PaisResponse(1, listMess,listPaisSaved,  HttpStatus.OK.value()), HttpStatus.OK);
    } catch (Exception e) {
        listMess.add("Ocurrió un error al guardar");
        return new ResponseEntity<>(new PaisResponse(-1, listMess, HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @Override
  public ResponseEntity<PaisResponse> removePais(Integer idPais) {
    List<String> listMess = new ArrayList<>();
    try {
      paisRepository.deleteById(idPais);
      listMess.add("Se elimina ok");
      return new ResponseEntity<>(new PaisResponse(1, listMess,  HttpStatus.OK.value()), HttpStatus.OK);
    } catch (Exception e) {
        listMess.add("Ocurrió un error al eliminar");
        return new ResponseEntity<>(new PaisResponse(-1, listMess, HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
