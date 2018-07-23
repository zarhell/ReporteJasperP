/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sie.bl;

import com.sie.dao.RolPersonaDAO;
import com.sie.dto.RolPersona;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zarhell
 */
public class RolPersonaBL {

    public List<RolPersona> getRolPersona() {
        try {
            RolPersonaDAO testRolPersona = new RolPersonaDAO();
            testRolPersona.getRolPersona();

        } catch (SQLException ex) {
            Logger.getLogger(RolPersonaBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insertRolPersona(RolPersona rolp) {
        try {
            RolPersonaDAO testRolPersona = new RolPersonaDAO();
            testRolPersona.insertRolPersona(rolp);
        } catch (SQLException ex) {
            Logger.getLogger(RolPersonaBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateRolPersona(RolPersona rolp) {
        try {
            RolPersonaDAO testRolPersona = new RolPersonaDAO();
            testRolPersona.updateRolPersona(rolp);
        } catch (SQLException ex) {
            Logger.getLogger(RolPersonaBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteRolPersona(Integer idr) {
        try {
            RolPersonaDAO testRolPersona = new RolPersonaDAO();
            testRolPersona.deleteRolPersona(idr);
        } catch (SQLException ex) {
            Logger.getLogger(RolPersonaBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
