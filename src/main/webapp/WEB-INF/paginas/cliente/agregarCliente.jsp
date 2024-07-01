<div class="modal fade" id="agregarClienteModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Cliente</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            
            <!-- Todo lo que insertemos en este formulario va a ir a la base de datos -->
            <form action="${pageContext.request.contextPath}/ServletControlador?accion=insertar"
                  method="POST" class="was-validated">

                <div class="modal-body">
                    <!-- Formulario - Nombre -->
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombre" required>
                    </div>
                    <!-- Formulario - Apellido -->
                    <div class="form-group">
                        <label for="apellido">Apellido</label>
                        <input type="text" class="form-control" name="apellido" required>
                    </div>
                    <!-- Formulario - Email -->
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" name="email" required>
                    </div>
                    <!-- Formulario - Telefono -->
                    <div class="form-group">
                        <label for="telefono">Telefono</label>
                        <input type="number" class="form-control" name="telefono" required>
                    </div>
                    <!-- Formulario - Sueldo -->
                    <div class="form-group">
                        <label for="saldo">Sueldo</label>
                        <input type="number" class="form-control" step="0.01" name="saldo" required>
                    </div>
                </div>

                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar y Enviar</button>
                </div>

            </form>
            
        </div>
    </div>
</div>