package com.sales.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Antony
 */
public class Conexion {
    Connection cnx = null;
    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://LAPTOP-EVMMCIJS:1433;databaseName=SistemaVentas;user=SistemaVentas;password=SistemaVentas";
    String user = "SistemaVentas";
    String pass = "SistemaVentas";

    public Connection Conexion(){
        try{
            Class.forName(driver);
            cnx = DriverManager.getConnection(url, user, pass);
        }
        catch (ClassNotFoundException | SQLException e){
            System.out.println("Sin conexion" + e);
        }
        return cnx;
    }
}
