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
    
    public EmpleadoModel validar(String user, String cont){
        EmpleadoModel em = new EmpleadoModel();
        String sql = "select * from empleado where Usuario=? and Contrasena=?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, cont);
            rs = ps.executeQuery();
            while(rs.next()){
                em.setId(rs.getInt("IdEmpleado"));
                em.setNom(rs.getString("Nombre"));
                em.setUser(rs.getString("Usuario"));
                em.setCor(rs.getString("Correo"));
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
                emp.setCor(rs.getString("Correo"));
                emp.setUser(rs.getString("Usuario"));
                emp.setCont(rs.getString("Contrasena"));
                emp.setEst(rs.getString("Estado"));
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
                em.setId(rs.getInt(1));
                em.setCed(rs.getString(2));
                em.setNom(rs.getString(3));
                em.setTel(rs.getString(4));
                em.setCor(rs.getString(5));
                em.setUser(rs.getString(6));
                em.setCont(rs.getString(7));
                em.setEst(rs.getString(8));
                lista.add(em);
            }
        }
        catch (SQLException e){
            
        }
        return lista;
    }
    
    public int agregar(EmpleadoModel em){
        String sql = "insert into empleado (Cedula, Nombre, Telefono, Correo, Usuario, Contrasena, Estado) values(?, ?, ?, ?, ?, ?, ?)";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getCed());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getCor());
            ps.setString(5, em.getUser());
            ps.setString(6, em.getCont());
            ps.setString(7, em.getEst());
            ps.executeUpdate();
        }
        catch (SQLException e){
            
        }
        return r;
    }
    
    public int actualizar(EmpleadoModel em){
        String sql = "update empleado set Cedula = ?, Nombre = ?, Telefono = ?, Correo = ?, Usuario = ?, Contrasena = ?, Estado = ? where IdEmpleado = ?";
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getCed());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getCor());
            ps.setString(5, em.getUser());
            ps.setString(6, em.getCont());
            ps.setString(7, em.getEst());
            ps.setInt(8, em.getId());
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
