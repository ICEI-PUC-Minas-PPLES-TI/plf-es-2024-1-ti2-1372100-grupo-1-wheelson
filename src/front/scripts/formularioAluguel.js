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
    const dataAtual = new Date();

    // Extrair o ano, mês e dia
    const ano = dataAtual.getFullYear();
    // O mês é retornado de 0 a 11, então precisamos adicionar 1 para obter o valor correto
    const mes = (dataAtual.getMonth() + 1).toString().padStart(2, '0'); // Adiciona zero à esquerda se for menor que 10
    const dia = dataAtual.getDate().toString().padStart(2, '0'); // Adiciona zero à esquerda se for menor que 10

    // Formatar a data no formato desejado "xxxx-yy-zz"
    const dataFormatada = `${ano}-${mes}-${dia}`;

    console.log(dataFormatada); // Saída: "2024-05-13"

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
            return daysInput && daysInput.value !=="";
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
        reviewDays.textContent = `Data final do aluguel: ${stepDetails.days}`;
        const totalCost = calculaDiferencaDias(dataAtual,stepDetails.days)*stepDetails.costPerDay;;
        reviewCost.textContent = `Custo total: R$ ${totalCost}`;
    }

    submitButton.addEventListener("click", (event) => {
        event.preventDefault();
        console.log(stepDetails.time)
        console.log(stepDetails.days)
        
        
        const urlParams = new URLSearchParams(window.location.search);
        const idVeiculo = urlParams.get('vehicleId');
        console.log("idveiculo: ",idVeiculo)
        const totalCost = calculaDiferencaDias(dataAtual,stepDetails.days)*stepDetails.costPerDay;
        const params = new URLSearchParams(window.location.search)
        const idLocador= params.get('idLocador');
        const data_fim =  new Date(stepDetails.days);
        console.log(getLocatarioId());
        rentVehicle(idVeiculo,getLocatarioId(),dataAtual,data_fim,totalCost,stepDetails.time,idLocador);
        
       
        // Aqui você pode adicionar a lógica para enviar o formulário
        alert("Formulário enviado com sucesso!");
    });
});
function rentVehicle(vehicleId, locatarioId, data_inicio, data_fim, valor,horario,idLocador) {
 
    console.log("id locatario:",locatarioId)
    console.log("id carro:",vehicleId)
    console.log("id locador:",idLocador)
    const aluguelData = {
      locatario:{ 
        id:locatarioId},
      carro:{id: vehicleId},
      locador:{
        id: idLocador
      },
      statusPago: false,
      dataFim: data_fim,
      dataInicio:data_inicio,
      ativo: true,
      valorTotal: valor,
      horarioInicio:horario
    };
   console.log(aluguelData)
    fetch('http://localhost:8080/aluguel', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(aluguelData)
    })
    .then(response => response.json())
    .then(data => {
      alert('Aluguel realizado com sucesso!');
      console.log('Success:', data);
      window.location.href = "menuLocatario.html"
    })
    .catch(error => console.error('Error:', error));
    window.location.href = "menuLocatario.html"
  } 

  function getLocatarioId() {
    const locatarioData = localStorage.getItem('usuario');
  if (locatarioData) {
    try {
      const locatario = JSON.parse(locatarioData);
      return locatario.id.toString();
    } catch (error) {
      console.error('Error parsing locador data:', error);
      return null;
    }
  } else {
    return null;
  }
  }

  function calculaDiferencaDias(dataAtual,dataUsuario)
  {
    const dataInserida= new Date(dataUsuario);
    const diferencaMilissegundos = dataInserida - dataAtual;

    // Converter a diferença de milissegundos para dias
    const diferencaDias = Math.ceil(diferencaMilissegundos / (1000 * 60 * 60 * 24));

    console.log(diferencaDias)
    return diferencaDias;
  }
  //Calcula o valor total a ser pago no aluguel
  // function CalculaCustoTotal(dataAtual,dataUsuario,custo)
  // {
    
  //   const diferenca =calculaDiferencaDias(dataAtual,dataFinal) * custo ;
  //   console.log(diferenca);
  //   return diferenca ;
  // }
