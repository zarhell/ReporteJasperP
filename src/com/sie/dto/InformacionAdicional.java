/**
 * @author B13rayan
 * @date   19-may-2018
 * @time   19:31:52 
 */

package com.sie.dto;

import java.sql.Timestamp;

public class InformacionAdicional {

    private Integer id;
    private Timestamp fechaingreso;
    private Timestamp fecharetiro;
    private Timestamp fechadefuncion;
    private String estadocivil;
    private String profesion;
    private Integer idgrupoempresarial;
    private Integer idsede;
    private Integer idcontrato;
    private Integer idpersona;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Timestamp fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public Timestamp getFecharetiro() {
        return fecharetiro;
    }

    public void setFecharetiro(Timestamp fecharetiro) {
        this.fecharetiro = fecharetiro;
    }

    public Timestamp getFechadefuncion() {
        return fechadefuncion;
    }

    public void setFechadefuncion(Timestamp fechadefuncion) {
        this.fechadefuncion = fechadefuncion;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public Integer getIdgrupoempresarial() {
        return idgrupoempresarial;
    }

    public void setIdgrupoempresarial(Integer idgrupoempresarial) {
        this.idgrupoempresarial = idgrupoempresarial;
    }

    public Integer getIdsede() {
        return idsede;
    }

    public void setIdsede(Integer idsede) {
        this.idsede = idsede;
    }

    public Integer getIdcontrato() {
        return idcontrato;
    }

    public void setIdcontrato(Integer idcontrato) {
        this.idcontrato = idcontrato;
    }

    public Integer getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Integer idpersona) {
        this.idpersona = idpersona;
    }
}
