/**
 * @author B13rayan
 * @date   22-may-2018
 * @time   18:53:23 
 */

package com.sie.bl;


import com.sie.dao.BeneficiarioAfiliadoDAO;
import com.sie.dto.BeneficiarioAfiliado;
import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BeneficiarioAfiliadoBL {
    
    BeneficiarioAfiliadoDAO badao;
    
    public List<BeneficiarioAfiliado> getBeneficiarioAfiliado(Integer afiliado){
        
        try {
            badao = new BeneficiarioAfiliadoDAO();
            
            return badao.getBeneficiarioAfiliado(afiliado);
        } catch (SQLException ex) {
            Logger.getLogger(BeneficiarioAfiliadoBL.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return null;
        
    }
    
    public void insertBeneficiarioAfiliado(BeneficiarioAfiliado beneficiario){
        
        try {
            badao = new BeneficiarioAfiliadoDAO();
            
            badao.insertBeneficiarioAfiliado(beneficiario);
        } catch (SQLException ex) {
            Logger.getLogger(BeneficiarioAfiliadoBL.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
    public void updateBeneficiarioAfiliado(BeneficiarioAfiliado beneficiario){
        
        try {
            badao = new BeneficiarioAfiliadoDAO();
            
            badao.updateBeneficiarioAfiliado(beneficiario);
        } catch (SQLException ex) {
            Logger.getLogger(BeneficiarioAfiliadoBL.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
    public void deleteBeneficiarioAfiliado(Integer id){
        
        try {
            badao = new BeneficiarioAfiliadoDAO();
            
            badao.deleteBeneficiarioAfiliado(id);
        } catch (SQLException ex) {
            Logger.getLogger(BeneficiarioAfiliadoBL.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
}
