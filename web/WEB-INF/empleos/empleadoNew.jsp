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

            <main role="main">     
                <hr>
                <br/>    
                <div class="container"> 

                    <div class="card">
                        <h4 class="card-header"><strong>Datos de la Oferta de Empleo</strong></h4>              
                        <div class="card-body">
                            <form action="EmpleoCtrl" method="POST">              
                                <div class="row">
                                    <div class="col-md-3"> 
                                        <div class="form-group">
                                            <label for="Id">Id</label>
                                            <input type="number" class="form-control" id="id" name="id"  placeholder="Codigo de la oferta de Empleo" required="required">
                                        </div>
                                    </div>
                                    <div class="col-md-3"> 
                                        <div class="form-group">
                                            <label for="nombre">Nombre</label>
                                            <input type="text" class="form-control" id="nombre" name="nombre"  placeholder="Titulo de la oferta de empleo" required="required">
                                        </div>
                                    </div>
                                    <div class="col-md-6"> 
                                        <div class="form-group">
                                            <label for="descripcion">Descripción</label>
                                            <input type="text" class="form-control" id="descripcion" name="descripcion"  placeholder="Breve descripcion de la oferta de Empleo" required="required">
                                        </div> 
                                    </div>    
                                </div>    
                                <div class="row">
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label for="categoria">Categoría</label> 
                                            <select class="form-control" name="idCategoria" id="idCategoria">
                                            <c:forEach items="${categorias}" var="categoria">
                                                <option value="<c:out value="${categoria.id}"></c:out>" ><c:out value="${categoria.nombre}"></c:out></option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="estatus">Estatus</label> 
                                        <select class="form-control" name="estatus" id="estatus" >
                                            <option value="Creada">Creada</option>
                                            <option value="Aprobada">Aprobada</option>
                                            <option value="Eliminada">Eliminada</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="fecha">Fecha de Publicación</label> 
                                        <input type="date" class="form-control" name="fecha" id="fecha"  placeholder="Fecha de publicacion" required="required">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="salario">Salario Ofrecido</label> 
                                        <input type="number" class="form-control" name="salario" id="salario"  placeholder="Salario aproximado." required="required">
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-check">
                                        <label class="form-check-label" for="destacado"></label><br>
                                        <input class="form-check-input" type="radio" name="destacado" id="destacado" value="1"> 
                                        <label class="form-check-label" for="destacado1">Destacado</label>
                                    </div>
                                    <div class="form-check">
                                        <input class="form-check-input" type="radio" name="destacado" id="destacado" value="0"> 
                                        <label class="form-check-label" for="destacado2">No Destacado</label>
                                    </div>
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="detalles"><strong>Detalles</strong></label>
                                        <textarea class="form-control" name="detalles" id="detalles"   rows="4">${empleo.detalles}</textarea>
                                    </div>
                                </div>
                            </div>
                            <button type="submit" value="guardar" name="accion" class="btn btn-primary"></button>  
                        </form>
                    </div>
                </div>
            </div> <!-- /container -->

        </main>


        <jsp:include page="../includes/footer.jsp"></jsp:include>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    </body>
</html>
