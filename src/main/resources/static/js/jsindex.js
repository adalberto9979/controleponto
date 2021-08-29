const data = {nome: "Anny Eduarda", senha: "annyduda"};
alert("Entrei");
fetch("http://localhost:8080/usuario/gravar", {
    method: "POST",
    headers: {
        "Content-Type": "application/json",
    },
    body: JSON.stringify(data),
})
        .then((response) => response.json())
        .then((data) => {
            console.log("Success:", data);
        })
        .catch((error) => {
            console.error("Error:", error);
        });

function iniciar() {
//                location.href='./web/lixo';
}