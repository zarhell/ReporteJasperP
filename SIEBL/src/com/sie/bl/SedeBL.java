/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sie.bl;

import com.sie.dao.SedeDAO;
import com.sie.dto.Sede;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zarhell
 */
public class SedeBL {

    public List<Sede> getSede() {
        try {
            SedeDAO testSede = new SedeDAO();
            testSede.getSede();
        } catch (SQLException ex) {
            Logger.getLogger(SedeBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void insertSede(Sede sd) {
        try {
            SedeDAO testSede = new SedeDAO();
            testSede.insertSede(sd);
        } catch (SQLException ex) {
            Logger.getLogger(SedeBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateSede(Sede sd) throws SQLException {
        SedeDAO testSede = new SedeDAO();
        testSede.updateSede(sd);
    }

    public void deleteSede(Integer id) {
        try {
            SedeDAO testSede = new SedeDAO();
            testSede.deleteSede(id);
        } catch (SQLException ex) {
            Logger.getLogger(SedeBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
