/**
 * @author B13rayan
 * @date   20-may-2018
 * @time   15:15:18 
 */

package com.sie.dao;

import com.sie.dao.util.Conexion;
import com.sie.dto.ContratoPlan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContratoPlanDAO {

    private ContratoPlan contratoplan;
    private Connection link;
    private PreparedStatement pstmt = null;
    
    public ContratoPlanDAO() throws SQLException{
        
        Conexion con = new Conexion();
        link = con.conectar();
    }

    public List<ContratoPlan> getContratoPlan() throws SQLException{
        
        String sql;
        sql = "SELECT id_contrato_x_plan, periodicidad_pago, fk_contrato, fk_plan FROM contrato_x_plan";
        
        pstmt = this.link.prepareStatement(sql);
        
        ResultSet rs = pstmt.executeQuery();
        
        List<ContratoPlan> list = new ArrayList<ContratoPlan>();
        contratoplan = null;
        
        while(rs.next()){
            
            contratoplan = new ContratoPlan();
            contratoplan.setId(rs.getInt("id_contrato_x_plan"));
            contratoplan.setPeriodicidad(rs.getString("periodicidad_pago"));
            contratoplan.setIdcontrato(rs.getInt("fk_contrato"));
            contratoplan.setIdplan(rs.getInt("fk_plan"));
            
            list.add(contratoplan);
                    
        }
        
        return list;
    }
    
    public List<ContratoPlan> getContratoPlanContrato(Integer contrato) throws SQLException{
        
        String sql;
        sql = "SELECT id_contrato_x_plan, periodicidad_pago, fk_contrato, fk_plan "
                + "FROM contrato_x_plan"
                + "WHERE fk_contrato = ? ";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setInt(1, contrato);
        
        ResultSet rs = pstmt.executeQuery();
        
        List<ContratoPlan> list = new ArrayList<ContratoPlan>();
        contratoplan = null;
        
        while(rs.next()){
            
            contratoplan = new ContratoPlan();
            contratoplan.setId(rs.getInt("id_contrato_x_plan"));
            contratoplan.setPeriodicidad(rs.getString("periodicidad_pago"));
            contratoplan.setIdcontrato(rs.getInt("fk_contrato"));
            contratoplan.setIdplan(rs.getInt("fk_plan"));
            
            list.add(contratoplan);
                    
        }
        
        return list;
    }
    
    public void insertContratoPlan(ContratoPlan conplan) throws SQLException{
    
        String sql;
        sql = "INSERT INTO contrato_x_plan"
                + "(periodicidad_pago, fk_contrato, fk_plan) "
                + "VALUES "
                + "(?,?,?)";
        
        pstmt = link.prepareStatement(sql);
        pstmt.setString(1, conplan.getPeriodicidad());
        pstmt.setInt(2, conplan.getIdcontrato());
        pstmt.setInt(3, conplan.getIdplan());
        
        pstmt.execute();
    }
    
    public void updateContratoPlan(ContratoPlan conplan) throws SQLException{
    
        String sql;
        sql = "UPDATE contrato_x_plan SET "
                + "periodicidad_pago= ? ,"
                + "fk_contrato= ? ,"
                + "fk_plan= ? "
                + "WHERE id_contrato_x_plan= ? ";
        
        pstmt = link.prepareStatement(sql);
        pstmt.setString(1, conplan.getPeriodicidad());
        pstmt.setInt(2, conplan.getIdcontrato());
        pstmt.setInt(3, conplan.getIdplan());
        pstmt.setInt(4, conplan.getId());
        
        pstmt.executeUpdate();
    }
    
    public void deleteContratoPlan(Integer idcontrato) throws SQLException{
    
        String sql;
        sql = "DELETE FROM contrato_x_plan "
                + "WHERE id_contrato_x_plan = ? ";
        
        pstmt = link.prepareStatement(sql);
        pstmt.setInt(1, idcontrato);
        
        pstmt.executeUpdate();
    }
}
