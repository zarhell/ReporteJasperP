/**
 * @author B13rayan
 * @date   20-may-2018
 * @time   22:00:20 
 */

package com.sie.dao;

import com.sie.dao.util.Conexion;
import com.sie.dto.Parentesco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParentescoDAO {

    private Parentesco parentesco;
    private Connection link;
    private PreparedStatement pstmt = null;  

    public ParentescoDAO() throws SQLException{
        
        Conexion con = new Conexion();
        link = con.conectar();
    }
 
    public List<Parentesco> getParentesco (Integer nit) throws SQLException{
        
        String sql;
        sql = "SELECT id_parentesco, parentesco "
                + "FROM parentesco";
        
        pstmt = this.link.prepareStatement(sql);
        
        ResultSet rs = pstmt.executeQuery();
        
        List<Parentesco> list = new ArrayList<Parentesco>();
        parentesco = null;
        
        while(rs.next()){
            
            parentesco = new Parentesco();
            parentesco.setId(rs.getInt("id_parentesco"));
            parentesco.setParentesco(rs.getString("parentesco"));
            
            list.add(parentesco);
            
        }
        
        return list;
    }
    
    public void insertParentesco(Parentesco parent) throws SQLException{
        
        String sql;
        sql = "INSERT INTO parentesco "
                + "(parentesco) "
                + "VALUES (?)";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setString(1, parent.getParentesco());
        
        pstmt.executeQuery();
        
    }
    
    public void updateParentesco(Parentesco parent) throws SQLException{
        
        String sql;
        sql = "UPDATE parentesco SET "
                + "parentesco= ? "
                + "WHERE id_parentesco= ? ";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setString(1, parent.getParentesco());
        pstmt.setInt(2, parent.getId());
        
        pstmt.executeUpdate();
        
    }
    
    public void deleteParentesco (Integer id) throws SQLException{
        
        String sql;
        sql = "DELETE FROM parentesco "
                + "WHERE id_parentesco= ? ";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setInt(1, id);
        
        pstmt.executeUpdate();
    }
}
