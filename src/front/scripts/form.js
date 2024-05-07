function initMultiStepForm() {
    const progressNumber = document.querySelectorAll(".step").length;
    const slidePage = document.querySelector(".slide-page");
    const submitBtn = document.querySelector(".submit");
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
    submitBtn.addEventListener("click", () => {
        const data = {
            nome: document.getElementById("nome").value,
            cpf: document.getElementById("cpf").value,
            dataNascimento: document.getElementById("dataNascimento").value,
            email: document.getElementById("email").value,
            telefone: document.getElementById("telefone").value,
            rua: document.getElementById("rua").value,
            bairro: document.getElementById("bairro").value,
            numero_resid: document.getElementById("numero").value,
            cidade: document.getElementById("cidade").value,
            uf: document.getElementById("estado").value,
            status: false, // assumindo que o status seja sempre false
            saldo: 0, // saldo inicial
            dataEntrada: new Date().toISOString(), // data atual
            senha: document.getElementById("senha").value
        };
    
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
    
    
    console.log("submit form");
    bullet[current - 1].classList.add("active");
    progressCheck[current - 1].classList.add("active");
    progressText[current - 1].classList.add("active");
    current += 1;

    

    
};

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
