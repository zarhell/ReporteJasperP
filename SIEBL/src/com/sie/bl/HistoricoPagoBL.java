/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sie.bl;

import com.sie.dao.HistoricoPagoDAO;
import com.sie.dto.HistoricoPago;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zarhell
 */
public class HistoricoPagoBL {
    
    public List<HistoricoPago> getHistoricoPago(Integer nit) {
        try {
            HistoricoPagoDAO testHistoricoPago = new HistoricoPagoDAO();
            testHistoricoPago.getHistoricoPago(nit);
        } catch (SQLException ex) {
            Logger.getLogger(HistoricoPagoBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insertHistoricoPago(HistoricoPago histpago) {
        try {
            HistoricoPagoDAO testHistoricoPago = new HistoricoPagoDAO();
            testHistoricoPago.insertHistoricoPago(histpago);
        } catch (SQLException ex) {
            Logger.getLogger(HistoricoPagoBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void updateHistoricoPago(HistoricoPago histpago) {
        try {
            HistoricoPagoDAO testHistoricoPago = new HistoricoPagoDAO();
            
            testHistoricoPago.updateHistoricoPago(histpago);
        } catch (SQLException ex) {
            Logger.getLogger(HistoricoPagoBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteHistoricoPago(Integer id) {
        try {
            HistoricoPagoDAO testHistoricoPago = new HistoricoPagoDAO();
            
            testHistoricoPago.deleteHistoricoPago(id);
        } catch (SQLException ex) {
            Logger.getLogger(HistoricoPagoBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
