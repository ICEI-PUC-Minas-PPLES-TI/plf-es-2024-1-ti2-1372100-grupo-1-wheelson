//PROBLEMA
const descProblema = document.getElementById("problemaDescricao")
//LOCADOR
const nomeLocador = document.getElementById("locadorNome")
const locadorCPF = document.getElementById("locadorCPF")

//LOCATARIO
const nomeLocatario = document.getElementById("locatarioNome")
const locatarioCPF = document.getElementById("locatarioCPF")
const locatarioCNH = document.getElementById("locatarioCNH")

//CARRO
const carroModelo = document.getElementById("carroModelo")
const carroPlaca = document.getElementById("carroPlaca")

const urlParams = new URLSearchParams(window.location.search);
const id_problema = urlParams.get('idProblema');
console.log(id_problema);

document.addEventListener('DOMContentLoaded', function() {
    getDados(id_problema);
});

function getDados(id_problema){
    fetch(`http://localhost:8080/problema/${id_problema}`)
    .then(response => response.json())
    .then(data => {
        console.log(data);
        descProblema.innerHTML = data.descricao;
        nomeLocador.innerHTML = data.aluguel.locador.nome;
        locadorCPF.innerHTML = data.aluguel.locador.cpf;
        nomeLocatario.innerHTML = data.aluguel.locatario.nome;
        locatarioCPF.innerHTML = data.aluguel.locatario.cpf;
        locatarioCNH.innerHTML = data.aluguel.locatario.cnh;
        carroModelo.innerHTML = data.aluguel.carro.modelo;
        carroPlaca.innerHTML = data.aluguel.carro.placa;
    })
    .catch((error) => {
        console.error('Error:', error);
    });
}

document.addEventListener('submit', function(event){
    event.preventDefault();
    enviarValor();
    window.location.href = "tabelaProblemas.html";
});
function enviarValor(){
    let valor = document.getElementById("valorExtra").value;
    fetch(`http://localhost:8080/problema/resolver/${id_problema}/${valor}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        }
    })
    .then(response => response.json())
    .then(data => {
        console.log('Success:', data);
        alert("Valor enviado com sucesso!");
    })
    .catch((error) => {
        console.error('Error:', error);
    });
}