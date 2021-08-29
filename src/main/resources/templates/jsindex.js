function initXHR() {
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
        if (xhr.overrideMimeType) {
            xhr.overrideMimeType('text/xml');
        }
    } else if (window.ActiveXObject) {
        xhr = new ActiveXObject("Microsoft.XMLHttp");
    }
}

function sendRequest(url, handler) {
    initXHR();
    xhr.onreadystatechange = handler;
    xhr.open("POST", url, true);
    xhr.send(null);
}

function iniciar() {
    
}

function logar() {
    var url = "http://localhost:8080/usuario/novo";
    
    alert(url);
    
    sendRequest(url, ajaxValidaLoginLogin);
}

function ajaxValidaLoginLogin() {
    if (xhr.readyState === 4) {
        if (xhr.status === 200) {
            var retorno = xhr.responseText; //JSON.parse(xhr.responseText);
            alert(retorno);
        } else {
            alert("Erro diferente de 200");
        }
    } else {
        alert("Erro diferente de 4");
    }
}
