/**
 * @author B13rayan
 * @date   20-may-2018
 * @time   13:51:48 
 */

package com.sie.dao;

import com.sie.dao.util.Conexion;
import com.sie.dto.Contrato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContratoDAO {

    private Contrato contrato;
    private Connection link;
    private PreparedStatement pstmt = null;

    public ContratoDAO() throws SQLException{
        
        Conexion con = new Conexion();
        link = con.conectar();
        
    }
    
    public List<Contrato> getContrato () throws SQLException{
        
        String sql;
        sql = "SELECT id_contrato, fk_persona, fecha_firmado, descripcion_contrato "
                + "FROM contrato ";
        
        pstmt = this.link.prepareStatement(sql);
        
        ResultSet rs = pstmt.executeQuery();
        
        List<Contrato> list = new ArrayList<Contrato>();
        contrato = null;
        
        while(rs.next()){
            
            contrato = new Contrato();
            contrato.setId(rs.getInt("id_contrato"));
            contrato.setIdpersona(rs.getInt("fk_persona"));
            contrato.setFechafirma(rs.getTimestamp("fecha_firmado"));
            contrato.setDescripcion(rs.getString("descripcion_contrato"));
            
            list.add(contrato);
                    
        }
        
        return list;
    }
    
    public List<Contrato> getContratoPersona (Integer persona) throws SQLException{
        
        String sql;
        sql = "SELECT id_contrato, fk_persona, fecha_firmado, descripcion_contrato "
                + "FROM contrato "
                + "WHERE fk_persona = ?";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setInt(1, persona);
        
        ResultSet rs = pstmt.executeQuery();
        
        List<Contrato> list = new ArrayList<Contrato>();
        contrato = null;
        
        while(rs.next()){
            
            contrato = new Contrato();
            contrato.setId(rs.getInt("id_contrato"));
            contrato.setIdpersona(rs.getInt("fk_persona"));
            contrato.setFechafirma(rs.getTimestamp("fecha_firmado"));
            contrato.setDescripcion(rs.getString("descripcion_contrato"));
            
            list.add(contrato);
                    
        }
        
        return list;
    }
    
    public void insertContrato(Contrato cont) throws SQLException{
    
        String sql;
        sql = "INSERT INTO contrato"
                + "(fk_persona, fecha_firmado, descripcion_contrato) "
                + "VALUES "
                + "(?,?,?)";
        
        pstmt = link.prepareStatement(sql);
        pstmt.setInt(1, cont.getIdpersona());
        pstmt.setTimestamp(2, cont.getFechafirma());
        pstmt.setString(3, cont.getDescripcion());
        
        pstmt.execute();
    }
    
    public void updateContrato(Contrato cont) throws SQLException{
        
        String sql;
        sql = "UPDATE contrato SET "
                + "fk_persona= ? ,"
                + "fecha_firmado= ? ,"
                + "descripcion_contrato= ? "
                + "WHERE id_contrato= ? ";
        
        pstmt = link.prepareStatement(sql);
        pstmt.setInt(1, cont.getIdpersona());
        pstmt.setTimestamp(2, cont.getFechafirma());
        pstmt.setString(3, cont.getDescripcion());
        pstmt.setInt(4, cont.getId());
        
        pstmt.executeUpdate();
    }   
    
    public void deleteContrato (Integer contrato) throws SQLException{
        
        String sql;
        sql = "DELETE FROM contrato "
                + "WHERE id_contrato= ?";
        
        pstmt = link.prepareStatement(sql);
        pstmt.setInt(1, contrato);
        
        pstmt.executeUpdate();
    }
}
