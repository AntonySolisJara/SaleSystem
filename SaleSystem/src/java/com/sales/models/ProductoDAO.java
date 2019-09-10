package com.sales.models;

import com.sales.config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Antony
 */
public class ProductoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public ProductoModel listarId(int IdProducto){
        ProductoModel product = new ProductoModel();
        String sql = "select * from producto where IdProducto =" + IdProducto;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                product.setDescr(rs.getString("Descripcion"));
                product.setPrec(rs.getDouble("Precio"));
                product.setStk(rs.getInt("Stock"));
            }
        }
        catch(Exception e){
            
        }
        return product;
    }
}
