package com.sales.controllers;
import com.sales.models.EmpleadoDAO;
import com.sales.models.EmpleadoModel;
import java.io.IOException;
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
    int ide;
    
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
                        String est = request.getParameter("txtEstado");
                        String user = request.getParameter("txtUsuario");
                        em.setCed(ced);
                        em.setNom(nom);
                        em.setTel(tel);
                        em.setEst(est);
                        em.setUser(user);
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
                        String est1 = request.getParameter("txtEstado");
                        String user1 = request.getParameter("txtUsuario");
                        em.setCed(ced1);
                        em.setNom(nom1);
                        em.setTel(tel1);
                        em.setEst(est1);
                        em.setUser(user1);
                        em.setId(ide);
                        edao.actualizar(em);
                        request.getRequestDispatcher("InicioController?menu=Empleado&accion=Listar").forward(request, response);
                        break;
                    default:
                        throw new AssertionError();
                }
            request.getRequestDispatcher("Empleado.jsp").forward(request, response);
        }
        if (menu.equals("Producto")) {
            request.getRequestDispatcher("Producto.jsp").forward(request, response);
        }
        if (menu.equals("RegistrarVenta")) {
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
