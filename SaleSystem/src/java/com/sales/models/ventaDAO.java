package com.sales.models;

import com.sales.config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Antony
 */
public class ventaDAO {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public String generarSerie(){
        String numeroSerie = "";
        String sql = "select max(NumeroSerie) from ventas";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                numeroSerie = rs.getString(1);
            }
        }
        catch(Exception e){
            
        }
        return numeroSerie;
    }
}
