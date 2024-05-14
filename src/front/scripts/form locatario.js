function initMultiStepForm() {
    const progressNumber = document.querySelectorAll(".step").length;
    const slidePage = document.querySelector(".slide-page");
    
    const progressText = document.querySelectorAll(".step p");
    const progressCheck = document.querySelectorAll(".step .check");
    const bullet = document.querySelectorAll(".step .bullet");
    const pages = document.querySelectorAll(".page");
    const nextButtons = document.querySelectorAll(".next");
    const prevButtons = document.querySelectorAll(".prev");
    const stepsNumber = pages.length;

    if (progressNumber !== stepsNumber) {
        console.warn(
            "Error, number of steps in progress bar do not match number of pages"
        );
    }

    document.documentElement.style.setProperty("--stepNumber", stepsNumber);

    let current = 1;

    for (let i = 0; i < nextButtons.length; i++) {
        nextButtons[i].addEventListener("click", function (event) {
            event.preventDefault();

            inputsValid = validateInputs(this);
            // inputsValid = true;

            if (inputsValid) {
                slidePage.style.marginLeft = `-${
                    (100 / stepsNumber) * current
                }%`;
                bullet[current - 1].classList.add("active");
                progressCheck[current - 1].classList.add("active");
                progressText[current - 1].classList.add("active");
                current += 1;
            }
        });
    }

    for (let i = 0; i < prevButtons.length; i++) {
        prevButtons[i].addEventListener("click", function (event) {
            event.preventDefault();
            slidePage.style.marginLeft = `-${
                (100 / stepsNumber) * (current - 2)
            }%`;
            bullet[current - 2].classList.remove("active");
            progressCheck[current - 2].classList.remove("active");
            progressText[current - 2].classList.remove("active");
            current -= 1;
        });
    }
   
    
    
    console.log("submit form");
    bullet[current - 1].classList.add("active");
    progressCheck[current - 1].classList.add("active");
    progressText[current - 1].classList.add("active");
    current += 1;

    

    
};

const submitBtn = document.querySelector(".submit");
submitBtn.addEventListener("click", () => {

    const nome = document.getElementById("nome").value;
    const email = document.getElementById("email").value;
    const telefone = document.getElementById("telefone").value;
    const cpf = document.getElementById("cpf").value;
    const dataNascimento = document.getElementById("dataNascimento").value;
    const rua = document.getElementById("rua").value;
    const bairro = document.getElementById("bairro").value;
    const numero_resid_locatario = document.getElementById("numero_resid").value;
    const cidade = document.getElementById("cidade").value;
    const uf = document.getElementById("uf").value;
    const cnh = document.getElementById("cnh").value;
    const senha = document.getElementById("senha").value;
    // Obter a data atual
    const dataAtual = new Date();

    // Extrair o ano, mês e dia
    const ano = dataAtual.getFullYear();
    // O mês é retornado de 0 a 11, então precisamos adicionar 1 para obter o valor correto
    const mes = (dataAtual.getMonth() + 1).toString().padStart(2, '0'); // Adiciona zero à esquerda se for menor que 10
    const dia = dataAtual.getDate().toString().padStart(2, '0'); // Adiciona zero à esquerda se for menor que 10

    // Formatar a data no formato desejado "xxxx-yy-zz"
    const dataFormatada = `${ano}-${mes}-${dia}`;

    console.log(dataFormatada); // Saída: "2024-05-13"
    const data = {
        
        nome,
        cpf,
        dataNascimento,
        email,
        telefone,
        rua,
        bairro,
        numero_resid_locatario,
        cidade,
        uf,
        status: false, // assumindo que o status seja sempre false
        senha,
        data_entrada: dataFormatada, // data atual
        cnh
       

        
    };

    fetch("http://localhost:8080/locatario", {
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
        window.location.href = "http://localhost:8080/index.html";
    })
    .catch(error => {
        console.error('Error:', error);
        // lidar com o erro aqui
    });

});

function validateInputs(ths) {
    let inputsValid = true;

    const inputs =
        ths.parentElement.parentElement.querySelectorAll("input");
    for (let i = 0; i < inputs.length; i++) {
        const valid = inputs[i].checkValidity();
        if (!valid) {
            inputsValid = false;
            inputs[i].classList.add("invalid-input");
        } else {
            inputs[i].classList.remove("invalid-input");
        }
    }
    return inputsValid;
}

// Chamada da função apenas uma vez quando a página é carregada
window.onload = function() {
    initMultiStepForm();
};
