/**
 * @author B13rayan
 * @date   20-may-2018
 * @time   1:36:50 
 */

package com.sie.dao;

import com.sie.dao.util.Conexion;
import com.sie.dto.InformacionAdicional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InformacionAdicionalDAO {

    private InformacionAdicional informacion;
    private Connection link;
    private PreparedStatement pstmt = null;

     public InformacionAdicionalDAO()throws SQLException{
    
        Conexion con = new Conexion();
        link = con.conectar();
    }
     
     public List<InformacionAdicional> getInformacionPersona(Integer persona) throws SQLException{
        
        String sql;
        sql = "select * from informacion_adicional where fk_persona = ?";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setInt(1,persona);
        
        ResultSet rs = pstmt.executeQuery();
        
        List<InformacionAdicional> list = new ArrayList<InformacionAdicional>();
        informacion = null;
        
        while(rs.next()){
            
            informacion = new InformacionAdicional();
            informacion.setId(rs.getInt("id_Persona"));
            informacion.setFechaingreso(rs.getTimestamp("fecha_ingreso"));
            informacion.setFecharetiro(rs.getTimestamp("fecha_retiro"));
            informacion.setFechadefuncion(rs.getTimestamp("fecha_defuncion"));
            informacion.setEstadocivil(rs.getString("estado_civil"));
            informacion.setProfesion(rs.getString("profesion"));
            informacion.setIdgrupoempresarial(rs.getInt("fk_grupoempresarial"));
            informacion.setIdsede(rs.getInt("fk_sede"));
            informacion.setIdcontrato(rs.getInt("fk_contrato"));
            informacion.setIdpersona(rs.getInt("fk_persona"));
            
            list.add(informacion);                       
        }
        
        return list; 
    }    
     
     public void insertInformacionPersona(InformacionAdicional info) throws SQLException{
        
        String sql;
        sql = "INSERT INTO informacion_adicional"
                + "(fecha_ingreso, fecha_retiro, fecha_defuncion, estado_civil, profesion, fk_grupoempresarial, fk_sede, fk_contrato, fk_persona) "
                + "VALUES "
                + "(?,?,?,?,?,?,?,?,?)";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setTimestamp(1, info.getFechaingreso());
        pstmt.setTimestamp(2, info.getFecharetiro());
        pstmt.setTimestamp(3, info.getFechadefuncion());
        pstmt.setString(4, info.getEstadocivil());
        pstmt.setString(5,info.getProfesion());
        pstmt.setInt(6, info.getIdgrupoempresarial());
        pstmt.setInt(7, info.getIdsede());
        pstmt.setInt(8, info.getIdcontrato());
        pstmt.setInt(9, info.getIdpersona());
        
        pstmt.execute();
       
    }    
     
      public void updateInformacionPersona(InformacionAdicional info) throws SQLException{
        
        String sql;
        sql = "UPDATE informacion_adicional SET "
                + "fecha_ingreso= ? ,"
                + "fecha_retiro= ? ,"
                + "fecha_defuncion= ? ,"
                + "estado_civil= ? ,"
                + "profesion= ? ,"
                + "fk_grupoempresarial= ? ,"
                + "fk_sede= ? ,"
                + "fk_contrato= ? ,"
                + "fk_persona= ? "
                + "WHERE id_informacion_adicional= ? ";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setTimestamp(1, info.getFechaingreso());
        pstmt.setTimestamp(2, info.getFecharetiro());
        pstmt.setTimestamp(3, info.getFechadefuncion());
        pstmt.setString(4, info.getEstadocivil());
        pstmt.setString(5,info.getProfesion());
        pstmt.setInt(6, info.getIdgrupoempresarial());
        pstmt.setInt(7, info.getIdsede());
        pstmt.setInt(8, info.getIdcontrato());
        pstmt.setInt(9, info.getIdpersona());
        pstmt.setInt(10, info.getId());
        
        pstmt.executeUpdate();
       
    }
      
      public void deleteInformacionPersonal(Integer idpersona) throws SQLException{
          
          String sql;
          sql = "DELETE FROM informacion_adicional WHERE fk_persona = ?";
       
          pstmt = this.link.prepareStatement(sql);
          pstmt.setInt(1, idpersona);
          
          pstmt.executeUpdate();
          
      }
      
}
