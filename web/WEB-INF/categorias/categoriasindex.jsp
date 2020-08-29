<%-- 
    Document   : categoriasindex
    Created on : 6/08/2020, 07:29:52 PM
    Author     : fredy Gamer
--%>

<%@page import="model.Categoria"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
        <%
            List<Categoria> lstItems = (List<Categoria>) request.getSession().getAttribute("categorias");
        %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de categorias</title>
    </head>
    <body>
        <h1 class="text-primary">Listado de categorias</h1>
        <br>
        <form action="CategoriaCtrl">
            <input type="submit" value="nueva" name="accion" class="btn btn-sm btn-primary">
        </form>
        <br>
        <table border="1" class="table table-sm table-hover table-bordered table-striped">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Descripcion</th>
                    <th>Editar</th>
                    <th>Eliminar</th>
                </tr>
            </thead>
            <tbody>
                <%for (Categoria categoria : lstItems) {%>
                <tr>
                    <td><%= categoria.getId()%></td>
                    <td><%= categoria.getNombre()%></td>
                    <td><%= categoria.getDescripcion()%></td>
                    <td>
                        <form action="CategoriaCtrl" method="GET" >
                            <input type="hidden" name="Id" value="<%= categoria.getId()%>">
                            <input type="submit" name="accion" value="editar" class="btn btn-success">
                        </form>
                    </td>
                    <td>
                        <form action="CategoriaCtrl" method="POST" >
                            <input type="hidden" name="Id" value="<%= categoria.getId()%>">
                            <input type="submit" name="accion" value="eliminar" class="btn btn-danger">
                        </form>
                    </td>
                </tr>
                <%}%>
            </tbody>
        </table>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    </body>
</html>
