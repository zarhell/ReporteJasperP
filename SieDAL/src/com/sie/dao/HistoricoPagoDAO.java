/**
 * @author B13rayan
 * @date   20-may-2018
 * @time   19:48:46 
 */

package com.sie.dao;

import com.sie.dao.util.Conexion;
import com.sie.dto.HistoricoPago;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HistoricoPagoDAO {

    private HistoricoPago hp;
    private Connection link;
    private PreparedStatement pstmt = null;  

    public HistoricoPagoDAO() throws SQLException{
        
        Conexion con = new Conexion();
        link = con.conectar();
    }
    
    public List<HistoricoPago> getHistoricoPago (Integer nit) throws SQLException{
        
        String sql;
        sql = "SELECT id_historico_pago, fk_pago, contrato, valor_pago, fecha_oportuna_pago, fecha_maxima_pago, fecha_pago "
                + "FROM historico_pago";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setInt(1, nit);
        
        ResultSet rs = pstmt.executeQuery();
        
        List<HistoricoPago> list = new ArrayList<HistoricoPago>();
        hp = null;
        
        while(rs.next()){
            
            hp = new HistoricoPago();
            hp.setId(rs.getInt("id_historico_pago"));
            hp.setPago(rs.getInt("fk_pago"));
            hp.setContrato(rs.getInt("contrato"));
            hp.setValorpago(rs.getInt("valor_pago"));
            hp.setFechaoportunapago(rs.getTimestamp("fecha_oportuna_pago"));
            hp.setFechamaximapago(rs.getTimestamp("fecha_maxima_pago"));
            hp.setFechapago(rs.getTimestamp("fecha_pago"));
            
            list.add(hp);
            
        }
        
        return list;
    }
    
    public void insertHistoricoPago (HistoricoPago histpago) throws SQLException{
        
        String sql;
        sql = "INSERT INTO historico_pago"
                + "(fk_pago, contrato, valor_pago, fecha_oportuna_pago, fecha_maxima_pago, fecha_pago) "
                + "VALUES "
                + "(?,?,?,?,?,?)";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setInt(1, histpago.getPago());
        pstmt.setInt(2, histpago.getContrato());
        pstmt.setInt(3, histpago.getValorpago());
        pstmt.setTimestamp(4, histpago.getFechaoportunapago());
        pstmt.setTimestamp(5, histpago.getFechamaximapago());
        pstmt.setTimestamp(6, histpago.getFechapago());
        
        pstmt.executeQuery();
    }
    
    public void updateHistoricoPago (HistoricoPago histpago) throws SQLException{
        
        String sql;
        sql = "UPDATE historico_pago SET "
                + "fk_pago= ? ,"
                + "contrato= ? ,"
                + "valor_pago= ? ,"
                + "fecha_oportuna_pago= ? ,"
                + "fecha_maxima_pago= ? ,"
                + "fecha_pago= ? "
                + "WHERE id_historico_pago= ?";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setInt(1, histpago.getPago());
        pstmt.setInt(2, histpago.getContrato());
        pstmt.setInt(3, histpago.getValorpago());
        pstmt.setTimestamp(4, histpago.getFechaoportunapago());
        pstmt.setTimestamp(5, histpago.getFechamaximapago());
        pstmt.setTimestamp(6, histpago.getFechapago());
        pstmt.setInt(7, histpago.getId());
        
        pstmt.executeUpdate();
    }
    
    public void deleteHistoricoPago (Integer id) throws SQLException{
        
        String sql;
        sql = "DELETE FROM historico_pago WHERE id_historico_pago = ?";
        
        pstmt = this.link.prepareStatement(sql);
        pstmt.setInt(1, id);
        
        pstmt.executeUpdate();
    }
}
