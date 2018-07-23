/**
 * @author B13rayan
 * @date   19-may-2018
 * @time   19:59:59 
 */

package com.sie.dto;

public class ContratoPlan {

    private Integer id;
    private String periodicidad;
    private Integer idcontrato;
    private Integer idplan;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }

    public Integer getIdcontrato() {
        return idcontrato;
    }

    public void setIdcontrato(Integer idcontrato) {
        this.idcontrato = idcontrato;
    }

    public Integer getIdplan() {
        return idplan;
    }

    public void setIdplan(Integer idplan) {
        this.idplan = idplan;
    }

}
