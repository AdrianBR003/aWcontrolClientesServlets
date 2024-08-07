package web;

import datos.ClienteDaoJDBC;
import dominio.Cliente;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    // Opcion por defecto
    private void accionDefault(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        List<Cliente> clientes = new ClienteDaoJDBC().listar();
        //System.out.println("clientes = " + clientes);
        req.setAttribute("clientes", clientes); // Aqui decimos que vamos a compartir esta variable
        req.setAttribute("totalClientes", clientes.size());
        req.setAttribute("saldoTotal", this.calcularSaldoTotal(clientes));
        req.getRequestDispatcher("clientes.jsp").forward(req, res); // Y aqui definimos que la compartimos para 'clientes.jsp'
        res.sendRedirect("index.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String accion = req.getParameter("accion");
        
        // Vamos a revisar si hay informacion en accion
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarCliente(req, res);
                    break;
                case "eliminar":
                    System.out.println("idCliente ServletControlador" + req.getParameter("idCliente"));
                    this.eliminarCliente(req, res); 
                    res.sendRedirect("index.jsp");
                    break; 
                default:
                    this.accionDefault(req, res);
            }

        } else {
            this.accionDefault(req, res);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String accion = req.getParameter("accion");

        // Vamos a revisar si hay informacion en accion
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarCliente(req, res);
                    res.sendRedirect("index.jsp");
                    break;
                case "modificar": 
                    this.modificarCliente(req,res);
                    res.sendRedirect("index.jsp");
                    break; 
                default:
                    this.accionDefault(req, res);
            }

        } else {
            this.accionDefault(req, res);
        }

    }

    private double calcularSaldoTotal(List<Cliente> clientes) {
        double saldoTotal = 0;
        for (Cliente c : clientes) {
            saldoTotal += c.getSaldo();
        }
        return saldoTotal;
    }

    private void insertarCliente(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        // Recuperamos los valores del formulario agregarCliente
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String email = req.getParameter("email");
        String telefono = req.getParameter("telefono");
        double saldo = 0;
        String saldoString = req.getParameter("saldo");

        // Imprimir valores recibidos para depuración
        System.out.println("Cliente insertado");

        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Email: " + email);
        System.out.println("Telefono: " + telefono);
        System.out.println("Saldo String: " + saldoString);

        if (saldoString != null && !saldoString.isEmpty()) {
            try {
                saldo = Double.parseDouble(saldoString);
            } catch (NumberFormatException e) {
                e.printStackTrace(System.out);
                // Manejar el error de conversión según sea necesario
            }
        }

        // Creamos el objeto de cliente (modelo)
        Cliente cliente = new Cliente(nombre, apellido, email, telefono, saldo);

        // Insertamos el nuevo objeto en la base de datos 
        int registrosModificados = new ClienteDaoJDBC().insertar(cliente);
        System.out.println("registrosModificados = " + registrosModificados);
        this.accionDefault(req, res);
    }

    private void editarCliente(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        // Recuperamos el idCliente
        System.out.println("\n Hemos entrado a EDITAR CLIENTE .java \n");
        String idClienteP = req.getParameter("idCliente"); 
        int idCliente = Integer.parseInt(idClienteP);
        
        Cliente cliente = new ClienteDaoJDBC().encontrar(new Cliente(idCliente)); 
        System.out.println("cliente = " + cliente);
        req.setAttribute("cliente", cliente);
        String jspEditar = "/WEB-INF/paginas/cliente/editarCliente.jsp"; 
        req.getRequestDispatcher(jspEditar).forward(req, res);
    }

    private void modificarCliente(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        // Recuperamos los valores del formulario editarCliente
        
        int idCliente = Integer.parseInt(req.getParameter("idCliente")); 
        
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String email = req.getParameter("email");
        String telefono = req.getParameter("telefono");
        double saldo = 0;
        String saldoString = req.getParameter("saldo");

        // Imprimir valores recibidos para depuración
        System.out.println("Cliente modificado");

        System.out.println("idCliente = " + idCliente);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Email: " + email);
        System.out.println("Telefono: " + telefono);
        System.out.println("Saldo String: " + saldoString);

        if (saldoString != null && !saldoString.isEmpty()) {
            try {
                saldo = Double.parseDouble(saldoString);
            } catch (NumberFormatException e) {
                e.printStackTrace(System.out);
                // Manejar el error de conversión según sea necesario
            }
        }

        // Creamos el objeto de cliente (modelo)
        Cliente cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);

        // Modificamos el nuevo objeto en la base de datos 
        int registrosModificados = new ClienteDaoJDBC().actualizar(cliente);
        System.out.println("registrosModificados = " + registrosModificados);
        this.accionDefault(req, res);
    }
    
    private void eliminarCliente(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        System.out.println("\n Hemos entrado a ELIMINAR CLIENTE .java \n");

        int idCliente = Integer.parseInt(req.getParameter("idCliente"));
        
        // Recuperamos los valores del formulario editarCliente
        String idClienteP = req.getParameter("idCliente"); 
        System.out.println("idCliente = " + idClienteP);
        // Imprimir valores recibidos para depuración
        System.out.println("Cliente modificado");
        System.out.println("idCliente = " + idCliente);

        // Creamos el objeto de cliente (modelo)
        Cliente cliente = new Cliente(idCliente);

        // Modificamos el nuevo objeto en la base de datos 
        int registrosModificados = new ClienteDaoJDBC().eliminar(cliente);
        System.out.println("registrosModificados = " + registrosModificados);
        this.accionDefault(req, res);
    }
    
}
