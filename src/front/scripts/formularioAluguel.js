document.addEventListener("DOMContentLoaded", function () {
    const nextButtons = document.querySelectorAll(".next");
    const submitButton = document.querySelector(".submit");
    const pages = document.querySelectorAll(".page");

    const reviewTime = document.getElementById("review-time");
    const reviewDays = document.getElementById("review-days");
    const reviewCost = document.getElementById("review-cost");

    let currentStep = 0;
    const stepDetails = {
        dataInicio: "",
        dataFim: "",
        valorTotal: 1500.00,
        statusPago: false,
        horarioInicio: "10:00",
        ativo: false,
        carro: {
            id: 1
        },
        locador: {
            id: 1
        },
        locatario: {
            id: 1
        }
    }

    nextButtons.forEach((button, index) => {
        button.addEventListener("click", (event) => {
            event.preventDefault();
            if (validateStep(index)) {
                collectData(index);
                pages[currentStep].classList.remove("active");
                currentStep++;
                pages[currentStep].classList.add("active");
                if (currentStep === pages.length - 1) {
                    fillReview();
                }
            }
        });
    });

    function validateStep(index) {
        if (index === 0) {
            const timeInput = document.getElementById("time");
            return timeInput && timeInput.value !== "";
        }
        if (index === 1) {
            const daysInput = document.getElementById("days");
            return daysInput && daysInput.value > 0;
        }
        return true;
    }

    function collectData(index) {
        if (index === 0) {
            let data = new Date(document.getElementById("time").value);
            stepDetails.dataInicio = data.toISOString();
            console.log(stepDetails.dataInicio);
        }
        if (index === 1) {
            let numDias = parseInt(document.getElementById("days").value, 10);
            let dataFim = new Date();
            let tempInicio = new Date(stepDetails.dataInicio)
            dataFim.setDate(tempInicio.getDate() + numDias);
            stepDetails.dataFim = dataFim.toISOString();
            console.log(stepDetails.dataFim)
            console.log(stepDetails.dataInicio)
        }
    }

    function fillReview() {
        const dataInicio = new Date(stepDetails.dataInicio);
        const dataFim = new Date(stepDetails.dataFim);

        const diferencaMilissegundos = dataFim - dataInicio;

        const diferencaDias = diferencaMilissegundos / (1000 * 60 * 60 * 24);

        //TODO: altera o valor padrão
        const totalCost = Math.round(diferencaDias * 100);
        stepDetails.valorTotal = totalCost;

        reviewTime.textContent = `Horário de encontro: ${dataInicio.toLocaleDateString()}`;
        reviewDays.textContent = `Dias de aluguel: ${dataFim.toLocaleDateString()}`;
        reviewCost.textContent = `Custo total: R$ ${totalCost.toFixed()}`;

    }



    submitButton.addEventListener("click", (event) => {
        event.preventDefault();
        // Aqui você pode adicionar a lógica para enviar o formulário

        fetch("http://localhost:8080/aluguel", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(stepDetails)
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
        alert("Formulário enviado com sucesso!");
    });
});
