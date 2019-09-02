<%-- 
    Document   : Empleado
    Created on : 30-ago-2019, 0:10:16
    Author     : Antony
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>Empleado!</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="InicioController?menu=Empleado" method="POST">
                        <div class="form-group">
                            <label>Cedula</label>
                            <input type="text" name="txtCedula" value="${empleado.getCed()}" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" name="txtNombre" value="${empleado.getNom()}" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Telefono</label>
                            <input type="text" name="txtTelefono" value="${empleado.getTel()}" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text" name="txtEstado" value="${empleado.getEst()}" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Usuario</label>
                            <input type="text" name="txtUsuario" value="${empleado.getUser()}" class="form-control">
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>IdEmpleado</th>
                            <th>Cedula</th>
                            <th>Nombre</th>
                            <th>Telefono</th>
                            <th>Estado</th>
                            <th>Usuario</th>
                            <th>Acciones</th> 
                        </tr>
                        
                    </thead>               
                    <tbody>
                        <c:forEach var="em" items="${empleados}">
                        <tr>
                            <td>${em.getId()}</td>
                            <td>${em.getCed()}</td>
                            <td>${em.getNom()}</td>
                            <td>${em.getTel()}</td>
                            <td>${em.getEst()}</td>
                            <td>${em.getUser()}</td>
                            <td>
                                <a class="btn btn-warning" href="InicioController?menu=Empleado&accion=Editar&id=${em.getId()}">Editar</a>
                                <a class="btn btn-danger" href="InicioController?menu=Empleado&accion=Eliminar&id=${em.getId()}">Eliminar</a>
                            </td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
