<section id="actions" class="py-4 mb-4 bg-light">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <a href="index.jsp" class="btn btn-light btn-block">
                    <i class="fas fa-arrow-left"></i> Regresar al inicio
                </a>
            </div>
            <div class="col-md-3">
                <button type="submit" class="btn btn-success btn-block">
                    <i class="fas fa-check"></i> Guardar Cliente
                </button>
            </div>
            <div class="col-md-3">
                <!-- Como es un enlace, la peticion es de tipo GET -->
                <%
                    // Recupera el valor de idCliente del request
                    String idCliente = request.getParameter("idCliente");

                    // Imprime el valor de idCliente en la consola del servidor
                    System.out.println("idCliente BotonesNaveegacion = " + idCliente);
                %>
                <a href="${pageContext.request.contextPath}/ServletControlador?accion=eliminar&idCliente=${cliente.idCliente}"
                   class="btn btn-danger btn-block"> 
                    <i class="fas fa-trash"></i> Eliminar Cliente
                </a>
            </div>
        </div>
    </div>
    
</section>