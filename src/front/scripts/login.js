import { isNillOrBlank } from "../utils/verify.js"; // Assumindo que o nome correto é isNullOrBlank

const submitFort = () => {
    const nomeField = document.getElementById("login-name").value; // Captura o valor no momento do clique
    const passwordField = document.getElementById("login-pass").value; // Captura o valor no momento do clique

    const loginType = document.querySelector('#login-type').value;
    console.log(loginType);

    switch (loginType) {
        case 'locador':
            loginLocador(nomeField, passwordField);
            break;
        case 'locatario':
            loginLocatario(nomeField, passwordField);
            break;
        case 'adm':
            loginAdm(nomeField, passwordField);
            break;
        default:
            alert("Selecione o seu tipo de login!");
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
        localStorage.clear();
        localStorage.setItem("usuario", JSON.stringify(data));
        window.location.href = "menuLocador.html";
    }).catch(error => {
        console.error("Erro ao buscar login:", error);
    });
};

const loginLocatario = (nome, senha) => {
    console.log("locatario");
    console.log("function call");
    if (isNillOrBlank(nome) || isNillOrBlank(senha)) {
        alert("Nome ou senha não podem estar em branco.");
        return;
    }

    fetchLogin("locatario", nome, senha).then(data => {
        localStorage.clear();
        localStorage.setItem("usuario", JSON.stringify(data));
        alert("Login efetuado com sucesso");
        window.location.href = "menuLocatario.html"; // Redireciona para a página do locatário
    }).catch(error => {
        console.error("Erro ao buscar login:", error);
        alert(error.message || "Erro ao realizar login");
    });
};

const loginAdm = (nome, senha) => {
    console.log("function call");
    if (isNillOrBlank(nome) || isNillOrBlank(senha)) {
        alert("Email ou senha não podem estar em branco.");
        return;
    }

    fetchLogin("adm", nome, senha).then(data => {
        localStorage.clear();
        if (data === true) {
            alert("Login efetuado com sucesso");
            window.location.href = "menuAdm.html";
        } else {
            alert("Email ou senha incorretos");
        }
    }).catch(error => {
        console.error("Erro ao buscar login:", error);
    });
};

async function fetchLogin(tipo, email, senha) {
    try {
        let response = await fetch(`http://localhost:8080/${tipo}/login/${email}/${senha}`);
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }

        let data = await response.json();
        console.log(data);

        if (tipo === "locatario" && !data.status) {
            throw new Error("Usuário não aprovado");
        }

        return data;
    } catch (error) {
        console.error("Erro ao buscar login:", error);
        throw error; // Propaga o erro para ser tratado na função de chamada
    }
}

document.addEventListener("DOMContentLoaded", function() {
    const loginButton = document.getElementById("login-btn");
    loginButton.addEventListener('click', submitFort);

    const toggleButton = document.querySelector(".toggle-password");
    toggleButton.addEventListener("click", togglePasswordVisibility);
});

function togglePasswordVisibility() {
    const passwordField = document.getElementById("login-pass");
    const toggleButton = document.querySelector(".toggle-password");

    if (passwordField.type === "password") {
        passwordField.type = "text";
        toggleButton.innerHTML = '<span class="material-symbols-outlined" alt="Hide Password">visibility_off</span>';
    } else {
        passwordField.type = "password";
        toggleButton.innerHTML = '<span class="material-symbols-outlined" alt="Show Password">visibility</span>';
    }
}
