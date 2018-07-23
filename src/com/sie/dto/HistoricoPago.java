/**
 * @author B13rayan
 * @date   19-may-2018
 * @time   19:39:28 
 */

package com.sie.dto;

import java.sql.Timestamp;

public class HistoricoPago {

    private Integer id;
    private Integer pago;
    private Integer contrato;
    private Integer valorpago;
    private Timestamp fechaoportunapago;
    private Timestamp fechamaximapago;
    private Timestamp fechapago;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPago() {
        return pago;
    }

    public void setPago(Integer pago) {
        this.pago = pago;
    }

    public Integer getContrato() {
        return contrato;
    }

    public void setContrato(Integer contrato) {
        this.contrato = contrato;
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

}
