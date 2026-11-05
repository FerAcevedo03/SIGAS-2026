document.addEventListener("DOMContentLoaded", function () {
    if (typeof codigoGenerado !== 'undefined' && codigoGenerado !== null && codigoGenerado !== "") {
        var modalElement = document.getElementById('modalConfirmacion');
        var modalInstancia = new bootstrap.Modal(modalElement, {
            backdrop: 'static',
            keyboard: false
        });
        modalInstancia.show();
    }
});