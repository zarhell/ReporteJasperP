/**
 * @author B13rayan
 * @date   19-may-2018
 * @time   19:50:38 
 */

package com.sie.dto;

import java.sql.Timestamp;

public class Contrato {

    private Integer id;
    private Integer idpersona;
    private Timestamp fechafirma;
    private String descripcion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Integer idpersona) {
        this.idpersona = idpersona;
    }

    public Timestamp getFechafirma() {
        return fechafirma;
    }

    public void setFechafirma(Timestamp fechafirma) {
        this.fechafirma = fechafirma;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
