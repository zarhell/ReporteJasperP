/**
 * @author B13rayan
 * @date   20-may-2018
 * @time   20:29:25 
 */

package com.sie.dao;

import com.sie.dao.util.Conexion;
import com.sie.dto.HistoricoStoke;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HistoricoStokeDAO {

    private HistoricoStoke hs;
    private Connection link;
    private PreparedStatement pstmt = null; 

    public HistoricoStokeDAO() throws SQLException{
        
        Conexion con = new Conexion();
        link = con.conectar();
    }
    
    public List<HistoricoStoke> getHistoricoStoke() throws SQLException{
        
        String sql;
        sql = "SELECT idHistoricoStoke, nombre, descripcion, cantidad, fecha_modificado, fk_stoke "
                + "FROM historico_stoke";
        
        pstmt = this.link.prepareStatement(sql);
        
        ResultSet rs = pstmt.executeQuery();
        
        List<HistoricoStoke> list = new ArrayList<HistoricoStoke>();
        hs = null;
        
        while(rs.next()){
            
            hs = new HistoricoStoke();
            hs.setIdhistorico(rs.getInt("idHistoricoStoke"));
            hs.setNombre(rs.getString("nombre"));
            hs.setDescripcion(rs.getString("descripcion"));
            hs.setCantidad(rs.getInt("cantidad"));
            hs.setFechamodificado(rs.getTimestamp("fecha_modificado"));
            hs.setIdstoke(rs.getInt("fk_stoke"));            
            
            list.add(hs);
                    
        }
        
        return list;
    }
    
    public void insertHistoricoStoke(HistoricoStoke historico) throws SQLException{
        
        String sql;
        sql = "INSERT INTO historico_stoke"
                + "(nombre, descripcion, cantidad, fecha_modificado, fk_stoke) "
                + "VALUES "
                + "(?,?,?,?,?)";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setString(1, historico.getNombre());
        pstmt.setString(2, historico.getDescripcion());
        pstmt.setInt(3, historico.getCantidad());
        pstmt.setTimestamp(4, historico.getFechamodificado());
        pstmt.setInt(5, historico.getIdstoke());
        
        pstmt.executeQuery();
    }
    
    public void updateHistoricoStoke(HistoricoStoke historico) throws SQLException{
        
        String sql;
        sql = "UPDATE historico_stoke SET "
                + "nombre= ? ,"
                + "descripcion= ? ,"
                + "cantidad= ? ,"
                + "fecha_modificado= ? ,"
                + "fk_stoke= ? "
                + "WHERE idHistoricoStoke= ? ";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setString(1, historico.getNombre());
        pstmt.setString(2, historico.getDescripcion());
        pstmt.setInt(3, historico.getCantidad());
        pstmt.setTimestamp(4, historico.getFechamodificado());
        pstmt.setInt(5, historico.getIdstoke());
        pstmt.setInt(6, historico.getIdhistorico());
        
        pstmt.executeUpdate();
    }
    
    public void deleteHistoricoStoke(Integer id) throws SQLException{
        
        String sql;
        sql = "DELETE FROM historico_stoke"
                + "WHERE idHistoricoStoke= ? ";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setInt(1, id);
        
        pstmt.executeUpdate();
    }
    
}
