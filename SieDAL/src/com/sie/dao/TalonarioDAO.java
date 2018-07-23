/**
 * @author B13rayan
 * @date   22-may-2018
 * @time   17:43:46 
 */

package com.sie.dao;

import com.sie.dao.util.Conexion;
import com.sie.dto.Talonario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TalonarioDAO {

    private Talonario talonario;
    private Connection link;
    private PreparedStatement ptlmt = null;  

    public TalonarioDAO() throws SQLException{
        
        Conexion con = new Conexion();
        link = con.conectar();
    }

 public List<Talonario> getTalonario () throws SQLException{
        
        String sql;
        sql = "SELECT id_talonario, fk_funcionario,fecha_creacion,cantidad "
                + "FROM talonario";
        
        ptlmt = this.link.prepareStatement(sql);
        
        ResultSet rs = ptlmt.executeQuery();
        
        List<Talonario> litl = new ArrayList<Talonario>();
        talonario = null;
        
        while(rs.next()){
            
            talonario = new Talonario();
            talonario.setId(rs.getInt("id_talonario"));
            talonario.setIdfuncionario(rs.getInt("fk_funcionario"));
            talonario.setFechacreacion(rs.getTimestamp("fecha_creacion"));
            talonario.setCantidad(rs.getInt("cantidad"));
            
            litl.add(talonario);
            
        }
        
        return litl;
    }
    
    public void insertTalonario(Talonario tl) throws SQLException{
        
        String sql;
        sql = "INSERT INTO talonario "
                + "(fk_funcionario,fecha_creacion,cantidad) "
                + "VALUES (?,?,?)";
        
        ptlmt = this.link.prepareStatement(sql);
        ptlmt.setInt(1, tl.getIdfuncionario());
        ptlmt.setTimestamp(2,tl.getFechacreacion());
        ptlmt.setInt(3,tl.getCantidad());
        
        ptlmt.executeQuery();
        
    }

    
    public void updateTalonario(Talonario tl) throws SQLException{
        
        String sql;
        sql = "UPDATE talonario SET"
                + "fk_funcionario= ? ,"
                + "fecha_creacion = ?,"
                + "cantidad = ? ,"
                + "WHERE id_talonario = ?";
        
        ptlmt = this.link.prepareStatement(sql);
        ptlmt.setInt(1, tl.getIdfuncionario());
        ptlmt.setTimestamp(2,tl.getFechacreacion());
        ptlmt.setInt(3,tl.getCantidad());
        ptlmt.setInt(4,tl.getId());
        
        ptlmt.executeUpdate();
        
    }//
  
    public void deleteTalonario(Integer id) throws SQLException{
        
        String sql;
        sql = "DELETE FROM talonario"
                + "WHERE id_talonario = ?";
        
        ptlmt = this.link.prepareStatement(sql);
        ptlmt.setInt(1, id);
        
        ptlmt.executeUpdate();
        
    }

}













