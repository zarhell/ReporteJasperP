/**
 * @author B13rayan
 * @date   19-may-2018
 * @time   19:46:26 
 */

package com.sie.dto;

public class GrupoEmpresarial {

    private Integer idgrupo;
    private String nombre;
    private Integer nitgrupo;
    private String responsable;
    private Integer telefono;

    public Integer getIdGrupo() {
        return idgrupo;
    }

    public void setIdGrupo(Integer grupo) {
        this.idgrupo = grupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNitgrupo() {
        return nitgrupo;
    }

    public void setNitgrupo(Integer nitgrupo) {
        this.nitgrupo = nitgrupo;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

}
