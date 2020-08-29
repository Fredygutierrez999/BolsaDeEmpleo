/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import BD.CategoriasJDBC;
import BD.EmpleoJDBC;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Categoria;
import model.Empleo;
import java.text.ParseException;

/**
 *
 * @author fredy Gamer
 */
@WebServlet(name = "EmpleoCtrl", urlPatterns = {"/EmpleoCtrl"})
public class EmpleoCtrl extends HttpServlet {

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
        if (request.getParameter("accion") != null) {
            if ("consulta".equals(request.getParameter("accion"))) {
                consultarEmpleos(request, response);
            }
            if ("nuevo".equals(request.getParameter("accion"))) {
                crearEmpleo(request, response);
            }
            if ("actualizar".equals(request.getParameter("accion"))) {
                vistaActualizaEmpleo(request, response);
            }

            /*
             if ("nueva".equals(request.getParameter("accion"))) {
             crearCategoria(request, response);
             }
            
             if ("editar".equals(request.getParameter("accion"))) {
             editarCaterogorias(request, response);
             }
             */
        } else {
            consultarEmpleos(request, response);
        }
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
        String accion = request.getParameter("accion");
        if (accion.equals("guardar")) {
            insertarEmpleo(request, response);
        }
        if (accion.equals("modificar")) {
            actualizarEmpleo(request, response);
        }
        if (accion.equals("eliminar")) {
            eliminarEmpleo(request, response);
        }
    }

    private void consultarEmpleos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Empleo> lstEmpleo = EmpleoJDBC.instancia().consultarEmpleoTodos();
        request.setAttribute("empleos", lstEmpleo);
        request.getRequestDispatcher("WEB-INF/empleos/empleadoIndex.jsp").forward(request, response);
    }

    private void crearEmpleo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Categoria> lstCategorias = CategoriasJDBC.instancia().consultarCategoriaTodas();
        request.setAttribute("categorias", lstCategorias);
        request.getRequestDispatcher("WEB-INF/empleos/empleadoNew.jsp").forward(request, response);
    }

    private void vistaActualizaEmpleo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Categoria> lstCategorias = CategoriasJDBC.instancia().consultarCategoriaTodas();
        int id = Integer.parseInt(request.getParameter("Id"));
        Empleo empleo = EmpleoJDBC.instancia().consultarEmpleo(id);
        request.setAttribute("empleo", empleo);
        request.setAttribute("categorias", lstCategorias);
        request.getRequestDispatcher("WEB-INF/empleos/empleadoUpdate.jsp").forward(request, response);
    }

    private void insertarEmpleo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String fechal = request.getParameter("fecha");
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha = new Date();
        try {
            fecha = formato.parse(fechal);
        } catch (ParseException e) {
        }
        Double salario = Double.parseDouble(request.getParameter("salario"));
        int destacado = Integer.parseInt(request.getParameter("destacado"));
        String estatus = request.getParameter("estatus");
        String detalle = request.getParameter("detalle");
        Categoria categoria = new Categoria();
        categoria.setId(Integer.parseInt(request.getParameter("idCategoria")));
        Empleo empleo = new Empleo(id, nombre, descripcion, fecha, salario, destacado, estatus, detalle, categoria);
        String mensaje = EmpleoJDBC.instancia().insertar(empleo);
        request.setAttribute("mensaje", mensaje);
        response.sendRedirect("EmpleoCtrl");
    }

    private void actualizarEmpleo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String fechal = request.getParameter("fecha");
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fecha = new Date();
        try {
            fecha = formato.parse(fechal);
        } catch (ParseException e) {
        }
        Double salario = Double.parseDouble(request.getParameter("salario"));
        int destacado = Integer.parseInt(request.getParameter("destacado"));
        String estatus = request.getParameter("estatus");
        String detalle = request.getParameter("detalle");
        Categoria categoria = new Categoria();
        categoria.setId(Integer.parseInt(request.getParameter("idCategoria")));
        Empleo empleo = new Empleo(id, nombre, descripcion, fecha, salario, destacado, estatus, detalle, categoria);
        String mensaje = EmpleoJDBC.instancia().actualizar(empleo);
        request.setAttribute("mensaje", mensaje);
        response.sendRedirect("EmpleoCtrl");
    }
    
    
    private void eliminarEmpleo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("Id"));
        String mensaje = EmpleoJDBC.instancia().eliminar(id);
        request.setAttribute("mensaje", mensaje);
        response.sendRedirect("EmpleoCtrl");
    }

}
