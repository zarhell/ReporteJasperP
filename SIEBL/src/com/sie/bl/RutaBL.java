/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sie.bl;

import com.sie.dao.RutaDAO;
import com.sie.dto.Ruta;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zarhell
 */
public class RutaBL {

    public List<Ruta> getRuta() {
        try {
            RutaDAO testRuta = new RutaDAO();
            testRuta.getRuta();
        } catch (SQLException ex) {
            Logger.getLogger(RutaBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insertRuta(Ruta pl) {
        try {
            RutaDAO testRuta = new RutaDAO();
            testRuta.insertRuta(pl);
        } catch (SQLException ex) {
            Logger.getLogger(RutaBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateRuta(Ruta pl) {
        try {
            RutaDAO testRuta = new RutaDAO();
            testRuta.updateRuta(pl);
        } catch (SQLException ex) {
            Logger.getLogger(RutaBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteRuta(Integer id) {
        try {
            RutaDAO testRuta = new RutaDAO();
            testRuta.deleteRuta(id);
        } catch (SQLException ex) {
            Logger.getLogger(RutaBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
