/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sie.bl;

import com.sie.dao.TalonarioDAO;
import com.sie.dto.Talonario;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zarhell
 */
public class TalonarioBL {
    
    public List<Talonario> getTalonario() {
        try {
            TalonarioDAO testTalonario = new TalonarioDAO();
            testTalonario.getTalonario();
        } catch (SQLException ex) {
            Logger.getLogger(TalonarioBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }    
    
    public void insertTalonario(Talonario tl) {
        try {
            TalonarioDAO testTalonario = new TalonarioDAO();
            testTalonario.insertTalonario(tl);
        } catch (SQLException ex) {
            Logger.getLogger(TalonarioBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateTalonario(Talonario tl) {
        try {
            TalonarioDAO testTalonario = new TalonarioDAO();
            testTalonario.updateTalonario(tl);
        } catch (SQLException ex) {
            Logger.getLogger(TalonarioBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteTalonario(Integer id) {
        try {
            TalonarioDAO testTalonario = new TalonarioDAO();
            testTalonario.deleteTalonario(id);
        } catch (SQLException ex) {
            Logger.getLogger(TalonarioBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
