package com.prueba.basedatos.responses;

import java.util.List;
import com.prueba.basedatos.entities.CiudadEntity;

public class CiudadResponse extends ResponseGen {

  List<CiudadEntity> ciudad;

  public CiudadResponse (Integer responseCode, List<String> responseDescription, Integer status) {
    setResponseCode(responseCode);
    setResponseDescription(responseDescription);
    setStatus(status);
  }

  public CiudadResponse (Integer responseCode, List<String> responseDescription,List<CiudadEntity> ciudad, Integer status) {
    setResponseCode(responseCode);
    setResponseDescription(responseDescription);
    setStatus(status);
    setCiudad(ciudad);
  }

  public void setCiudad(List<CiudadEntity> ciudad){
    this.ciudad = ciudad;
  }

  public List<CiudadEntity>  getCiudad() {
    return ciudad;
  }

}
