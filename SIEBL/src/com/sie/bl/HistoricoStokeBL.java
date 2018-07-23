/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sie.bl;

import com.sie.dao.HistoricoStokeDAO;
import com.sie.dto.HistoricoStoke;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zarhell
 */
public class HistoricoStokeBL {
     public List<HistoricoStoke> getHistoricoStoke() {
         try {
             HistoricoStokeDAO testHistoricoStoke = new HistoricoStokeDAO();
             testHistoricoStoke.getHistoricoStoke();
             
         } catch (SQLException ex) {
             Logger.getLogger(HistoricoStokeBL.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
         
     }
     public void insertHistoricoStoke(HistoricoStoke historico) {
         try {
             HistoricoStokeDAO testHistoricoStoke = new HistoricoStokeDAO();
             testHistoricoStoke.insertHistoricoStoke(historico);
         } catch (SQLException ex) {
             Logger.getLogger(HistoricoStokeBL.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
     public void updateHistoricoStoke(HistoricoStoke historico) {
         try {
             HistoricoStokeDAO testHistoricoStoke = new HistoricoStokeDAO();
             testHistoricoStoke.updateHistoricoStoke(historico);
         } catch (SQLException ex) {
             Logger.getLogger(HistoricoStokeBL.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
     public void deleteHistoricoStoke(Integer id) {
         try {
             HistoricoStokeDAO testHistoricoStoke = new HistoricoStokeDAO();
             testHistoricoStoke.deleteHistoricoStoke(id);
         } catch (SQLException ex) {
             Logger.getLogger(HistoricoStokeBL.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
}
