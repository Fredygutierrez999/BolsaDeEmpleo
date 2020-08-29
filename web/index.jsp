<%-- 
    Document   : index
    Created on : 6/08/2020, 06:39:05 PM
    Author     : fredy Gamer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bolsa de empleo</title>
    </head>
    <body>
        <h1>Bienvenido a <em>Bolsa de empleo</em></h5>
        <br/>
        <form action="CategoriaCtrl" method="GET">
            <input type="hidden" name="accion" value="consulta">
            <input type="submit" name="accion2" value="Administra categorias">
        </form>
        <form action="EmpleoCtrl" method="GET">
            <input type="hidden" name="accion" value="consulta">
            <input type="submit" name="accion" value="Administrar Empleo">
        </form>
    </body>
</html>
