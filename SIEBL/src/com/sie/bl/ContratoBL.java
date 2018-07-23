/**
 * @author B13rayan
 * @date   27-may-2018
 * @time   16:31:11
 */

package com.sie.bl;

import com.sie.dao.ContratoDAO;
import com.sie.dto.Contrato;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ContratoBL {

    ContratoDAO contr;
    
    public List<Contrato> getContrato(){
        
        try {
            contr = new ContratoDAO();
            
            return contr.getContrato();
        } catch (SQLException ex) {
            Logger.getLogger(ContratoBL.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return null;
        
    }
	
    public List<Contrato> getContratoPersona(Integer persona){
        
        try {
            contr = new ContratoDAO();
            
            return contr.getContratoPersona(persona);
        } catch (SQLException ex) {
            Logger.getLogger(ContratoBL.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return null;
        
    }
    
    public void insertContrato(Contrato contrato){
        
        try {
            contr = new ContratoDAO();
            
            contr.insertContrato(contrato);
        } catch (SQLException ex) {
            Logger.getLogger(ContratoBL.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
    public void updateContrato(Contrato contrato){
        
        try {
            contr = new ContratoDAO();
            
            contr.updateContrato(contrato);
        } catch (SQLException ex) {
            Logger.getLogger(ContratoBL.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
    public void deleteContrato(Integer id){
        
        try {
            contr = new ContratoDAO();
            
            contr.deleteContrato(id);
        } catch (SQLException ex) {
            Logger.getLogger(ContratoBL.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

}
