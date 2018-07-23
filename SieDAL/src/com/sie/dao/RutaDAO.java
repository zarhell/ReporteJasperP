/**
 * @author B13rayan
 * @date   22-may-2018
 * @time   4:44:46 
 */

package com.sie.dao;

import com.sie.dao.util.Conexion;
import com.sie.dto.Ruta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RutaDAO {

    private Ruta ruta;
    private Connection link;
    private PreparedStatement pstmt = null;  

    public RutaDAO() throws SQLException{
        
        Conexion con = new Conexion();
        link = con.conectar();
    }
    
    
 public List<Ruta> getRuta () throws SQLException{
        
        String sql;
        sql = "SELECT id_ruta,fecha_inicio_ruta,fk_recaudador,fk_director,lista_direcciones"
                + "FROM ruta";
        
        pstmt = this.link.prepareStatement(sql);
        
        ResultSet rs = pstmt.executeQuery();
        
        List<Ruta> list = new ArrayList<Ruta>();
        ruta = null;
        
        while(rs.next()){
            
            ruta = new Ruta();
            ruta.setId(rs.getInt("id_ruta"));
            ruta.setFechainicioruta(rs.getTimestamp("fecha_inicio_ruta"));
            ruta.setIdrecaudador(rs.getInt("fk_recaudador"));
            ruta.setIddirector(rs.getInt("fk_director"));
            ruta.setDirecciones(rs.getString("lista_direcciones"));
            
            list.add(ruta);
            
        }
        
        return list;
    }
    
    public void insertRuta(Ruta pl) throws SQLException{
        
        String sql;
        sql = "INSERT INTO ruta "
                + "(fecha_inicio_ruta,fk_recaudador,fk_director,lista_direcciones) "
                + "VALUES (?,?,?,?)";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setTimestamp(1, pl.getFechainicioruta());
        pstmt.setInt(2,pl.getIdrecaudador());
        pstmt.setInt(3,pl.getIddirector());
        pstmt.setString(4,pl.getDirecciones());
        
        pstmt.executeQuery();
        
    }
    
    
    public void updateRuta(Ruta pl) throws SQLException{
        
        String sql;
        sql = "UPDATE ruta SET"
                + "fecha_inicio_ruta = ? "
                + "fk_recaudador = ? "
                + "fk_director= ? "
                + "lista_direcciones= ? "
                + "WHERE id_ruta = ?";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setTimestamp(1, pl.getFechainicioruta());
        pstmt.setInt(2,pl.getIdrecaudador());
        pstmt.setInt(3,pl.getIddirector());
        pstmt.setString(4,pl.getDirecciones());
        pstmt.setInt(5,pl.getId());
        
        pstmt.executeUpdate();
        
    }//
  
    public void deleteRuta(Integer id) throws SQLException{
        
        String sql;
        sql = "DELETE FROM ruta"
                + "WHERE id_ruta = ?";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setInt(1, id);
        
        pstmt.executeUpdate();
        
    }//prueba

}
