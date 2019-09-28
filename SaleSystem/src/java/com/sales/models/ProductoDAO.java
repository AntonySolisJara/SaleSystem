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
    
    public ProductoModel buscar(String id){
        ProductoModel pm = new ProductoModel();
        String sql = "select * from producto where IdProducto =" + id;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                pm.setId(rs.getInt(1));
                pm.setDescr(rs.getString(2));
                pm.setPrec(rs.getDouble(3));
                pm.setStk(rs.getInt(4));
                pm.setEst(rs.getString(5));
            }
        }
        catch (SQLException ex) {
            
        }
        return pm;
    }
    
    public ProductoModel listarId(int IdProducto){
        ProductoModel product = new ProductoModel();
        String sql = "select * from producto where IdProducto =" + IdProducto;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                product.setId(rs.getInt(1));
                product.setDescr(rs.getString(2));
                product.setPrec(rs.getDouble(3));
                product.setStk(rs.getInt(4));
                product.setEst(rs.getString(5));
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
    
    public int actualizar(ProductoModel pm){
        String sql = "update producto set Descripcion = ?, Precio = ?, Stock = ?, Estado = ? where IdProducto = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pm.getDescr());
            ps.setDouble(2, pm.getPrec());
            ps.setInt(3, pm.getStk());
            ps.setString(4, pm.getEst());
            ps.setInt(5, pm.getId());
            ps.executeUpdate();
        }
        catch(SQLException e){
            
        }
        return r;
    }
    
    public void eliminar(int IdProducto){
        String sql = "delete from producto where IdProducto =" + IdProducto;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }
        catch(SQLException e){
            
        }
    }
}
