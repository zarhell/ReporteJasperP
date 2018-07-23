/**
 * @author B13rayan
 * @date   27-may-2018
 * @time   15:09:10
 */

package com.sie.bl;

import com.sie.dao.InformacionAdicionalDAO;
import com.sie.dto.InformacionAdicional;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class InformacionAdicionalBL {

    InformacionAdicionalDAO infaddao;
    
    public List<InformacionAdicional> getinfoadicional(Integer person){
        
        try {
            infaddao = new InformacionAdicionalDAO();
            
            return infaddao.getInformacionPersona(Integer.SIZE);
        } catch (SQLException ex) {
            Logger.getLogger(BeneficiarioAfiliadoBL.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return null;
        
    }
    
    public void insertinfoadicional(InformacionAdicional inf){
        
        try {
            infaddao = new InformacionAdicionalDAO();
            
            infaddao.insertInformacionPersona(inf);
        } catch (SQLException ex) {
            Logger.getLogger(BeneficiarioAfiliadoBL.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
    public void updateinfoadicional(InformacionAdicional inf){
        
        try {
            infaddao = new InformacionAdicionalDAO();
            
            infaddao.updateInformacionPersona(inf);
        } catch (SQLException ex) {
            Logger.getLogger(BeneficiarioAfiliadoBL.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
    public void deleteinfoadicional(Integer id){
        
        try {
            infaddao = new InformacionAdicionalDAO();
            
            infaddao.deleteInformacionPersonal(id);
        } catch (SQLException ex) {
            Logger.getLogger(BeneficiarioAfiliadoBL.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

}
