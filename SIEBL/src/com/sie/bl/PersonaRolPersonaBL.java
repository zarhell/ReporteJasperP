/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sie.bl;

import com.sie.dao.PersonaRolPersonaDAO;
import com.sie.dto.PersonaRolPersona;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zarhell
 */
public class PersonaRolPersonaBL {

    public List<PersonaRolPersona> getRolPersona() {
        try {
            PersonaRolPersonaDAO testPersonaRolPersona = new PersonaRolPersonaDAO();
            testPersonaRolPersona.getRolPersona();
        } catch (SQLException ex) {
            Logger.getLogger(PersonaRolPersonaBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }    

    public void insertRolPersona(PersonaRolPersona rolperson) {
        try {
            PersonaRolPersonaDAO testPersonaRolPersona = new PersonaRolPersonaDAO();
            testPersonaRolPersona.insertRolPersona(rolperson);
        } catch (SQLException ex) {
            Logger.getLogger(PersonaRolPersonaBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateRolPersona(PersonaRolPersona rolperson) {
        try {
            PersonaRolPersonaDAO testPersonaRolPersona = new PersonaRolPersonaDAO();
            testPersonaRolPersona.updateRolPersona(rolperson);
        } catch (SQLException ex) {
            Logger.getLogger(PersonaRolPersonaBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteRolPersona(Integer idrp) {
        try {
            PersonaRolPersonaDAO testPersonaRolPersona = new PersonaRolPersonaDAO();
            testPersonaRolPersona.deleteRolPersona(idrp);
        } catch (SQLException ex) {
            Logger.getLogger(PersonaRolPersonaBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
