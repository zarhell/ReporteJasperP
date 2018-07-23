/**
 * @author B13rayan
 * @date   21-may-2018
 * @time   13:40:20 
 */

package com.sie.dao;

import com.sie.dao.util.Conexion;
import com.sie.dto.Plan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlanDAO {

    private Plan plan;
    private Connection link;
    private PreparedStatement pstmt = null;  

    public PlanDAO() throws SQLException{
        
        Conexion con = new Conexion();
        link = con.conectar();
    }
    
    
 public List<Plan> getPlan () throws SQLException{
        
        String sql;
        sql = "SELECT id_plan, nombre_plan, beficiarios_afiliacion "
                + "FROM plan";
        
        pstmt = this.link.prepareStatement(sql);
        
        ResultSet rs = pstmt.executeQuery();
        
        List<Plan> list = new ArrayList<Plan>();
        plan = null;
        
        while(rs.next()){
            
            plan = new Plan();
            plan.setId(rs.getInt("id_plan"));
            plan.setNombre(rs.getString("nombre_plan"));
            plan.setDescripcion(rs.getString("beficiarios_afiliacion"));//renombrar variable en clase Plan
            
            list.add(plan);
            
        }
        
        return list;
    }
    
    public void insertPlan(Plan pl) throws SQLException{
        
        String sql;
        sql = "INSERT INTO plan "
                + "(nombre_plan, beficiarios_afiliacion) "
                + "VALUES (?,?)";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setString(1, pl.getNombre());
        pstmt.setString(2, pl.getDescripcion());
        
        pstmt.executeQuery();
        
    }
    
    public void updatePlan(Plan pl) throws SQLException{
        
        String sql;
        sql = "UPDATE plan SET"
                + "nombre_plan= ?, "
                + "beficiarios_afiliacion= ? "
                + "WHERE id_plan = ?";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setString(1, pl.getNombre());
        pstmt.setString(2, pl.getDescripcion());
        pstmt.setInt(3, pl.getId());
        
        pstmt.executeUpdate();
        
    }//
  
    public void deletePlan(Integer id) throws SQLException{
        
        String sql;
        sql = "DELETE FROM plan"
                + "WHERE id_plan = ?";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setInt(1, id);
        
        pstmt.executeUpdate();
        
    }
 
}














