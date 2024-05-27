document.addEventListener("DOMContentLoaded", function() {
    const nextButtons = document.querySelectorAll(".next");
    const submitButton = document.querySelector(".submit");
    const pages = document.querySelectorAll(".page");

    const reviewTime = document.getElementById("review-time");
    const reviewDays = document.getElementById("review-days");
    const reviewCost = document.getElementById("review-cost");

    let currentStep = 0;
    const stepDetails = {
        time: "",
        days: 0,
        costPerDay: 100, // Exemplo de custo diário
    };

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
            stepDetails.time = document.getElementById("time").value;
        }
        if (index === 1) {
            stepDetails.days = document.getElementById("days").value;
        }
    }

    function fillReview() {
        reviewTime.textContent = `Horário de encontro: ${stepDetails.time}`;
        reviewDays.textContent = `Dias de aluguel: ${stepDetails.days}`;
        const totalCost = stepDetails.days * stepDetails.costPerDay;
        reviewCost.textContent = `Custo total: R$ ${totalCost}`;

        
    }

    submitButton.addEventListener("click", (event) => {
        event.preventDefault();

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
