<%-- 
    Document   : Productos
    Created on : 31 ago. 2020, 01:15:38
    Author     : andre
--%>

<%@page import="mypackage.entities.EspecificacionTecnica"%>
<%@page import="mypackage.repositories.jdbc.EspecificacionTecnicaRepository"%>
<%@page import="mypackage.repositories.interfaces.I_EspecificacionTecnicaRepository"%>
<%@page import="java.util.ArrayList"%>
<%@page import="mypackage.interfaces.utils.TableHTML"%>
<%@page import="mypackage.entities.Producto"%>
<%@page import="mypackage.entities.Producto"%>
<%@page import="java.util.List"%>
<%@page import="mypackage.repositories.jdbc.ProductoRepository"%>
<%@page import="mypackage.repositories.interfaces.I_ProductoRepository"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="mypackage.connector.LocalConnector"%>
<%  I_ProductoRepository productoRepository = new ProductoRepository(LocalConnector.getLocalConnection()); %>
<% I_EspecificacionTecnicaRepository especificacionTecnicaRepository = new EspecificacionTecnicaRepository(LocalConnector.getLocalConnection()); %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="images/tecnologia.ico">
        <title>Productos</title>
    <link rel="stylesheet" href="css/maquetacion.css">
        

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

    </head>

    <body>


        <!--HEADER-->
        <header>
            <!--NAVBAR-->
            <nav class="navbar navbar-expand-lg  bg-dark navbar-dark text-center ">
                <a class="navbar-brand" href="#">
                    <img src="images/tecnologia.svg" width="30" height="30" class="d-inline-block align-top" alt="" loading="lazy">
                    Productos IOT
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="#">Inicio <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="">Productos Agregados</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                        </li>
                    </ul>
                </div>
            </nav>
            <!--FIN NAVBAR-->
        </header>
        <!--FIN HEADER-->



        <!--SECTION_AGREGAR_PRODUCTOS-->
        <section class="text-center " >


            <div class="alert alert-dark" role="alert">
                <h1>Agregar un Nuevo Producto</h1>

            </div>

            <form class="m-5 mt-0  p-4 border "  action="ProductosValidacion.jsp" method="GET">

                <div class="form-group row text-center">
                    <label for="colFormLabel" class="col-sm-2 col-form-label ">Especificacion Tecnica</label>
                    <div class="col-sm-10">
                         <select class="form-control" name="id_especificacion_tecnica">
                             
                                                     <option value="seleccionar">Seleccionar</option>
                                                    
                           <%
                                                    for(EspecificacionTecnica especificacionTecnica : especificacionTecnicaRepository.getAll()){
                                                                out.println("<option  value=" + especificacionTecnica.getId() + " >" 
                                                                + especificacionTecnica + "</option>");
                                                                                                                      
                                                      }
                           %>
                                                       
                        </select>
                    </div>     
                </div>

                <div class="form-group row text-center">
                    <label for="colFormLabel" class="col-sm-2 col-form-label">Área</label>
                    <div class="col-sm-10">
                        <select class="form-control" name="area">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="domotica">Domotica</option>
                            <option value="industrial">Industrial</option>
                            <option value="telecomunicaciones">Telecomunicaciones</option>
                        </select>
                    </div>
                </div>

                <div class="form-group row text-center">
                    <label for="colFormLabel" class="col-sm-2 col-form-label">Función</label>
                    <div class="col-sm-10">
                        <input type="text" name="funcion" class="form-control" >
                    </div>
                </div>

                <div class="form-group row text-center">
                    <label for="colFormLabel" class="col-sm-2 col-form-label">Tipo</label>
                    <div class="col-sm-10">
                        <input type="text" name="tipo" class="form-control"  >
                    </div>
                </div>

                <div class="form-group row text-center">
                    <label for="colFormLabel" class="col-sm-2 col-form-label">Nombre</label>
                    <div class="col-sm-10">
                        <input type="text" name="nombre" class="form-control" >
                    </div>
                </div>


                <div class="form-group row text-center">
                    <label for="colFormLabel" class="col-sm-2 col-form-label">Modelo</label>
                    <div class="col-sm-10">
                        <input type="text" name="modelo" class="form-control"  >
                    </div>
                </div>

                <div class="form-group row text-center">
                    <label for="colFormLabel" class="col-sm-2 col-form-label">Tamaño</label>
                    <div class="col-sm-10">
                        <select class="form-control" name="tamaño">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="pequeño">Pequeño</option>
                            <option value="mediano">Mediano</option>
                            <option value="grande">Grande</option>
                        </select>
                    </div>
                </div>

                <div class="form-group row text-center">
                    <label for="colFormLabel" class="col-sm-2 col-form-label">Precio</label>
                    <div class="col-sm-10">
                        <input type="number" name="precio" class="form-control"  >
                    </div>
                </div>

                <div class="form-group row text-center">
                    <label for="colFormLabel" class="col-sm-2 col-form-label">Estado</label>
                    <div class="col-sm-10">
                        <select class="form-control" name="estado">
                            <option value="seleccionar">Seleccionar</option>
                            <option value="disponible">Disponible</option>
                            <option value="no_disponible">No Disponible</option>
                        </select>
                    </div>
                </div>

                <div class="text-center m-2 p-2 ">

                    <input type="submit" value="Agregar"   class="btn btn-secondary">

                    <input type="reset" value="Borrar"  class="btn btn-secondary ">

                </div>
            </form>
        </section>
        <!--FIN SECTION_AGREGAR_PRODUCTOS-->

 
        <br><br>
        <h2><span class="badge badge-secondary">Busqueda de Productos</span></h2>

        <form>
            Buscar por Area:
            <input type="text" name="buscarArea" placeholder="Ingrese un area..">
        </form>

        <%

            String buscarPorArea = " ";

            try {
                buscarPorArea = request.getParameter("buscarArea");

            } catch (Exception e) {
            }

            try {

                List<Producto> listaProductos = new ArrayList();

                if (buscarPorArea == null || buscarPorArea == " ") {

                    listaProductos = productoRepository.getAll();
                } else {
                    listaProductos = productoRepository.getLikeArea(buscarPorArea);
                }

                //Creamos un objeto de la clase creada automatizada para la lista de nuestros productos 
                //buscados por area
                out.println(new TableHTML<Producto>().getTable(listaProductos,"ProductosEliminacion.jsp","ProductosActualizacion.jsp"));

                /*       out.println("<table>");
                        out.println(
                                "<tr>"
                                + "<th>ID</td>"
                                + "<th>ID ESPECIFICACION TECNICA</td>"
                                + "<th>AREA</td>"
                                + "<th>FUNCION</td>"
                                + "<th>TIPO</td>"
                                + "<th>NOMBRE</td>"
                                + "<th>MODELO</td>"
                                + "<th>TAMAÑO</td>"
                                + "<th>PRECIO</td>"
                                + "<th>ESTADO</td>"
                                + "</tr>");

                        out.println("</table>");
                 */
            } catch (Exception e) {

                e.printStackTrace();

            }


        %>
        
        
        
        
        <!---FOOTER-->
