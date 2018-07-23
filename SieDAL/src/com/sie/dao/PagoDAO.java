/**
 * @author B13rayan
 * @date   20-may-2018
 * @time   21:08:54 
 */

package com.sie.dao;

import com.sie.dao.util.Conexion;
import com.sie.dto.Pago;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PagoDAO {

    private Pago pago;
    private Connection link;
    private PreparedStatement pstmt = null; 

    public PagoDAO() throws SQLException{
        
        Conexion con = new Conexion();
        link = con.conectar();
    }
    
    public List<Pago> getPago () throws SQLException{
        
        String sql;
        sql = "SELECT id_pago, valor_pago, fecha_oportuna_pago, fecha_maxima_pago, fecha_pago, fk_contrato "
                + "FROM pago )";
        
        pstmt = this.link.prepareStatement(sql);
        
        ResultSet rs = pstmt.executeQuery();
        
        List<Pago> list = new ArrayList<Pago>();
        pago = null;
        
        while(rs.next()){
            
            pago = new Pago();
            pago.setId(rs.getInt("id_pago"));
            pago.setValorpago(rs.getInt("valor_pago"));
            pago.setFechaoportunapago(rs.getTimestamp("fecha_oportuna_pago"));
            pago.setFechamaximapago(rs.getTimestamp("fecha_maxima_pago"));
            pago.setFechapago(rs.getTimestamp("fecha_pago"));
            pago.setIdcontrato(rs.getInt("fk_contrato"));
            
            list.add(pago);
            
        }
        
        return list;
    }
    
    public List<Pago> getPagoContrato (Integer idpago) throws SQLException{
        
        String sql;
        sql = "SELECT id_pago, valor_pago, fecha_oportuna_pago, fecha_maxima_pago, fecha_pago, fk_contrato "
                + "FROM pago "
                + "WHERE fk_contrato = ?)";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setInt(1, idpago);
        
        ResultSet rs = pstmt.executeQuery();
        
        List<Pago> list = new ArrayList<Pago>();
        pago = null;
        
        while(rs.next()){
            
            pago = new Pago();
            pago.setId(rs.getInt("id_pago"));
            pago.setValorpago(rs.getInt("valor_pago"));
            pago.setFechaoportunapago(rs.getTimestamp("fecha_oportuna_pago"));
            pago.setFechamaximapago(rs.getTimestamp("fecha_maxima_pago"));
            pago.setFechapago(rs.getTimestamp("fecha_pago"));
            pago.setIdcontrato(rs.getInt("fk_contrato"));
            
            list.add(pago);
            
        }
        
        return list;
    }
    
    public void insertPago (Pago pg) throws SQLException{
        
        String sql;
        sql = "INSERT INTO pago"
                + "(valor_pago, fecha_oportuna_pago, fecha_maxima_pago, fecha_pago, fk_contrato) "
                + "VALUES "
                + "(?,?,?,?,?)";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setInt(1, pg.getValorpago());
        pstmt.setTimestamp(2, pg.getFechaoportunapago());
        pstmt.setTimestamp(3, pg.getFechamaximapago());
        pstmt.setTimestamp(4, pg.getFechapago());
        pstmt.setInt(5, pg.getIdcontrato());
        
        pstmt.executeQuery();
    }
    
    public void updatePago (Pago pg) throws SQLException{
        
        String sql;
        sql = "UPDATE pago SET "
                + "valor_pago= ? ,"
                + "fecha_oportuna_pago= ? ,"
                + "fecha_maxima_pago= ? ,"
                + "fecha_pago= ? ,"
                + "fk_contrato= ? "
                + "WHERE id_pago= ? ";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setInt(1, pg.getValorpago());
        pstmt.setTimestamp(2, pg.getFechaoportunapago());
        pstmt.setTimestamp(3, pg.getFechamaximapago());
        pstmt.setTimestamp(4, pg.getFechapago());
        pstmt.setInt(5, pg.getIdcontrato());
        pstmt.setInt(6, pg.getId());
        
        pstmt.executeUpdate();
    }
    
    public void deletePago (Integer id) throws SQLException{
        
        String sql;
        sql = "DELETE FROM pago"
                + "WHERE id_pago= ? ";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setInt(1, id);
        
        pstmt.executeUpdate();
    }
}
