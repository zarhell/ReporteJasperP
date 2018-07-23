/**
 * @author B13rayan
 * @date   19-may-2018
 * @time   22:12:44 
 */

package com.sie.dao;

import com.sie.dao.util.Conexion;
import com.sie.dto.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {

    private Persona persona;
    private Connection link;
    private PreparedStatement pstmt = null;
    
    public PersonaDAO()throws SQLException{
    
        Conexion con = new Conexion();
        link = con.conectar();
    }
    
    public List<Persona> getPersonas() throws SQLException{
        
        String sql;
        sql = "select * from persona";
        
        pstmt = this.link.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        
        List<Persona> list = new ArrayList<Persona>();
        persona = null;
        
        while(rs.next()){
            
            persona = new Persona();
            persona.setId(rs.getInt("id_Persona"));
            persona.setNombre(rs.getString( "nombre"));
            persona.setApellido(rs.getString("apellido"));
            persona.setIdentificacion(rs.getInt("identificacion"));
            persona.setFechanacimiento(rs.getTimestamp("fecha_nacimiento"));
            persona.setTelefono(rs.getString("telefono"));
            persona.setCelular(rs.getString("celular"));
            persona.setDireccion(rs.getString("direccion"));
            persona.setEmail(rs.getString("email"));
            persona.setGenero(rs.getString("genero"));
            
            list.add(persona);                       
        }
        
        return list; 
    }    
    
    public List<Persona> getPersonasIdentificacion(Integer identificacion) throws SQLException{
        
        String sql;
        sql = "select * from persona where identificacion = ?";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setInt(1, identificacion);
        
        ResultSet rs = pstmt.executeQuery();
        
        List<Persona> list = new ArrayList<Persona>();
        persona = null;
        
        while(rs.next()){
            
            persona = new Persona();
            persona.setId(rs.getInt("id_Persona"));
            persona.setNombre(rs.getString( "nombre"));
            persona.setApellido(rs.getString("apellido"));
            persona.setIdentificacion(rs.getInt("identificacion"));
            persona.setFechanacimiento(rs.getTimestamp("fecha_nacimiento"));
            persona.setTelefono(rs.getString("telefono"));
            persona.setCelular(rs.getString("celular"));
            persona.setDireccion(rs.getString("direccion"));
            persona.setEmail(rs.getString("email"));
            persona.setGenero(rs.getString("genero"));
                        
            list.add(persona);                       
        }
        
        return list; 
    }    
    
    public List<Persona> getPersonasNombre(String nombre) throws SQLException{
        
        String sql;
        sql = "select * from persona where nombre like ?";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setString(1,"%"+nombre+"%");        
        
        ResultSet rs = pstmt.executeQuery();
        
        List<Persona> list = new ArrayList<Persona>();
        persona = null;
        
        while(rs.next()){
            
            persona = new Persona();
            persona.setId(rs.getInt("id_Persona"));
            persona.setNombre(rs.getString( "nombre"));
            persona.setApellido(rs.getString("apellido"));
            persona.setIdentificacion(rs.getInt("identificacion"));
            persona.setFechanacimiento(rs.getTimestamp("fecha_nacimiento"));
            persona.setTelefono(rs.getString("telefono"));
            persona.setCelular(rs.getString("celular"));
            persona.setDireccion(rs.getString("direccion"));
            persona.setEmail(rs.getString("email"));
            persona.setGenero(rs.getString("genero"));
            
            list.add(persona);                       
        }
        
        return list; 
    }    
    
    public void insertPersonas(Persona person) throws SQLException{
        
        String sql;
        sql = "INSERT INTO persona"
                + "(nombre, apellido, identificacion, fecha_nacimiento, telefono, celular, direccion, email, genero) "
                + "VALUES "
                + "(?,?,?,?,?,?,?,?,?)";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setString(1,person.getNombre());
        pstmt.setString(2,person.getApellido());
        pstmt.setInt(3,person.getIdentificacion());
        pstmt.setTimestamp(4,person.getFechanacimiento());
        pstmt.setString(5,person.getTelefono());
        pstmt.setString(6,person.getCelular());
        pstmt.setString(7,person.getDireccion());
        pstmt.setString(8,person.getEmail());
        pstmt.setString(9,person.getGenero());
        
        pstmt.execute();       
                        
    }
    
    public void updatePersonas(Persona person) throws SQLException{
        
        String sql;
        sql = "UPDATE persona SET "
                + "nombre= ? ,"
                + "apellido= ? ,"
                + "identificacion= ? ,"
                + "fecha_nacimiento= ? ,"
                + "telefono= ? ,"
                + "celular= ? ,"
                + "direccion= ? ,"
                + "email= ? ,"
                + "genero= ? "
                + "WHERE id_Persona= ?";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setString(1,person.getNombre());
        pstmt.setString(2,person.getApellido());
        pstmt.setInt(3,person.getIdentificacion());
        pstmt.setTimestamp(4,person.getFechanacimiento());
        pstmt.setString(5,person.getTelefono());
        pstmt.setString(6,person.getCelular());
        pstmt.setString(7,person.getDireccion());
        pstmt.setString(8,person.getEmail());
        pstmt.setString(9,person.getGenero());
        pstmt.setInt(10,person.getId());
        
        pstmt.executeUpdate();                
        
    }
        
    public void deletePersonas(Integer id) throws SQLException{
        
        String sql;
        sql = "DELETE FROM persona WHERE id_Persona = ?";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setInt(1,id);
        
        pstmt.executeUpdate();       
                        
    }    
   
}

