/**
 * @author B13rayan
 * @date   22-may-2018
 * @time   13:43:46 
 */

package com.sie.dao;

import com.sie.dao.util.Conexion;
import com.sie.dto.Stoke;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StokeDAO {

    private Stoke stoke;
    private Connection link;
    private PreparedStatement pstmt = null;  

    public StokeDAO() throws SQLException{
        
        Conexion con = new Conexion();
        link = con.conectar();
    }
    
    
 public List<Stoke> getStoke () throws SQLException{
        
        String sql;
        sql = "SELECT idStoke,nombre,descripcion,cantidad,fk_sede"
                + "FROM stoke";
        
        pstmt = this.link.prepareStatement(sql);
        
        ResultSet rs = pstmt.executeQuery();
        
        List<Stoke> list = new ArrayList<Stoke>();
        stoke = null;
        
        while(rs.next()){
            
            stoke = new Stoke();
            stoke.setId(rs.getInt("idStoke"));
            stoke.setNombre(rs.getString("nombre"));
            stoke.setDescripcion(rs.getString("descripcion"));
            stoke.setCantidad(rs.getInt("cantidad"));
            stoke.setIdsede(rs.getInt("fk_sede"));
            
            list.add(stoke);
            
        }
        
        return list;
    }
    
    public void insertStoke(Stoke st) throws SQLException{
        
        String sql;
        sql = "INSERT INTO stoke "
                + "(nombre,descripcion,cantidad,fk_sede) "
                + "VALUES (?,?,?,?)";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setString(1, st.getNombre());
        pstmt.setString(2,st.getDescripcion());
        pstmt.setInt(3,st.getCantidad());
		pstmt.setInt(4,st.getIdsede());
        
        pstmt.executeQuery();
        
    }

    
    public void updateStoke(Stoke st) throws SQLException{
        
        String sql;
        sql = "UPDATE stoke SET"
                + "nombre= ? ,"
                + "descripcion = ?,"
                + "cantidad = ? ,"
                + "fk_sede = ?"
                + "WHERE idStoke = ?";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setString(1, st.getNombre());
        pstmt.setString(2,st.getDescripcion());
        pstmt.setInt(3,st.getCantidad());
		pstmt.setInt(4,st.getIdsede());
		pstmt.setInt(5,st.getId());
        
        pstmt.executeUpdate();
        
    }//
  
    public void deleteStoke(Integer id) throws SQLException{
        
        String sql;
        sql = "DELETE FROM stoke"
                + "WHERE idStoke = ?";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setInt(1, id);
        
        pstmt.executeUpdate();
        
    }

}
