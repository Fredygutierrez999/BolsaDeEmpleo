<%-- 
    Document   : empleadoIndex
    Created on : 18/08/2020, 06:51:32 PM
    Author     : fredy Gamer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="../includes/header.jsp"></jsp:include>
            <div class="container theme-showcase" role="main">
                <br/><br/><br/>
                <h1 class="text-primary">Listado de Empleos</h1>
                <br/>
                <form action="EmpleoCtrl" method="get">
                    <input type="submit" name="accion" value="nuevo" class="btn btn-primary btn-sm">
                </form>
                <table class="table table-striped table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Fecha</th>
                            <th>Nombre</th>
                            <th>Salario</th>
                            <th>Estatus</th>
                            <th>Opción</th>
                            <th>Opción</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${empleos}" var="empleo">
                        <tr>
                            <td><c:out value="${empleo.id}"></c:out></td>
                            <td><c:out value="${empleo.fecha}"></c:out></td>
                            <td><c:out value="${empleo.nombre}"></c:out></td>
                            <td><c:out value="${empleo.salario}"></c:out></td>
                            <td><c:out value="${empleo.estatus}"></c:out></td>
                                <td>
                                    <form method="get" action="EmpleoCtrl">
                                        <input type="hidden" name="Id" value="<c:out value="${empleo.id}"></c:out>" >
                                        <input type="submit" value="actualizar" name="accion" class="btn btn-sm btn-success">
                                    </form>
                                </td>
                                <td>
                                    <form method="POST" action="EmpleoCtrl">
                                        <input type="hidden" name="Id" value="<c:out value="${empleo.id}"></c:out>" >
                                        <input type="submit" value="eliminar" name="accion" class="btn btn-sm btn-success">
                                    </form>
                                </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <jsp:include page="../includes/footer.jsp"></jsp:include>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    </body>
</html>
