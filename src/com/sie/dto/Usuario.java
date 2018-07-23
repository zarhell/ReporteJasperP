/**
 * @author B13rayan
 * @date   26-may-2018
 * @time   18:28:38 
 */

package com.sie.dto;

public class Usuario {
    
    private Integer id;
    private String nombre;
    private String contrasena;
    private Integer fk_persona;

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

    public String getContraseña() {
        return contrasena;
    }

    public void setContraseña(String contrasena) {
        this.contrasena = contrasena;
    }

    public Integer getFk_persona() {
        return fk_persona;
    }

    public void setFk_persona(Integer fk_persona) {
        this.fk_persona = fk_persona;
    }
    
}
