/**
 * @author B13rayan
 * @date   19-may-2018
 * @time   19:47:49 
 */

package com.sie.dto;

import java.sql.Timestamp;

public class Pago {

    private Integer id;
    private Integer valorpago;
    private Timestamp fechaoportunapago;
    private Timestamp fechamaximapago;
    private Timestamp fechapago;
    private Integer idcontrato;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValorpago() {
        return valorpago;
    }

    public void setValorpago(Integer valorpago) {
        this.valorpago = valorpago;
    }

    public Timestamp getFechaoportunapago() {
        return fechaoportunapago;
    }

    public void setFechaoportunapago(Timestamp fechaoportunapago) {
        this.fechaoportunapago = fechaoportunapago;
    }

    public Timestamp getFechamaximapago() {
        return fechamaximapago;
    }

    public void setFechamaximapago(Timestamp fechamaximapago) {
        this.fechamaximapago = fechamaximapago;
    }

    public Timestamp getFechapago() {
        return fechapago;
    }

    public void setFechapago(Timestamp fechapago) {
        this.fechapago = fechapago;
    }

    public Integer getIdcontrato() {
        return idcontrato;
    }

    public void setIdcontrato(Integer idcontrato) {
        this.idcontrato = idcontrato;
    }

}
