/**
 * @author B13rayan
 * @date   20-may-2018
 * @time   12:35:23 
 */

package com.sie.dao;

import com.sie.dao.util.Conexion;
import com.sie.dto.BeneficiarioAfiliado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BeneficiarioAfiliadoDAO {

    private BeneficiarioAfiliado beneficiario;
    private Connection link;
    private PreparedStatement pstmt = null;

    public BeneficiarioAfiliadoDAO()throws SQLException{
    
        Conexion con = new Conexion();
        link = con.conectar();
    }   
    
    public List<BeneficiarioAfiliado> getBeneficiarioAfiliado(Integer afiliado) throws SQLException{
        
        String sql;
        sql = "SELECT id_beneficiario_afiliado, fk_afiliado, fk_beneficiario, fk_parentesco "
                + "FROM beneficiario_afiliado "
                + "WHERE fk_afiliado= ? ";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setInt(1,afiliado);
        
        ResultSet rs = pstmt.executeQuery();
        
        List<BeneficiarioAfiliado> list = new ArrayList<BeneficiarioAfiliado>();
        beneficiario = null;
        
        while(rs.next()){
            
            beneficiario = new BeneficiarioAfiliado();
            beneficiario.setId(rs.getInt("id_beneficiario_afiliado"));
            beneficiario.setIdafiliado(rs.getInt("fk_afiliado"));
            beneficiario.setIdbeneficiario(rs.getInt("fk_beneficiario"));
            beneficiario.setIdparentesco(rs.getInt("fk_parentesco"));
            
            list.add(beneficiario);                       
        }
        
        return list; 
    }    

    public void insertBeneficiarioAfiliado(BeneficiarioAfiliado beneficiario) throws SQLException{
        
        String sql;
        sql = "INSERT INTO beneficiario_afiliado"
                + "(fk_afiliado, fk_beneficiario, fk_parentesco) "
                + "VALUES "
                + "(?,?,?)";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setInt(1, beneficiario.getIdafiliado());
        pstmt.setInt(2, beneficiario.getIdbeneficiario());
        pstmt.setInt(3, beneficiario.getIdparentesco());
        
        pstmt.execute();
       
    }   
    
    public void updateBeneficiarioAfiliado(BeneficiarioAfiliado beneficiario) throws SQLException{
        
        String sql;
        sql = "UPDATE beneficiario_afiliado SET "
                + "fk_afiliado= ? ,"
                + "fk_beneficiario= ? ,"
                + "fk_parentesco= ? "
                + "WHERE id_beneficiario_afiliado= ? ";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setInt(1, beneficiario.getIdafiliado());
        pstmt.setInt(2, beneficiario.getIdbeneficiario());
        pstmt.setInt(3, beneficiario.getIdparentesco());
        pstmt.setInt(4, beneficiario.getId());
        
        pstmt.executeUpdate();
       
    }
    
    public void deleteBeneficiarioAfiliado(Integer beneficiario) throws SQLException{
        
        String sql;
        sql = "DELETE FROM beneficiario_afiliado "
                + "WHERE id_beneficiario_afiliado= ? ";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setInt(1, beneficiario);
        
        pstmt.executeUpdate();
       
    }
    
}
