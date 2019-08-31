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
public class EmpleadoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public EmpleadoModel validar(String user, String ced){
        EmpleadoModel em = new EmpleadoModel();
        String sql = "select * from empleado where Usuario=? and Cedula=?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, ced);
            rs = ps.executeQuery();
            while(rs.next()){
                em.setId(rs.getInt("IdEmpleado"));
                em.setUser(rs.getString("Usuario"));
                em.setCed(rs.getString("Cedula"));
                em.setNom(rs.getString("Nombre"));
            }
        }
        catch (SQLException e){
            
        }
        return em;
    }
    
    public List listar(){
        String sql = "select * from empleado";
        List<EmpleadoModel> lista = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                EmpleadoModel em = new EmpleadoModel();
                em.setId(rs.getInt("IdEmpleado"));
                em.setCed(rs.getString("Cedula"));
                em.setNom(rs.getString("Nombre"));
                em.setUser(rs.getString("Usuario"));
            }
        }
        catch (SQLException e){
            
        }
        return lista;
    }
    
    public int agregar(EmpleadoModel e){
        
    }
    
    public int actualizar(EmpleadoModel e){
        
    }
    
    public void eliminar(int IdEmpleado){
        
    }
}
