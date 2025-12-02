<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SGI - Acceso</title>

    <link rel="stylesheet" href="assets/style.css">
</head>
<body>

<section id="bienvenida" class="full-screen-section">
    <h1>Hola, Bienvenidos al SGI</h1>
</section>

<section id="login-section" class="full-screen-section hidden-section" style="background-color: var(--color-bg);">
    <div class="login-card">
        <h2>Ingrese su Usuario y Contraseña</h2>

        <%
            // Código Java (JSP Scriptlet) para mostrar el error de LoginServlet
            String error = (String) request.getAttribute("errorLogin");
            if (error != null) {
        %>
            <p style="color: var(--color-red); font-weight: bold; margin-bottom: 15px;">
                <%= error %>
            </p>
        <%
            }
        %>

        <%-- El formulario llama al LoginServlet --%>
        <form action="<%= request.getContextPath() %>/Login" method="post">
            <div class="input-group"><input type="text" name="username" placeholder="Usuario" required></div>
            <div class="input-group"><input type="password" name="password" placeholder="Contraseña" required></div>
            <button type="submit" class="login-btn">Acceder</button>
            <p>Demo: admin / 123</p>
        </form>

    </div>
</section>

<script>
    // JS para la animación de bienvenida (copiado de tu código original)
    const bienvenidaSection = document.getElementById('bienvenida');
    const loginSection = document.getElementById('login-section');

    document.addEventListener('DOMContentLoaded', () => {
        setTimeout(() => bienvenidaSection.classList.add('hidden-section'), 2000);
        setTimeout(() => {
            bienvenidaSection.style.display = 'none';
            loginSection.classList.remove('hidden-section');
        }, 2500);
    });
</script>

</body>
</html>