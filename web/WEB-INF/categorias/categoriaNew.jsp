<%-- 
    Document   : categoriaNew
    Created on : 8/08/2020, 01:45:44 PM
    Author     : fredy Gamer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear categoria</title>
    </head>
    <body>
         <h1 class="text-primary">Crear categoria</h1>
        <br>
        <form action="CategoriaCtrl" method="POST">
            <table>
                <tbody>
                    <tr>
                        <td class="text-right">Id:</td>
                        <td>
                            <input type="text" name="Id" class="form-control form-control-sm">
                        </td>
                    </tr>
                    <tr>
                        <td class="text-right">Nombre:</td>
                        <td>
                            <input type="text" name="Nombre" class="form-control form-control-sm">
                        </td>
                    </tr>
                    <tr>
                        <td class="text-right">Descripcion:</td>
                        <td>
                            <input type="text" name="Descripcion" class="form-control form-control-sm">
                        </td>
                    </tr>
                     <tr>
                        <td colspan="2">
                            <br>
                            <input type="submit" name="accion" value="insertar" class="btn btn-success w-100">
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
        
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    </body>
</html>
