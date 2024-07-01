<!DOCTYPE html>
<html>
    <head>
        <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Aplicacion Cliente BootStrap</title>
        <!-- BootStrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/1c3cdf85d3.js" crossorigin="anonymous"></script>
        <title>Control de Clientes</title>
    </head>
    <body>
        
        <!-- Informacion en el JSP de cabecero -->
        <jsp:include page="WEB-INF/paginas/comunes/cabecero.jsp"/> 

        <!-- Botones de navegacion -->
        <jsp:include page="WEB-INF/paginas/comunes/botonesNavegacion.jsp" />

        <!-- Listado Clientes -->
        <jsp:include page="WEB-INF/paginas/cliente/listadoClientes.jsp"/>

        <!-- Pie de pagina -->
        <jsp:include page="WEB-INF/paginas/comunes/piePagina.jsp"/> 

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
    </body>
</html>
