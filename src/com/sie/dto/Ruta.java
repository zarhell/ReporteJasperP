/**
 * @author B13rayan
 * @date   19-may-2018
 * @time   19:53:32 
 */

package com.sie.dto;

import java.sql.Timestamp;

public class Ruta {

    private Integer id;
    private Timestamp fechainicioruta;
    private Integer idrecaudador;
    private Integer iddirector;
    private String direcciones;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getFechainicioruta() {
        return fechainicioruta;
    }

    public void setFechainicioruta(Timestamp fechainicioruta) {
        this.fechainicioruta = fechainicioruta;
    }

    public Integer getIdrecaudador() {
        return idrecaudador;
    }

    public void setIdrecaudador(Integer idrecaudador) {
        this.idrecaudador = idrecaudador;
    }

    public Integer getIddirector() {
        return iddirector;
    }

    public void setIddirector(Integer iddirector) {
        this.iddirector = iddirector;
    }

    public String getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(String direcciones) {
        this.direcciones = direcciones;
    }

}
