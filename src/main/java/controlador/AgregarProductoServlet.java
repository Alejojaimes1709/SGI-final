package com.sgi.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AgregarProducto")
public class AgregarProductoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id").toUpperCase();
        String nombre = request.getParameter("nombre");
        int cantidad;
        double precio;

        try {
            cantidad = Integer.parseInt(request.getParameter("cantidad"));
            precio = Double.parseDouble(request.getParameter("precio"));
        } catch (NumberFormatException e) {
            // Mensaje de error si los datos numéricos son inválidos
            request.setAttribute("mensaje", "Error: Cantidad o Precio no válidos.");
            request.setAttribute("exito", false);
            request.getRequestDispatcher("/ListarProductos").forward(request, response);
            return;
        }

        Inventario inventario = Inventario.getInstancia();
        Producto nuevoProducto = new Producto(id, nombre, cantidad, precio);

        boolean agregado = inventario.agregarProducto(nuevoProducto);

        if (agregado) {
            request.setAttribute("mensaje", "Producto '" + nombre + "' agregado con éxito.");
            request.setAttribute("exito", true);
        } else {
            request.setAttribute("mensaje", "Error: El ID '" + id + "' ya existe en el inventario.");
            request.setAttribute("exito", false);
        }

        // Redirigir a ListarProductos para mostrar la tabla actualizada
        request.getRequestDispatcher("/ListarProductos").forward(request, response);
    }
}