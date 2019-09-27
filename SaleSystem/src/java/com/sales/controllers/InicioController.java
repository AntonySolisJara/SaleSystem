package com.sales.controllers;
import com.sales.config.GenerarSerie;
import com.sales.models.ClienteDAO;
import com.sales.models.ClienteModel;
import com.sales.models.EmpleadoDAO;
import com.sales.models.EmpleadoModel;
import com.sales.models.ProductoDAO;
import com.sales.models.ProductoModel;
import com.sales.models.VentaDAO;
import com.sales.models.VentaModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Antony
 */
public class InicioController extends HttpServlet {

    EmpleadoModel em = new EmpleadoModel();
    EmpleadoDAO edao = new EmpleadoDAO();
    ClienteModel cm = new ClienteModel();
    ClienteDAO cdao = new ClienteDAO();
    ProductoModel pm = new ProductoModel();
    ProductoDAO pdao = new ProductoDAO();
    VentaModel v = new VentaModel();
    VentaDAO vdao = new VentaDAO();
    List<VentaModel> lista = new ArrayList<>();
    int item, codigo, cant, ide, idp, idc;
    String descripcion, numeroSerie;
    double precio, subtotal, totalPagar;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");
        if (menu.equals("Inicio")) {
            request.getRequestDispatcher("Inicio.jsp").forward(request, response);
        }
        if (menu.equals("Cliente")) {
            switch (accion){
                    case "Listar":
                        List lista = cdao.listar();
                        request.setAttribute("clientes", lista);
                        break;
                    case "Agregar":
                        String ced = request.getParameter("txtCedula");
                        String nom = request.getParameter("txtNombre");
                        String tel = request.getParameter("txtTelefono");
                        String cor = request.getParameter("txtCorreo");
                        String dir = request.getParameter("txtDireccion");
                        String est = request.getParameter("txtEstado");
                        cm.setCed(ced);
                        cm.setNom(nom);
                        cm.setTel(tel);
                        cm.setCor(cor);
                        cm.setDir(dir);
                        cm.setEst(est);
                        cdao.agregar(cm);
                        request.getRequestDispatcher("InicioController?menu=Cliente&accion=Listar").forward(request, response);
                        break;
                    case "Eliminar":
                        idc = Integer.parseInt(request.getParameter("id"));
                        cdao.eliminar(idc);
                        request.getRequestDispatcher("InicioController?menu=Cliente&accion=Listar").forward(request, response);
                        break;
                    case "Editar":
                        idc = Integer.parseInt(request.getParameter("id"));
                        ClienteModel c = cdao.listarId(idc);
                        request.setAttribute("cliente", c);
                        request.getRequestDispatcher("InicioController?menu=Cliente&accion=Listar").forward(request, response);
                        break;
                    case "Actualizar":
                        String ced1 = request.getParameter("txtCedula");
                        String nom1 = request.getParameter("txtNombre");
                        String tel1 = request.getParameter("txtTelefono");
                        String cor1 = request.getParameter("txtCorreo");
                        String dir1 = request.getParameter("txtDireccion");
                        String est1 = request.getParameter("txtEstado");
                        cm.setCed(ced1);
                        cm.setNom(nom1);
                        cm.setTel(tel1);
                        cm.setCor(cor1);
                        cm.setDir(dir1);
                        cm.setEst(est1);
                        cm.setId(idc);
                        cdao.actualizar(cm);
                        request.getRequestDispatcher("InicioController?menu=Cliente&accion=Listar").forward(request, response);
                        break;
                    default:
                        request.getRequestDispatcher("Cliente.jsp").forward(request, response);
                }
            request.getRequestDispatcher("Cliente.jsp").forward(request, response);
        }
        if (menu.equals("Empleado")) {
                    switch (accion){
                    case "Listar":
                        List lista = edao.listar();
                        request.setAttribute("empleados", lista);
                        break;
                    case "Agregar":
                        String ced = request.getParameter("txtCedula");
                        String nom = request.getParameter("txtNombre");
                        String tel = request.getParameter("txtTelefono");
                        String cor = request.getParameter("txtCorreo");
                        String user = request.getParameter("txtUsuario");
                        String cont = request.getParameter("txtContrasena");
                        String est = request.getParameter("txtEstado");
                        em.setCed(ced);
                        em.setNom(nom);
                        em.setTel(tel);
                        em.setCor(cor);
                        em.setUser(user);
                        em.setCont(cont);
                        em.setEst(est);
                        edao.agregar(em);
                        request.getRequestDispatcher("InicioController?menu=Empleado&accion=Listar").forward(request, response);
                        break;
                    case "Eliminar":
                        ide = Integer.parseInt(request.getParameter("id"));
                        edao.eliminar(ide);
                        request.getRequestDispatcher("InicioController?menu=Empleado&accion=Listar").forward(request, response);
                        break;
                    case "Editar":
                        ide = Integer.parseInt(request.getParameter("id"));
                        EmpleadoModel e = edao.listarId(ide);
                        request.setAttribute("empleado", e);
                        request.getRequestDispatcher("InicioController?menu=Empleado&accion=Listar").forward(request, response);
                        break;
                    case "Actualizar":
                        String ced1 = request.getParameter("txtCedula");
                        String nom1 = request.getParameter("txtNombre");
                        String tel1 = request.getParameter("txtTelefono");
                        String cor1 = request.getParameter("txtCorreo");
                        String user1 = request.getParameter("txtUsuario");
                        String cont1 = request.getParameter("txtContrasena");
                        String est1 = request.getParameter("txtEstado");
                        em.setCed(ced1);
                        em.setNom(nom1);
                        em.setTel(tel1);
                        em.setCor(cor1);
                        em.setUser(user1);
                        em.setCont(cont1);
                        em.setEst(est1);
                        em.setId(ide);
                        edao.actualizar(em);
                        request.getRequestDispatcher("InicioController?menu=Empleado&accion=Listar").forward(request, response);
                        break;
                    default:
                        request.getRequestDispatcher("Empleado.jsp").forward(request, response);
                }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }
        if (menu.equals("Producto")) {
            switch (accion){
                    case "Listar":
                        List lista = pdao.listar();
                        request.setAttribute("productos", lista);
                        break;
                    case "Agregar":
                        String descr = request.getParameter("txtDescripcion");
                        String prec = request.getParameter("txtPrecio");
                        String stk = request.getParameter("txtStock");
                        String est = request.getParameter("txtEstado");
                        pm.setDescr(descr);
                        pm.setPrec(Double.parseDouble(prec));
                        pm.setStk(Integer.parseInt(stk));
                        pm.setEst(est);
                        pm.setId(idp);
                        pdao.agregar(pm);
                        request.getRequestDispatcher("InicioController?menu=Producto&accion=Listar").forward(request, response);
                        break;
                    case "Eliminar":
                        idp = Integer.parseInt(request.getParameter("id"));
                        pdao.eliminar(idp);
                        request.getRequestDispatcher("InicioController?menu=Producto&accion=Listar").forward(request, response);
                        break;
                    case "Editar":
                        idp = Integer.parseInt(request.getParameter("id"));
                        ProductoModel p = pdao.listarId(idp);
                        request.setAttribute("producto", p);
                        request.getRequestDispatcher("InicioController?menu=Producto&accion=Listar").forward(request, response);
                        break;
                    case "Actualizar":
                        String descr1 = request.getParameter("txtDescripcion");
                        String prec1 = request.getParameter("txtPrecio");
                        String stk1 = request.getParameter("txtStock");
                        String est1 = request.getParameter("txtEstado");
                        pm.setDescr(descr1);
                        pm.setPrec(Double.parseDouble(prec1));
                        pm.setStk(Integer.parseInt(stk1));
                        pm.setEst(est1);
                        pm.setId(idp);
                        pdao.actualizar(pm);
                        request.getRequestDispatcher("InicioController?menu=Producto&accion=Listar").forward(request, response);
                        break;
                    default:
                        request.getRequestDispatcher("Producto.jsp").forward(request, response);
                }
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }
        if (menu.equals("RegistrarVenta")) {
            switch(accion){
                case "BuscarCliente":
                    String cedula = request.getParameter("txtCodigoCliente");
                    cm.setCed(cedula);
                    cm = cdao.buscar(cedula);
                    request.setAttribute("cm", cm);
                    request.setAttribute("numeroSerie", numeroSerie);
                    break;
                case "BuscarProducto":
                    int id = Integer.parseInt(request.getParameter("txtCodigo"));
                    pm = pdao.listarId(id);
                    request.setAttribute("producto", pm);
                    request.setAttribute("lista", lista);
                    request.setAttribute("totalPagar", totalPagar);
                    request.setAttribute("numeroSerie", numeroSerie);
                    request.setAttribute("cm", cm);
                    break;
                case "Agregar":
                    item = item + 1;
                    codigo = pm.getId();
                    descripcion = request.getParameter("txtNombreProducto");
                    precio = Double.parseDouble(request.getParameter("txtPrecio"));
                    cant = Integer.parseInt(request.getParameter("txtCant"));
                    subtotal = precio * cant;
                    v = new VentaModel();
                    v.setItem(item);
                    v.setIdProducto(codigo);
                    v.setDescripcion(descripcion);
                    v.setPrecio(precio);
                    v.setCantidad(cant);
                    v.setSubtotal(subtotal);
                    lista.add(v);
                    for (int i = 0; i < lista.size(); i++) {
                        totalPagar = totalPagar + lista.get(i).getSubtotal();
                    }
                    request.setAttribute("totalPagar", totalPagar);
                    request.setAttribute("lista", lista);
                    request.setAttribute("numeroSerie", numeroSerie);
                    request.setAttribute("cm", cm);
                    break;
                case "GenerarVenta":
                    //guardar venta
                    v.setIdCliente(cm.getId());
                    v.setIdEmpleado(2);
                    v.setSerie(numeroSerie);
                    v.setFecha("25/09/2019");
                    v.setMonto(totalPagar);
                    v.setEstado("1");
                    vdao.guardarVenta(v);
                    
                    //guardar detalle de venta
                    int idv = Integer.parseInt(vdao.idVenta());
                    for (int i = 0; i < lista.size(); i++) {
                        v = new VentaModel();
                        v.setId(idv);
                        v.setIdProducto(lista.get(i).getIdProducto());
                        v.setCantidad(lista.get(i).getCantidad());
                        v.setPrecio(lista.get(i).getPrecio());
                        vdao.guardarDetalleVenta(v);
                    }
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
                    break;
                default:
                    v = new VentaModel();
                    lista = new ArrayList<>();
                    item = 0;
                    totalPagar = 0.0;
                    
                    numeroSerie = vdao.generarSerie();
                    if (numeroSerie == null) {
                        numeroSerie = "000000001";
                        request.setAttribute("numeroSerie", numeroSerie);
                    }
                    else{
                        int incrementar = Integer.parseInt(numeroSerie);
                        GenerarSerie gs = new GenerarSerie();
                        numeroSerie = gs.NumeroSerie(incrementar);
                        request.setAttribute("numeroSerie", numeroSerie);
                    }
                    request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
            }
            request.getRequestDispatcher("RegistrarVenta.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
