/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sie.bl;

import com.sie.dao.ParentescoDAO;
import com.sie.dto.Parentesco;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zarhell
 */
public class ParentescoBL {
    
    public List<Parentesco> getParentesco(Integer nit) {
        try {
            ParentescoDAO testParentesco = new ParentescoDAO();
            testParentesco.getParentesco(nit);
        } catch (SQLException ex) {
            Logger.getLogger(ParentescoBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }    
    
    public void insertParentesco(Parentesco parent) {
        try {
            ParentescoDAO testParentesco = new ParentescoDAO();
            testParentesco.insertParentesco(parent);
        } catch (SQLException ex) {
            Logger.getLogger(ParentescoBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateParentesco(Parentesco parent) {
        try {
            ParentescoDAO testParentesco = new ParentescoDAO();
            testParentesco.updateParentesco(parent);
        } catch (SQLException ex) {
            Logger.getLogger(ParentescoBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteParentesco(Integer id) {
        try {
            ParentescoDAO testParentesco = new ParentescoDAO();
            testParentesco.deleteParentesco(id);
        } catch (SQLException ex) {
            Logger.getLogger(ParentescoBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
