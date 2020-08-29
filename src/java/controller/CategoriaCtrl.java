/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import BD.CategoriasJDBC;
import com.sun.java.accessibility.util.EventID;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Categoria;

/**
 *
 * @author fredy Gamer
 */
@WebServlet(name = "CategoriaCtrl", urlPatterns = {"/CategoriaCtrl"})
public class CategoriaCtrl extends HttpServlet {

    List<Categoria> lista = new ArrayList();

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
            if ("nueva".equals(request.getParameter("accion"))) {
                crearCategoria(request, response);
            }
            if ("consulta".equals(request.getParameter("accion"))) {
                consultarCaterogorias(request, response);
            }
            if ("editar".equals(request.getParameter("accion"))) {
                editarCaterogorias(request, response);
            }
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
        if (request.getParameter("accion") != null) {
            if ("insertar".equals(request.getParameter("accion"))) {
                insertarCategoria(request, response);
                consultarCaterogorias(request, response);
            }
            if ("editar".equals(request.getParameter("accion"))) {
                editaObjetoCategoria(request, response);
                consultarCaterogorias(request, response);
            }
            if ("eliminar".equals(request.getParameter("accion"))) {
                eliminarObjetoCategoria(request, response);
                consultarCaterogorias(request, response);
            }
        }
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

    private List<Categoria> cargarCategorias() {
        List<Categoria> lstCategorias = null;
        CategoriasJDBC objJDBC = CategoriasJDBC.instancia();
        lstCategorias = objJDBC.consultarCategoriaTodas();
        return lstCategorias;
    }

    private void consultarCaterogorias(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("categorias") == null) {
            lista = cargarCategorias();
            request.getSession().setAttribute("categorias", lista);
        }
        request.getRequestDispatcher("WEB-INF/categorias/categoriasindex.jsp").forward(request, response);
    }

    private void crearCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/categorias/categoriaNew.jsp").forward(request, response);
    }

    private void insertarCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("Id"));
        String nombre = request.getParameter("Nombre");
        String descripcion = request.getParameter("Descripcion");
        CategoriasJDBC objJDBC = CategoriasJDBC.instancia();
        Categoria obj = new Categoria(id, nombre, descripcion);
        objJDBC.insertar(obj);
    }

    private Categoria buscarXId(HttpServletRequest request, int Id) {
        lista = (List<Categoria>) request.getSession().getAttribute("categorias");
        for (Categoria obj : lista) {
            if (obj.getId() == Id) {
                return obj;
            }
        }
        return null;
    }
    
    
    private void eliminarXId(HttpServletRequest request, int Id) {
        lista = (List<Categoria>) request.getSession().getAttribute("categorias");
        Categoria obj = buscarXId(request,Id);
        lista.remove(obj);
    }

    private void editarCaterogorias(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("Id"));
        Categoria obj = buscarXId(request, id);
        request.setAttribute("objEditar", obj);
        request.getRequestDispatcher("WEB-INF/categorias/categoriaEdit.jsp").forward(request, response);
    }

    private void editaObjetoCategoria(HttpServletRequest request, HttpServletResponse response) {
        Categoria obj = new Categoria();
        int ID = Integer.parseInt(request.getParameter("Id"));
        String nombre = request.getParameter("Nombre");
        String descripcion = request.getParameter("Descripcion");       
        obj.setNombre(nombre);
        obj.setDescripcion(descripcion);
        obj.setId(ID);
        CategoriasJDBC objJDBC = CategoriasJDBC.instancia();
        objJDBC.actualizar(obj);
    }
    
    private void eliminarObjetoCategoria(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("Id"));
        CategoriasJDBC objJDBC = CategoriasJDBC.instancia();
        objJDBC.eliminar(id);
    }

}
