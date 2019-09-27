package com.sales.models;
import com.sales.config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Antony
 */
public class VentaDAO {
    
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
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
        catch(SQLException e){
            
        }
        return numeroSerie;
    }
    
    public String idVenta() {
        String idVenta = "";
        String sql = "select max(IdVentas) from ventas";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                idVenta = rs.getString(1);
            }
        }
        catch(SQLException e){
            
        }
        return idVenta;
    }

    public int guardarVenta(VentaModel ve) {
        String sql = "insert into ventas(IdCliente, IdEmpleado, NumeroSerie, FechaVentas, Monto, Estado) values(?, ?, ?, ?, ?, ?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ve.getIdCliente());
            ps.setInt(2, ve.getIdEmpleado());
            ps.setString(3, ve.getSerie());
            ps.setString(4, ve.getFecha());
            ps.setDouble(5, ve.getMonto());
            ps.setString(6, ve.getEstado());
            ps.executeUpdate();
        }
        catch(SQLException e){
            
        }
        return r;
    
    }

    public int guardarDetalleVenta(VentaModel ve) {
        String sql = "insert into detalle_ventas(IdVentas, IdProducto, Cantidad, PrecioVenta) values(?, ?, ?, ?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ve.getId());
            ps.setInt(2, ve.getIdProducto());
            ps.setInt(3, ve.getCantidad());
            ps.setDouble(4, ve.getPrecio());
            ps.executeUpdate();
        }
        catch(SQLException e){
            
        }
        return r;
    }
}
