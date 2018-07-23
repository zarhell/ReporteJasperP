/**
 * @author B13rayan
 * @date   20-may-2018
 * @time   17:49:55 
 */

package com.sie.dao;

import com.sie.dao.util.Conexion;
import com.sie.dto.GrupoEmpresarial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GrupoEmpresarialDAO {

    private GrupoEmpresarial gp;
    private Connection link;
    private PreparedStatement pstmt = null;    

    public GrupoEmpresarialDAO() throws SQLException{
        
        Conexion con = new Conexion();
        link = con.conectar();
    }
    
    public List<GrupoEmpresarial> getContrato () throws SQLException{
        
        String sql;
        sql = "SELECT id_grupo, nombre_grupo, nit_grupo_empresarialcol, responsable, telefono "
                + "FROM grupo_empresarial";
        
        pstmt = this.link.prepareStatement(sql);
        
        ResultSet rs = pstmt.executeQuery();
        
        List<GrupoEmpresarial> list = new ArrayList<GrupoEmpresarial>();
        gp = null;
        
        while(rs.next()){
            
            gp = new GrupoEmpresarial();
            gp.setIdGrupo(rs.getInt("id_grupo"));
            gp.setNombre(rs.getString("nombre_grupo"));
            gp.setNitgrupo(rs.getInt("nit_grupo_empresarialcol"));
            gp.setResponsable(rs.getString("responsable"));
            gp.setTelefono(rs.getInt("telefono"));
            
            list.add(gp);
                    
        }
        
        return list;
    }
    
    public List<GrupoEmpresarial> getContratoNit (Integer nit) throws SQLException{
        
        String sql;
        sql = "SELECT id_grupo, nombre_grupo, nit_grupo_empresarialcol, responsable, telefono "
                + "FROM grupo_empresarial"
                + "WHERE nit_grupo_empresarialcol = ? ";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setInt(1, nit);
        
        ResultSet rs = pstmt.executeQuery();
        
        List<GrupoEmpresarial> list = new ArrayList<GrupoEmpresarial>();
        gp = null;
        
        while(rs.next()){
            
            gp = new GrupoEmpresarial();
            gp.setIdGrupo(rs.getInt("id_grupo"));
            gp.setNombre(rs.getString("nombre_grupo"));
            gp.setNitgrupo(rs.getInt("nit_grupo_empresarialcol"));
            gp.setResponsable(rs.getString("responsable"));
            gp.setTelefono(rs.getInt("telefono"));
            
            list.add(gp);
                    
        }
        
        return list;
    }
    
    public void insertGrupoEmpresarial(GrupoEmpresarial grupo) throws SQLException{
        
        String sql;
        sql = "INSERT INTO grupo_empresarial"
                + "(nombre_grupo, nit_grupo_empresarialcol, responsable, telefono) "
                + "VALUES "
                + "(?,?,?,?)";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setString(1, grupo.getNombre());
        pstmt.setInt(2, grupo.getNitgrupo());
        pstmt.setString(3, grupo.getResponsable());
        pstmt.setInt(4, grupo.getTelefono());
        
        pstmt.executeQuery();
    }
    
    public void updateGrupoEmpresarial(GrupoEmpresarial grupo) throws SQLException{
        
        String sql;
        sql = "UPDATE grupo_empresarial SET "
                + "nombre_grupo= ? ,"
                + "nit_grupo_empresarialcol= ? ,"
                + "responsable= ? ,"
                + "telefono= ? "
                + "WHERE id_grupo= ? ";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setString(1, grupo.getNombre());
        pstmt.setInt(2, grupo.getNitgrupo());
        pstmt.setString(3, grupo.getResponsable());
        pstmt.setInt(4, grupo.getTelefono());
        pstmt.setInt(5, grupo.getIdGrupo());
        
        pstmt.executeUpdate();
    }
    
    public void deleteGrupoEmpresarial(Integer grupo) throws SQLException{
        
        String sql;
        sql = "DELETE FROM grupo_empresarial WHERE id_grupo= ? ";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setInt(1, grupo);
        
        pstmt.executeUpdate();
    }
}
