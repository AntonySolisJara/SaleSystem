package com.sales.models;

import com.sales.config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
                product.setEst(rs.getString("Estado"));
            }
        }
        catch(SQLException e){
            
        }
        return product;
    }
    
    public List listar(){
        String sql = "select * from producto";
        List<ProductoModel> lista = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                ProductoModel pm = new ProductoModel();
                pm.setId(rs.getInt(1));
                pm.setDescr(rs.getString(2));
                pm.setPrec(rs.getDouble(3));
                pm.setStk(rs.getInt(4));
                pm.setEst(rs.getString(5));
                lista.add(pm);
            }
        }
        catch(SQLException e){
            
        }
        return lista;
    }
    
    public int agregar(ProductoModel pm){
        String sql = "insert into producto (Descripcion, Precio, Stock, Estado) values(?, ?, ?, ?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pm.getDescr());
            ps.setDouble(2, pm.getPrec());
            ps.setInt(3, pm.getStk());
            ps.setString(4, pm.getEst());
            ps.executeUpdate();
        }
        catch(SQLException e){
            
        }
        return r;
    }
}
