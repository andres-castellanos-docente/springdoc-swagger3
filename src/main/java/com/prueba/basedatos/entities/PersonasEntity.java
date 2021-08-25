package com.prueba.basedatos.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "personas", schema = "public", catalog = "prueba")
public class PersonasEntity {
    private Long id;
    private String pnombre;
    private String snombre;
    private String papellido;
    private String sapellido;
    private Long telefono;
    private String email;
    private CiudadEntity ciudadByIdciudad;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "pnombre", nullable = false, length = 80)
    public String getPnombre() {
        return pnombre;
    }

    public void setPnombre(String pnombre) {
        this.pnombre = pnombre;
    }

    @Basic
    @Column(name = "snombre", nullable = true, length = 80)
    public String getSnombre() {
        return snombre;
    }

    public void setSnombre(String snombre) {
        this.snombre = snombre;
    }

    @Basic
    @Column(name = "papellido", nullable = false, length = 80)
    public String getPapellido() {
        return papellido;
    }

    public void setPapellido(String papellido) {
        this.papellido = papellido;
    }

    @Basic
    @Column(name = "sapellido", nullable = true, length = 80)
    public String getSapellido() {
        return sapellido;
    }

    public void setSapellido(String sapellido) {
        this.sapellido = sapellido;
    }

    @Basic
    @Column(name = "telefono", nullable = false)
    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonasEntity that = (PersonasEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (pnombre != null ? !pnombre.equals(that.pnombre) : that.pnombre != null) return false;
        if (snombre != null ? !snombre.equals(that.snombre) : that.snombre != null) return false;
        if (papellido != null ? !papellido.equals(that.papellido) : that.papellido != null) return false;
        if (sapellido != null ? !sapellido.equals(that.sapellido) : that.sapellido != null) return false;
        if (telefono != null ? !telefono.equals(that.telefono) : that.telefono != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (pnombre != null ? pnombre.hashCode() : 0);
        result = 31 * result + (snombre != null ? snombre.hashCode() : 0);
        result = 31 * result + (papellido != null ? papellido.hashCode() : 0);
        result = 31 * result + (sapellido != null ? sapellido.hashCode() : 0);
        result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idciudad", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    public CiudadEntity getCiudadByIdciudad() {
        return ciudadByIdciudad;
    }

    public void setCiudadByIdciudad(CiudadEntity ciudadByIdciudad) {
        this.ciudadByIdciudad = ciudadByIdciudad;
    }
}
