<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Introducimos la libreria que nos importa el formato al sueldo -->
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!-- Formato ? -->
<fmt:setLocale value="es_ES"/> 
<section id="clientes">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Clientes</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="bg-dark text-white"> <!-- No funciona el bg-dark -->
                            <tr>
                                <!-- La ultima columna en vacio para anyadir el boton de editar -->
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Saldo</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Iteramos cada elemento de la lista de clientes -->
                            <!-- ServletControlador, nos doto del item clientes -->
                            <c:forEach var="cliente" items="${clientes}">
                                <tr>
                                    <td>${cliente.idCliente}</td>
                                    <td>${cliente.nombre} ${cliente.apellido}</td>
                                    <td><fmt:formatNumber value="${cliente.saldo}" type="currency"/></td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletControlador?accion=editar&${cliente.idCliente}"
                                           class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i>Editar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach> 
                        </tbody>
                    </table>
                </div>
            </div>

            <!-- INICIO | Tarjetas para los Totales -->
            <div class="col-md-3">
                <div class="card text-center bg-danger text-white mb-3">
                    <div class="card-body">
                        <h3>Saldo Total</h3>
                        <h4 class="display-4">
                            <fmt:formatNumber value="${saldoTotal}" type="currency"/>
                        </h4>
                    </div>
                </div>

                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Total Clientes</h3>
                        <h4 class="display-4">
                            <i class="fa fa-users"></i> ${totalClientes}
                        </h4>
                    </div>
                </div>

            </div>
            <!-- FIN | Tarjetas para los Totales -->

        </div>
    </div>
</section>

<!-- Agregar cliente MODAL -->

<jsp:include page="/WEB-INF/paginas/cliente/agregarCliente.jsp"/>
