package com.prueba.basedatos.responses;

import java.util.List;
import com.prueba.basedatos.entities.PersonasEntity;

public class PersonasResponse extends ResponseGen {

  List<PersonasEntity> personas;

  public PersonasResponse (Integer responseCode, List<String> responseDescription, Integer status) {
    setResponseCode(responseCode);
    setResponseDescription(responseDescription);
    setStatus(status);
  }

  public PersonasResponse (Integer responseCode, List<String> responseDescription,List<PersonasEntity> personas, Integer status) {
    setResponseCode(responseCode);
    setResponseDescription(responseDescription);
    setStatus(status);
    setPersonas(personas);
  }

  public void setPersonas(List<PersonasEntity> personas){
    this.personas = personas;
  }

  public List<PersonasEntity>  getPersonas() {
    return personas;
  }

}
