/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sie.bl;

import com.sie.dao.PersonaDAO;
import com.sie.dto.Persona;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Estudiante 2018
 */
public class PersonaBL {

    public List<Persona> getPersonas() {

        try {
            PersonaDAO testPersona = new PersonaDAO();
            return testPersona.getPersonas();
        } catch (SQLException ex) {
            Logger.getLogger(PersonaBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Persona> getPersonasIdentificacion(Integer identificacion) {
        try {
            PersonaDAO testPersona = new PersonaDAO();
            return testPersona.getPersonasIdentificacion(identificacion);
        } catch (SQLException ex) {
            Logger.getLogger(PersonaBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public List<Persona> getPersonasNombre(String nombre) {
        try {
            PersonaDAO testPersona = new PersonaDAO();
            return testPersona.getPersonasNombre(nombre);
        } catch (SQLException ex) {
            Logger.getLogger(PersonaBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public void insertPersonas(Persona person) {
        try {
            PersonaDAO testPersona = new PersonaDAO();
            testPersona.insertPersonas(person);
        } catch (SQLException ex) {
            Logger.getLogger(PersonaBL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updatePersonas(Persona person) {
        try {
            PersonaDAO testPersona = new PersonaDAO();
            testPersona.updatePersonas(person);
        } catch (SQLException ex) {
            Logger.getLogger(PersonaBL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     public void deletePersonas(Integer id){
        try {
            PersonaDAO testPersona = new PersonaDAO();
            testPersona.deletePersonas(id);
        } catch (SQLException ex) {
            Logger.getLogger(PersonaBL.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
     }

}
