<%-- 
    Document   : Inicio
    Created on : 29-ago-2019, 18:31:17
    Author     : Antony
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
          <nav class="navbar navbar-expand-lg navbar-light bg-info">
            <div class="collapse navbar-collapse" id="navbarNav">
              <ul class="navbar-nav">
                <li class="nav-item active">
                  <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="InicioController?menu=Inicio">Inicio</a>
                </li>
                <li class="nav-item">
                    <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="InicioController?menu=Producto&accion=Listar" target="myFrame">Productos</a>
                </li>
                <li class="nav-item">
                  <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="InicioController?menu=Empleado&accion=Listar" target="myFrame">Empleados</a>
                </li>
                <li class="nav-item">
                  <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="InicioController?menu=Cliente&accion=Listar" target="myFrame">Clientes</a>
                </li>
                <li class="nav-item">
                  <a style="margin-left: 10px; border: none" class="btn btn-outline-light" href="InicioController?menu=RegistrarVenta&accion=default" target="myFrame">Venta nueva</a>
                </li>
              </ul>
                <div class="dropdown ml-auto">
                <button style="border: none" class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  ${usuario.getNom()}
                </button>
                <div class="dropdown-menu text-center" aria-labelledby="dropdownMenuButton">
                    <a class="dropdown-item" href="#">
                        <img src="com.sales.img/user.png" alt="60" width="60"/>
                    </a>
                  <a class="dropdown-item" href="#">${usuario.getUser()}</a>
                  <a class="dropdown-item" href="#">${usuario.getCor()}</a>
                  <div class="dropdown-divider"></div>
                  <form action="LogValidatorController" method="POST">
                     <button name="accion" value="Salir" class="dropdown-item" href="#">Salir</button> 
                  </form>
                </div>
              </div>
            </div>
          </nav>
                  <div class="m-4" style="height: 530px">
                      <iframe name="myFrame" style="height: 100%; width: 100%; border: none">
                          
                      </iframe>
                  </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
