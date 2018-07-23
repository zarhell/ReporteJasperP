/**
 * @author B13rayan
 * @date   22-may-2018
 * @time   13:43:46 
 */

package com.sie.dao;

import com.sie.dao.util.Conexion;
import com.sie.dto.Sede;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SedeDAO {

    private Sede sede;
    private Connection link;
    private PreparedStatement pstmt = null;  

    public SedeDAO() throws SQLException{
        
        Conexion con = new Conexion();
        link = con.conectar();
    }
    
    
 public List<Sede> getSede () throws SQLException{
        
        String sql;
        sql = "SELECT id_sede,nombre,telefono1,telefono2"
                + "FROM sede";
        
        pstmt = this.link.prepareStatement(sql);
        
        ResultSet rs = pstmt.executeQuery();
        
        List<Sede> list = new ArrayList<Sede>();
        sede = null;
        
        while(rs.next()){
            
            sede = new Sede();
            sede.setId(rs.getInt("id_sede"));
            sede.setNombre(rs.getString("nombre"));
            sede.setTelefono1(rs.getInt("telefono1"));
            sede.setTelefono2(rs.getInt("telefono2"));
            
            list.add(sede);
            
        }
        
        return list;
    }
    
    public void insertSede(Sede sd) throws SQLException{
        
        String sql;
        sql = "INSERT INTO sede "
                + "(nombre,telefono1,telefono2) "
                + "VALUES (?,?,?)";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setString(1, sd.getNombre());
        pstmt.setInt(2,sd.getTelefono1());
        pstmt.setInt(3,sd.getTelefono1());
        
        pstmt.executeQuery();
        
    }

    
    public void updateSede(Sede sd) throws SQLException{
        
        String sql;
        sql = "UPDATE sede SET"
                + "nombre = ? "
                + "telefono1 = ? "
                + "telefono2= ? "
                + "WHERE id_sede = ?";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setString(1, sd.getNombre());
        pstmt.setInt(2,sd.getTelefono1());
        pstmt.setInt(3,sd.getTelefono1());
        pstmt.setInt(4,sd.getId());
        
        pstmt.executeUpdate();
        
    }//
  
    public void deleteSede(Integer id) throws SQLException{
        
        String sql;
        sql = "DELETE FROM sede"
                + "WHERE id_sede = ?";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setInt(1, id);
        
        pstmt.executeUpdate();
        
    }

}
