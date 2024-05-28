initMultiStepForm();

function initMultiStepForm() {
    const progressNumber = document.querySelectorAll(".step").length;
    const slidePage = document.querySelector(".slide-page");
    const vehicleForm = document.querySelector("#vehicle-form");
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

    // Adiciona event listener ao select
    const select = document.getElementById('login-type');
    const nextButton = document.getElementById('next-btn');
    const errorMessage = document.getElementById('error-message');
    const yearErrorMessage = document.getElementById('year-error-message');
    const carYearInput = document.getElementById('car-year');

    select.addEventListener('change', function() {
        if (select.value === 'naoproprietario') {
            errorMessage.style.display = 'block';
            nextButton.disabled = true;
        } else {
            errorMessage.style.display = 'none';
            nextButton.disabled = false;
        }
    });

    for (let i = 0; i < nextButtons.length; i++) {
        nextButtons[i].addEventListener("click", function(event) {
            event.preventDefault();

            const inputsValid = validateInputs(this);

            if (inputsValid) {
                slidePage.style.marginLeft = `-${(100 / stepsNumber) * current}%`;
                bullet[current - 1].classList.add("active");
                progressCheck[current - 1].classList.add("active");
                progressText[current - 1].classList.add("active");
                current += 1;
            }
        });
    }

    for (let i = 0; i < prevButtons.length; i++) {
        prevButtons[i].addEventListener("click", function(event) {
            event.preventDefault();
            slidePage.style.marginLeft = `-${(100 / stepsNumber) * (current - 2)}%`;
            bullet[current - 2].classList.remove("active");
            progressCheck[current - 2].classList.remove("active");
            progressText[current - 2].classList.remove("active");
            current -= 1;
        });
    }

    vehicleForm.addEventListener("submit", async function(event) {
        event.preventDefault();
        const inputsValid = validateInputs(this);

        const getValueById = id => document.getElementById(id)?.value;

        if (inputsValid) {
            // Captura os valores antes do fetch
            const modelo = getValueById("model");
            const Rua = getValueById("Rua");
            const bairro = getValueById("bairro");
            const preferencia = getValueById("referencia");
            const marca = getValueById("marca");
            const ano = getValueById("car-year");
            const valorDiario = parseFloat(getValueById("car-value")); // Converte para número
            const renavam = getValueById("renavam");
            const placa = getValueById("car-id");
            const disponivel = true; // Garante que é um booleano

            const usuarioData = localStorage.getItem("usuario");
            if (!usuarioData) {
                console.error("Usuário não está logado.");
                alert("Usuário não está logado. Por favor, faça login novamente.");
                return;
            }

            const locador = JSON.parse(usuarioData);
            const locadorId = locador.id;

            // Log dos valores
            console.log({
                modelo,
                marca,
                ano,
                valorDiario,
                renavam,
                placa,
                disponivel,
                locador: { id: locadorId }
            });

            try {
                const response = await fetch('http://localhost:8080/carro', { 
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({
                        modelo,
                        marca,
                        ano,
                        valorDiario,
                        renavam,
                        placa,
                        disponivel,
                        locador: { id: locadorId }
                    })
                });

                if (!response.ok) {
                    const errorData = await response.json();
                    console.error('Erro ao enviar formulário:', errorData);
                    alert(`Erro: ${errorData.message}`);
                    return;
                }

                alert("Your Form Successfully Signed up");
            } catch (error) {
                console.error('Erro ao enviar formulário:', error);
                alert('Erro ao enviar formulário. Tente novamente mais tarde.');
            }
        }
    });

    function validateInputs(ths) {
        let inputsValid = true;

        const inputs = ths.parentElement.parentElement.querySelectorAll("input, select");
        for (let i = 0; i < inputs.length; i++) {
            const valid = inputs[i].checkValidity();
            if (!valid) {
                inputsValid = false;
                inputs[i].classList.add("invalid-input");
            } else {
                inputs[i].classList.remove("invalid-input");
            }
        }

        const carYear = carYearInput.value;
        const carYearDate = new Date(carYear);
        const cutoffDate = new Date('2014-01-01');

        if (carYear && carYearDate < cutoffDate) {
            inputsValid = false;
            carYearInput.classList.add("invalid-input");
            yearErrorMessage.style.display = 'block';
        } else {
            carYearInput.classList.remove("invalid-input");
            yearErrorMessage.style.display = 'none';
        }

        return inputsValid;
    }

    //function fetchPontoDeEncontro()
}
