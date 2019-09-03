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
public class ClienteDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public ClienteModel listarId(int IdCliente){
        ClienteModel cliente = new ClienteModel();
        String sql = "select * from cliente where IdCliente =" + IdCliente;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                cliente.setCed(rs.getString("Cedula"));
                cliente.setNom(rs.getString("Nombre"));
                cliente.setTel(rs.getString("Telefono"));
                cliente.setCor(rs.getString("Correo"));
                cliente.setDir(rs.getString("Direccion"));
                cliente.setEst(rs.getString("Estado"));
            }
        }
        catch(SQLException e){
            
        }
        return cliente;
    }
    
    public List listar(){
        String sql = "select * from cliente";
        List<ClienteModel> lista = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                ClienteModel cm = new ClienteModel();
                cm.setId(rs.getInt(1));
                cm.setCed(rs.getString(2));
                cm.setNom(rs.getString(3));
                cm.setTel(rs.getString(4));
                cm.setCor(rs.getString(5));
                cm.setDir(rs.getString(6));
                cm.setEst(rs.getString(7));
                lista.add(cm);
            }
        }
        catch(SQLException e){
            
        }
        return lista;
    }
    
    public int agregar(ClienteModel cm){
        String sql = "insert into cliente (Cedula, Nombre, Telefono, Correo, Direccion, Estado) values(?, ?, ?, ?, ?, ?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cm.getCed());
            ps.setString(2, cm.getNom());
            ps.setString(3, cm.getTel());
            ps.setString(4, cm.getCor());
            ps.setString(5, cm.getDir());
            ps.setString(6, cm.getEst());
            ps.executeUpdate();
        }
        catch(SQLException e){
            
        }
        return r;
    }
    
    public int actualizar(ClienteModel cm){
        String sql = "update cliente set Cedula = ?, Nombre = ?, Telefono = ?, Correo = ?, Direccion = ?, Estado = ? where IdCliente = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cm.getCed());
            ps.setString(2, cm.getNom());
            ps.setString(3, cm.getTel());
            ps.setString(4, cm.getCor());
            ps.setString(5, cm.getDir());
            ps.setString(6, cm.getEst());
            ps.setInt(7, cm.getId());
            ps.executeUpdate();
        }
        catch(SQLException e){
            
        }
        return r;
    }
    
    public void eliminar(int IdCliente){
        String sql = "delete from cliente where IdCliente =" + IdCliente;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }
        catch(SQLException e){
            
        }
    }
}
