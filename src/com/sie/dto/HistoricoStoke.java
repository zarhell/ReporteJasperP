/**
 * @author B13rayan
 * @date   19-may-2018
 * @time   20:26:41 
 */

package com.sie.dto;

import java.sql.Timestamp;

public class HistoricoStoke {

    private Integer idhistorico;
    private String nombre;
    private String descripcion;
    private Integer cantidad;
    private Timestamp fechamodificado;
    private Integer idstoke;

    public Integer getIdhistorico() {
        return idhistorico;
    }

    public void setIdhistorico(Integer idhistorico) {
        this.idhistorico = idhistorico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Timestamp getFechamodificado() {
        return fechamodificado;
    }

    public void setFechamodificado(Timestamp fechamodificado) {
        this.fechamodificado = fechamodificado;
    }

    public Integer getIdstoke() {
        return idstoke;
    }

    public void setIdstoke(Integer idstoke) {
        this.idstoke = idstoke;
    }

}