<footer class="bg-dark ">
    <section class="Jumbotron ">
        <div class="jumbotron jumbotron-fluid d-flex flex-column text-center text-white bg-dark mb-0 ">
            <h3 class="display-5 "> Más Información</h3>

            <div class="links m-3 ">

                <a href="https://github.com/andresWeitzel " target="_blank "><button class="btn btn-dark border-light alert-link text-white m-2 ">
          <!--Icono Github del Autor-->
          <svg width="2em " height="2em " viewBox="0 0 16 16 " class="bi bi-person " fill="currentColor " xmlns="http://www.w3.org/2000/svg ">
              <path fill-rule="evenodd " d="M10 5a2 2 0 1 1-4 0 2 2 0 0 1 4 0zM8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm6 5c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168
                      1.332-.678.678-.83 1.418-.832 1.664h10z "/>
            </svg>
            <!--Fin Icono Github del Autor-->
      </button></a>


                <!-- Modal -->
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-dark border-light alert-link m-2 " data-toggle="modal" data-target="#exampleModal">
              <!--icono Contacto-->
              <svg width="2em" height="2em" viewBox="0 0 16 16" class="bi bi-envelope-open" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                  <path fill-rule="evenodd" d="M8.47 1.318a1 1 0 0 0-.94 0l-6 3.2A1 1 0 0 0 1 5.4v.818l5.724 3.465L8 8.917l1.276.766L15 6.218V5.4a1 1 0 0 0-.53-.882l-6-3.2zM15 7.388l-4.754 2.877L15 13.117v-5.73zm-.035 6.874L8 10.083l-6.965 4.18A1 1 0 0 0 2 15h12a1 1 0 0 0 .965-.738zM1 13.117l4.754-2.852L1 7.387v5.73zM7.059.435a2 2 0 0 1 1.882 0l6 3.2A2 2 0 0 1 16 5.4V14a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V5.4a2 2 0 0 1 1.059-1.765l6-3.2z"/>
                </svg>
                 <!--icono Contacto-->
             </button>
                <div class="modal fade text-dark" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"></button>
                                <span aria-hidden="true">&times;</span>

                            </div>
                            <div class="modal-body">
                                <h5>andres96energy@hotmail.com</h5>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-dark" data-dismiss="modal">Cerrar</button>

                            </div>
                        </div>
                    </div>
                </div>

                <!-- Fin Modal -->

                <a href="https://www.youtube.com/channel/UCuSVXmBcMURyTvbmbcgZalQ?view_as=subscriber " target="_blank "><button  class="btn btn-dark border-light alert-link m-2 ">
          <!--icono Otros Cursos-->
          <svg width="2em " height="2em " viewBox="0 0 16 16 " class="bi bi-collection-play " fill="currentColor " xmlns="http://www.w3.org/2000/svg ">
          <path fill-rule="evenodd " d="M14.5 13.5h-13A.5.5 0 0 1 1 13V6a.5.5 0 0 1 .5-.5h13a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-.5.5zm-13 1A1.5 1.5 0 0 1 0 13V6a1.5 1.5 0 0 1 1.5-1.5h13A1.5 1.5 0 0 1 16 6v7a1.5 1.5 0 0 1-1.5 1.5h-13zM2 3a.5.5 0 0 0
                      .5.5h11a.5.5 0 0 0 0-1h-11A.5.5 0 0 0 2 3zm2-2a.5.5 0 0 0 .5.5h7a.5.5 0 0 0 0-1h-7A.5.5 0 0 0 4 1z "/>
          <path fill-rule="evenodd " d="M6.258 6.563a.5.5 0 0 1 .507.013l4 2.5a.5.5 0 0 1 0 .848l-4 2.5A.5.5 0 0 1 6 12V7a.5.5 0 0 1 .258-.437z "/>
        </svg>
        <!--Finicono Otros Cursos-->
      </button></a>

                <a href="https://github.com/andresWeitzel/Material_de_Estudio " target="_blank ">
                    <button class="btn btn-dark border-light alert-link m-2 ">
          <!--Icono material Extra-->
          <svg width="2em " height="2em " viewBox="0 0 16 16 " class="bi bi-cloud-arrow-down " fill="currentColor " xmlns="http://www.w3.org/2000/svg ">
              <path fill-rule="evenodd " d="M4.406 3.342A5.53 5.53 0 0 1 8 2c2.69 0 4.923 2 5.166 4.579C14.758 6.804 16 8.137 16 9.773 16 11.569 14.502 13 12.687 13H3.781C1.708 13 0 11.366 0 9.318c0-1.763 1.266-3.223 2.942-3.593.143-.863.698-1.723
                      1.464-2.383zm.653.757c-.757.653-1.153 1.44-1.153 2.056v.448l-.445.049C2.064 6.805 1 7.952 1 9.318 1 10.785 2.23 12 3.781 12h8.906C13.98 12 15 10.988 15 9.773c0-1.216-1.02-2.228-2.313-2.228h-.5v-.5C12.188 4.825 10.328 3 8 3a4.53
                      4.53 0 0 0-2.941 1.1z "/>
              <path fill-rule="evenodd " d="M7.646 10.854a.5.5 0 0 0 .708 0l2-2a.5.5 0 0 0-.708-.708L8.5 9.293V5.5a.5.5 0 0 0-1 0v3.793L6.354 8.146a.5.5 0 1 0-.708.708l2 2z "/>
            </svg>
            <!--Fin Icono material Extra-->
              </button>
                </a>

                <div class="mt-5">
                    <h6 class="text-capitalize text-center">Desarrollado y Diseñado por Andrés Weitzel
                    </h6>
                </div>
                <div class=" mr-0 ml-5 text-white text-center">
                    <hr class="bg-white">
                    <p class="text-right ml-5 mr-0">
                        Open Source | 2020.
                    </p>
                </div>
            </div>
        </div>
    </section>
</footer>
<!---FIN FOOTER-->
        

        <!--Bootstrap-->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>


    </body>
</html>
