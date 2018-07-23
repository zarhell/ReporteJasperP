/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sie.bl;

import com.sie.dao.PagoDAO;
import com.sie.dto.Pago;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zarhell
 */
public class PagoBL {
    public List<Pago> getPago (){
        try {
            PagoDAO testPago = new PagoDAO();
            testPago.getPago();
        } catch (SQLException ex) {
            Logger.getLogger(PagoBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Pago> getPagoContrato (Integer idpago){
        try {
            PagoDAO testPago = new PagoDAO();

            testPago.getPagoContrato(idpago);
        } catch (SQLException ex) {
            Logger.getLogger(PagoBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
            
    }
    public void insertPago (Pago pg){
        try {
            PagoDAO testPago = new PagoDAO();

            testPago.insertPago(pg);
        } catch (SQLException ex) {
            Logger.getLogger(PagoBL.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
public void updatePago (Pago pg) {
        try {
            PagoDAO testPago = new PagoDAO();
            testPago.updatePago(pg);
        } catch (SQLException ex) {
            Logger.getLogger(PagoBL.class.getName()).log(Level.SEVERE, null, ex);
        }
}    
public void deletePago (Integer id){
        try {
            PagoDAO testPago = new PagoDAO();
            testPago.deletePago(id);
        } catch (SQLException ex) {
            Logger.getLogger(PagoBL.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}
