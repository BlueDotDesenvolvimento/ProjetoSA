
const abrirPagina = function (path, id) {
    if(id != 0) {
        window.location.href = "/" + path + "/view/" + id;
    }
}