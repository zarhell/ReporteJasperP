/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sie.bl;

import com.sie.dao.UsuarioDAO;
import com.sie.dto.Usuario;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zarhell
 */
public class UsuarioBL {

    public List<Usuario> getUsuario() {
        try {
            UsuarioDAO testUsuario = new UsuarioDAO();
            testUsuario.getUsuario();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void insertUsuario(Usuario usr, Integer idn) {
        try {
            UsuarioDAO testUsuario = new UsuarioDAO();
            testUsuario.insertUsuario(usr, idn);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updatePersonas(Usuario usr) {
        try {
            UsuarioDAO testUsuario = new UsuarioDAO();
            testUsuario.updatePersonas(usr);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
