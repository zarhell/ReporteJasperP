/**
 * @author B13rayan
 * @date   21-may-2018
 * @time   17:47:20 
 */

package com.sie.dao;

import com.sie.dao.util.Conexion;
import com.sie.dto.RolPersona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RolPersonaDAO {

    private RolPersona rp;
    private Connection link;
    private PreparedStatement pstmt = null;  

    public RolPersonaDAO() throws SQLException{
        
        Conexion con = new Conexion();
        link = con.conectar();
    }
    
    /*
     * id_rol_persona, nombre_rol_persona
     * test prueba
     */

    public List<RolPersona> getRolPersona () throws SQLException{
        
        String sql;
        sql = "SELECT  id_rol_persona, nombre_rol_persona"
                + "FROM rol_persona";
        
        pstmt = this.link.prepareStatement(sql);
        
        ResultSet rs = pstmt.executeQuery();
        
        List<RolPersona> list = new ArrayList<RolPersona>();
        rp = null;
        
        while(rs.next()){
            
            rp = new RolPersona();
            rp.setId(rs.getInt("id_rol_persona"));
            rp.setNombre(rs.getString("nombre_rol_persona"));
            
            list.add(rp);
            
        }
        
        return list;
    }
    
     public void insertRolPersona(RolPersona rolp) throws SQLException{
        
        String sql;
        sql = "INSERT INTO rol_persona "
                + "(nombre_rol_persona) "
                + "VALUES (?)";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setString(1, rolp.getNombre());
        
        pstmt.executeQuery();
        
    }
    
     public void updateRolPersona(RolPersona rolp) throws SQLException{
        
        String sql;
        sql = "UPDATE rol_persona SET "
                + "nombre_rol_persona = ? "
                + "WHERE id_rol_persona= ?";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setString(1, rolp.getNombre());
        pstmt.setInt(2, rolp.getId());
        
        pstmt.executeUpdate();
        
    }

     public void deleteRolPersona(Integer idr) throws SQLException{
        
        String sql;
        sql = "DELETE FROM rol_persona "
                + "WHERE id_rol_persona= ?";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setInt(1, idr);
        
        pstmt.executeUpdate();
        
    }























    
}