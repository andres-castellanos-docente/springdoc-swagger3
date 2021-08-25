package com.prueba.basedatos.responses;

import java.util.List;
import com.prueba.basedatos.entities.PaisEntity;

public class PaisResponse extends ResponseGen {

  List<PaisEntity> pais;

  public PaisResponse (Integer responseCode, List<String> responseDescription, Integer status) {
    setResponseCode(responseCode);
    setResponseDescription(responseDescription);
    setStatus(status);
  }

  public PaisResponse (Integer responseCode, List<String> responseDescription,List<PaisEntity> pais, Integer status) {
    setResponseCode(responseCode);
    setResponseDescription(responseDescription);
    setStatus(status);
    setPais(pais);
  }

  public void setPais(List<PaisEntity> pais){
    this.pais = pais;
  }

  public List<PaisEntity>  getPais() {
    return pais;
  }

}
