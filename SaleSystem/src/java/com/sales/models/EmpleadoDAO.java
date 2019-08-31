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
    int r;
    
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
    
    public EmpleadoModel listarId(int IdEmpleado){
        EmpleadoModel emp = new EmpleadoModel();
        String sql = "select * from empleado where IdEmpleado =" + IdEmpleado;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                emp.setCed(rs.getString("Cedula"));
                emp.setNom(rs.getString("Nombre"));
                emp.setTel(rs.getString("Telefono"));
                emp.setEst(rs.getString("Estado"));
                emp.setUser(rs.getString("Usuario"));
            }
        }
        catch (SQLException e){
            
        }
        return emp;
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
                em.setTel(rs.getString("Telefono"));
                em.setEst(rs.getString("Estado"));
                em.setUser(rs.getString("Usuario"));
                lista.add(em);
            }
        }
        catch (SQLException e){
            
        }
        return lista;
    }
    
    public int agregar(EmpleadoModel em){
        String sql = "insert into empleado (Cedula, Nombre, Telefono, Estado, Usuario) values(?, ?, ?, ?, ?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getCed());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getEst());
            ps.setString(5, em.getUser());
            ps.executeUpdate();
        }
        catch (SQLException e){
            
        }
        return r;
    }
    
    public int actualizar(EmpleadoModel em){
        String sql = "update empleado set Cedula = ?, Nombre = ?, Telefono = ?, Estado = ?, Usuario = ? where IdEmpleado = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getCed());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getEst());
            ps.setString(5, em.getUser());
            ps.setInt(6, em.getId());
            ps.executeUpdate();
        }
        catch (SQLException e){
            
        }
        return r;
    }
    
    public void eliminar(int IdEmpleado){
        String sql = "delete from empleado where IdEmpleado =" + IdEmpleado;
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }
        catch (SQLException e){
            
        }
            
    }
}
