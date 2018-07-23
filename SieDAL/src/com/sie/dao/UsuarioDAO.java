/**
 * @author B13rayan
 * @date   27-may-2018
 * @time   12:27:30
 */

package com.sie.dao;

import com.sie.dao.util.Conexion;
import com.sie.dto.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDAO {

    private Usuario user;
    private Connection link;
    private PreparedStatement pstmt = null;
    
    public UsuarioDAO()throws SQLException{
    
        Conexion con = new Conexion();
        link = con.conectar();
    }
    
    public List<Usuario> getUsuario() throws SQLException{
    
        String sql;
        sql = "SELECT id_usuario, nombre, contrasena, fk_persona "
                + "FROM usuarios";
        
        pstmt = this.link.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        
        List<Usuario> list = new ArrayList<Usuario>();
        user = null;
        
        while(rs.next()){
            
            user = new Usuario();
            user.setId(rs.getInt("id_usuario"));
            user.setNombre(rs.getString( "nombre"));
            user.setContraseña(rs.getString("contrasena"));
            user.setFk_persona(rs.getInt("fk_persona"));
            
            list.add(user);                       
        }
        
        return list; 
    }

    public void insertUsuario(Usuario usr,Integer idn) throws SQLException{
        
        String sql;
        
        sql = "SELECT id_Persona"
                + "FROM usuarios"
                + "WHERE identificacion = ?";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setInt(1,idn);
        
        ResultSet rs = pstmt.executeQuery();
        
        Integer idperson = 0;
        
        while(rs.next()){
            
            idperson = (rs.getInt("id_Persona"));
        
        }
               
        
        sql = "INSERT INTO usuarios"
                + "(nombre, contrasena, fk_persona) "
                + "VALUES "
                + "(?,?,?)";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setString(1,usr.getNombre());
        pstmt.setString(2,usr.getContraseña());
        pstmt.setInt(3,idperson);
        
        pstmt.execute();       
                        
    }
    
    public void updatePersonas(Usuario usr) throws SQLException{
        
        String sql;
        sql = "UPDATE usuarios SET "
                + "contrasena = ?"
                + "WHERE id_Persona= ?";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setString(1,usr.getContraseña());
        pstmt.setInt(2,usr.getId());        
        
        pstmt.executeUpdate();                
        
    }
    
}
