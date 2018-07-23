/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sie.bl;

import com.sie.dao.StokeDAO;
import com.sie.dto.Stoke;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zarhell
 */
public class StokeBL {

    public List<Stoke> getStoke() {
        try {
            StokeDAO testStoke = new StokeDAO();
            testStoke.getStoke();
        } catch (SQLException ex) {
            Logger.getLogger(StokeBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }    

    public void insertStoke(Stoke st) {
        try {
            StokeDAO testStoke = new StokeDAO();
            testStoke.insertStoke(st);
        } catch (SQLException ex) {
            Logger.getLogger(StokeBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateStoke(Stoke st) {
        try {
            StokeDAO testStoke = new StokeDAO();
            testStoke.updateStoke(st);
        } catch (SQLException ex) {
            Logger.getLogger(StokeBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteStoke(Integer id) {
        try {
            StokeDAO testStoke = new StokeDAO();
            testStoke.deleteStoke(id);
        } catch (SQLException ex) {
            Logger.getLogger(StokeBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
