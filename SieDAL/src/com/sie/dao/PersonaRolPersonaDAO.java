/**
 * @author B13rayan
 * @date   21-may-2018
 * @time   0:06:32 
 */

package com.sie.dao;

import com.sie.dao.util.Conexion;
import com.sie.dto.PersonaRolPersona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaRolPersonaDAO {

    private PersonaRolPersona prp;
    private Connection link;
    private PreparedStatement pstmt = null;  


    public PersonaRolPersonaDAO() throws SQLException{
        
        Conexion con = new Conexion();
        link = con.conectar();
    }
    
     public List<PersonaRolPersona> getRolPersona () throws SQLException{
        
        String sql;
        sql = "SELECT id_persona_x_rol,fk_id_rol_persona,fk_id_persona"
            +"FROM persona_x_rol_persona";
        
        
        pstmt = this.link.prepareStatement(sql);
        
        ResultSet rs = pstmt.executeQuery();
        
        List<PersonaRolPersona> list = new ArrayList<PersonaRolPersona>();
        prp = null;
        
        while(rs.next()){
            
            prp = new PersonaRolPersona();
            prp.setId(rs.getInt("id_persona_x_rol"));
            prp.setIdrolpersona(rs.getInt("fk_id_rol_persona"));
            prp.setIdpersona(rs.getInt("fk_id_persona"));
            
            list.add(prp);
            
        }
        
        return list;
    }
    
    public void insertRolPersona(PersonaRolPersona rolperson) throws SQLException{
        
        String sql;
        sql = "INSERT INTO persona_x_rol_persona "
                + "(fk_id_rol_persona,fk_id_persona) "
                + "VALUES (?,?)";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setInt(1, rolperson.getIdrolpersona());
        pstmt.setInt(2, rolperson.getIdpersona());
        
        pstmt.executeQuery();
        
    }
    
     public void updateRolPersona(PersonaRolPersona rolperson) throws SQLException{
        
        String sql;
        sql = "UPDATE persona_x_rol_persona SET"
                + "fk_id_rol_persona = ? ,"
                +"fk_id_persona= ? "
                + "WHERE id_persona_x_rol = ? ";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setInt(1, rolperson.getIdrolpersona());
        pstmt.setInt(2, rolperson.getIdpersona());
        pstmt.setInt(3, rolperson.getId());
        
        pstmt.executeUpdate();
        
    }
    
    public void deleteRolPersona(Integer idrp) throws SQLException{
        
        String sql;
        sql = "DELETE FROM persona_x_rol_persona"
                + "WHERE id_persona_x_rol = ? ";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setInt(1, idrp);
        
        pstmt.executeUpdate();
        
    }
    
}
