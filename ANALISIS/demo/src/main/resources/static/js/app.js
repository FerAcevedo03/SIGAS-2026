document.addEventListener("DOMContentLoaded", function () {
    // Mostrar modal si hay un código generado
    if (typeof codigoGenerado !== 'undefined' && codigoGenerado !== null && codigoGenerado !== "") {
        var modalElement = document.getElementById('modalConfirmacion');
        var modalInstancia = new bootstrap.Modal(modalElement, {
            backdrop: 'static',
            keyboard: false
        });
        modalInstancia.show();
    }
});

// Función para copiar el código al portapapeles
function copiarCodigo() {
    // Obtener el texto del código
    var codigoText = document.getElementById("codigoGeneradoTexto").innerText;

    // API del portapapeles
    navigator.clipboard.writeText(codigoText).then(function () {
        var btn = document.getElementById("btnCopiar");
        btn.innerHTML = "<span class='me-1'>✅</span> ¡Copiado!";
        btn.classList.replace("btn-outline-secondary", "btn-success");
        btn.classList.add("text-white");

        setTimeout(function () {
            btn.innerHTML = "<span class='me-1'>📋</span> Copiar";
            btn.classList.replace("btn-success", "btn-outline-secondary");
            btn.classList.remove("text-white");
        }, 2000);

    }).catch(function (err) {
        console.error('Error al intentar copiar el texto: ', err);
        alert("Tu navegador no soporta el copiado automático.");
    });
}