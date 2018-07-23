/**
 * @author B13rayan
 * @date 19-may-2018
 * @time 19:36:36
 */
package com.sie.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String DATA_BASE = "sie";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private Connection link = null;

    public Conexion() {

    }

    public Connection conectar() throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        String path = URL + DATA_BASE;
        link = DriverManager.getConnection(path, USER, PASSWORD);

        return link;
    }

    public void desconectar() throws SQLException {

        link.close();
    }
}
