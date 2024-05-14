function initMultiStepForm() {
    const submitBtn = document.querySelector(".submit");

    submitBtn.addEventListener("click", function(event) {
        event.preventDefault();

        // Captura os valores dos campos no momento do clique
        const nome = document.getElementById("nome").value;
        const sobrenome = document.getElementById("sobrenome").value; // Se necessário
        const email = document.getElementById("email").value;
        const telefone = document.getElementById("telefone").value;
        const cpf = document.getElementById("cpf").value;
        const dataNascimento = document.getElementById("dataNascimento").value;
        const rua = document.getElementById("rua").value;
        const bairro = document.getElementById("bairro").value;
        const numero_resid = document.getElementById("numero").value;
        const cidade = document.getElementById("cidade").value;
        const uf = document.getElementById("estado").value;
        const senha = document.getElementById("senha").value;

        const data = {
            nome,
            cpf,
            dataNascimento,
            email,
            telefone,
            rua,
            bairro,
            numero_resid,
            cidade,
            uf,
            status: false, // assumindo que o status seja sempre false
            saldo: 0, // saldo inicial
            dataEntrada: new Date(), // data atual
            senha
        };

        console.log("data", data);

        fetch("http://localhost:8080/locador", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            console.log('Success:', data);
            // lidar com a resposta de sucesso aqui
        })
        .catch(error => {
            console.error('Error:', error);
            // lidar com o erro aqui
        });
    });
}

// Chamada da função apenas uma vez quando a página é carregada
window.onload = function() {
    initMultiStepForm();
};

