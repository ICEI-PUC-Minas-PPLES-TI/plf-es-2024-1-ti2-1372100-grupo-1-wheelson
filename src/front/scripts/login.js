import { isNillOrBlank } from "../utils/verify.js"; // Corrigido assumindo que o nome correto é isNullOrBlank

const submitFort = () => {
    const nomeField = document.getElementById("login-name").value; // Atualizado para capturar o valor no momento do clique
    const passwordField = document.getElementById("login-pass").value; // Corrigido para obter o valor e atualizado para capturar no momento do clique

    const loginType = document.querySelector('#login-type').value;
    console.log(loginType);

    switch (loginType) {
        case 'locador':
            loginLocador(nomeField, passwordField);
            break;
        case 'locatario':
            loginLocatario();
            break;
        default:
            alert("Seleciona o seu tipo de login!!");
            break;
    }
};

const loginLocador = (nome, senha) => {
    console.log("function call");
    if (isNillOrBlank(nome) || isNillOrBlank(senha)) {
        alert("Nome ou senha não podem estar em branco.");
        return;
    }

    fetchLogin("locador", nome, senha).then(data => {
        localStorage.setItem("usuario", JSON.stringify(data));
    }).catch(error => {
        console.error("Erro ao buscar login:", error);
    });
    window.location.href = "index.html";
};

const loginLocatario = () => {

    console.log("locatario");

};

async function fetchLogin(tipo, email, senha) {
    try {
        let response = await fetch(`http://localhost:8080/${tipo}/login/${email}/${senha}`);

        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }

        let data = await response.json();
        console.log(data);
        return data;
    } catch (error) {
        console.error("Erro ao buscar login:", error);
    }
}

const loginButton = document.getElementById("login-btn");
loginButton.addEventListener('click', submitFort); // Removida a duplicação