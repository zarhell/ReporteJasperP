/**
 * @author B13rayan
 * @date   19-may-2018
 * @time   19:52:25 
 */

package com.sie.dto;

import java.sql.Timestamp;

public class Talonario {

    private Integer id;
    private Integer idfuncionario;
    private Timestamp fechacreacion;
    private Integer cantidad;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(Integer idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public Timestamp getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Timestamp fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    

}
