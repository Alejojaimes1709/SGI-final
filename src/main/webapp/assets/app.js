// src/main/webapp/assets/app.js

// Referencias a las secciones de contenido para mostrar/ocultar formularios
const formContents = {
    'agregar': document.getElementById('agregar-content'),
    'quitar': document.getElementById('quitar-content'),
    'actualizar': document.getElementById('actualizar-content'),
    'inventario': document.getElementById('inventario-content')
};

// Función que maneja el click en el menú
function mostrarSeccion(id) {
    // 1. Oculta todos los formularios primero
    Object.values(formContents).forEach(sec => sec.style.display = 'none');

    // 2. Si se selecciona 'inventario' (o quitar/actualizar que redirigen al inventario),
    // recargamos el ListarProductosServlet para asegurar que los datos estén frescos.
    if (id === 'inventario' || id === 'quitar' || id === 'actualizar') {
        window.location.href = './ListarProductos';
    } else {
        // 3. Si se selecciona 'agregar', solo mostramos el formulario localmente
        const targetSection = formContents[id];
        if (targetSection) {
            targetSection.style.display = 'block';
        }
    }
}

// Función que maneja el cierre de sesión
function logout() {
    if (confirm("¿Cerrar sesión?")) {
        // Redirigimos al Servlet de Logout para invalidar la sesión
        window.location.href = './Logout';
    }
}