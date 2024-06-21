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
      console.warn("Error, number of steps in progress bar do not match number of pages");
    }
  
    document.documentElement.style.setProperty("--stepNumber", stepsNumber);
  
    let current = 1;
  
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
        const modelo = getValueById("model");
        const Rua = getValueById("Rua");
        const bairro = getValueById("bairro");
        const preferencia = getValueById("referencia");
        const marca = getValueById("marca");
        const ano = getValueById("car-year");
        const valorDiario = parseFloat(getValueById("car-value"));
        const renavam = getValueById("renavam");
        const placa = getValueById("car-id");
        const disponivel = true;
  
        const usuarioData = localStorage.getItem("usuario");
        if (!usuarioData) {
          console.error("Usuário não está logado.");
          alert("Usuário não está logado. Por favor, faça login novamente.");
          return;
        }
  
        const locador = JSON.parse(usuarioData);
        const locadorId = locador.id;
  
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
          fetchPegarVeiculo(Rua,bairro,preferencia,locadorId);
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
  
      const renavam = document.getElementById('renavam').value;
      if (!isValidRenavam(renavam)) {
        alert("Código RENAVAM inválido.");
        inputsValid = false;
      }
  
      return inputsValid;
    }
  
    function isValidRenavam(renavam) {
	
        if (Number.isInteger(renavam)) {
            renavam = `${renavam}`;
        }
    
        var length = 11;
        var mod11 = 0;
        var ultimoDigitoCalculado = 0;
        // Pegando como exemplo o renavam = 639884962
    
        // Completa com zeros a esquerda se for no padrao antigo de 9 digitos
        // renavam = 00639884962
        if(renavam.match("^([0-9]{9})$")){
            renavam = "00" + renavam;
        }
        
        if(renavam.match("^([0-9]{10})$")){
            renavam = "0" + renavam;
        }
    
        // Valida se possui 11 digitos pos formatacao
        if(!renavam.match("[0-9]{11}")){
            return false;
        }
    
        // Remove o digito (11 posicao)
        // renavamSemDigito = 0063988496
        var renavamSemDigito = renavam.substring(0, 10);
    
        // Inverte os caracteres (reverso)
        // renavamReversoSemDigito = 69488936
        var renavamReversoSemDigito = renavamSemDigito.split("").reverse().join("");
    
        var soma = 0;
    
        // Multiplica as strings reversas do renavam pelos numeros multiplicadores
        // para apenas os primeiros 8 digitos de um total de 10
        // Exemplo: renavam reverso sem digito = 69488936
        // 6, 9, 4, 8, 8, 9, 3, 6
        // * * * * * * * *
        // 2, 3, 4, 5, 6, 7, 8, 9 (numeros multiplicadores – sempre os mesmos [fixo])
        // 12 + 27 + 16 + 40 + 48 + 63 + 24 + 54
        // soma = 284
        for (var i = 0; i < 8; i++) {
            var algarismo = parseInt(renavamReversoSemDigito.substring(i, i + 1));
            var multiplicador = i + 2;
            soma += algarismo * multiplicador;
        }
    
        // Multiplica os dois ultimos digitos e soma
        soma += renavamReversoSemDigito[8] * 2;
        soma += renavamReversoSemDigito[9] * 3;
    
        // mod11 = 284 % 11 = 9 (resto da divisao por 11)
        mod11 = (soma % length);
    
        // Faz-se a conta 11 (valor fixo) – mod11 = 11 – 9 = 2
        ultimoDigitoCalculado = (length - mod11);
    
        // ultimoDigito = Caso o valor calculado anteriormente seja 10 ou 11, transformo ele em 0
        // caso contrario, eh o proprio numero
        ultimoDigitoCalculado = (ultimoDigitoCalculado >= 10 ? 0 : ultimoDigitoCalculado);
    
        // Pego o ultimo digito do renavam original (para confrontar com o calculado)
        var digitoRealInformado = parseInt(renavam.substring(renavam.length -1, renavam.length));
    
        // Comparo os digitos calculado e informado
        if(ultimoDigitoCalculado == digitoRealInformado){
            return true;
        }
    
        return false;
    }
  
    function fetchPegarVeiculo(Rua, bairro, preferencia, locadorId) {
      fetch(`http://localhost:8080/carro/locador/${locadorId}`)
        .then(response => {
          if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
          }
          return response.json();
        })
        .then(data => {
          fetchPontodeEncontro(data, Rua, bairro, preferencia);
        });
    }
  
    function fetchPontodeEncontro(veiculo, Rua, bairro, preferencia) {
      const veiculo2 = veiculo[veiculo.length - 1];
      try {
        fetch('http://localhost:8080/pontoDeEncontro', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({
            rua: Rua,
            bairro: bairro,
            ponto_referencia: preferencia,
            carro: { id: veiculo2.id }
          })
        }).then(() => {
          alert("Ponto de encontro enviado com sucesso");
          window.location.href = "menuLocador.html";
        });
      } catch (error) {
        console.error('Erro ao enviar formulário:', error);
        alert('Erro ao enviar formulário. Tente novamente mais tarde.');
      }
    }
  }
  
  document.addEventListener('DOMContentLoaded', initMultiStepForm);