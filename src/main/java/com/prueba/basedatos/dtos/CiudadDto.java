package com.prueba.basedatos.dtos;

import java.io.Serializable;


public class CiudadDto implements Serializable {
    private Integer id;
    private String nombre;
    private Integer idPai;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdPai() {
        return idPai;
    }

    public void setIdPai(Integer idPai) {
        this.idPai = idPai;
    }
}
