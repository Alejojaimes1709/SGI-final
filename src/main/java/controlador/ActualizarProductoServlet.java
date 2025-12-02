package com.sgi.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ActualizarProducto")
public class ActualizarProductoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Recibe el ID y el cambio (1 o -1) de la URL
        String id = request.getParameter("id");
        int cambio = 0;

        try {
            cambio = Integer.parseInt(request.getParameter("cambio"));
        } catch (NumberFormatException e) {
            // Si 'cambio' no es numérico, se queda en 0
        }

        Inventario inventario = Inventario.getInstancia();

        // La función en el Modelo maneja la validación de cantidad negativa
        inventario.actualizarCantidad(id, cambio);

        // Redirigir a ListarProductos para mostrar la tabla actualizada
        response.sendRedirect(request.getContextPath() + "/ListarProductos");
    }
}