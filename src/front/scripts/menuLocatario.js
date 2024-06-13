document.addEventListener("DOMContentLoaded", function() {
  const locadorId = getLocatarioId();
  if (!locadorId) {
    alert("ID do locatario não encontrado!");
    return;
  }
  fetchRentalsData(locadorId);
})

  function getLocatarioId() {
    const locadorData = localStorage.getItem('usuario');
    if (locadorData) {
      try {
        const locador = JSON.parse(locadorData);
        return locador.id;
      } catch (error) {
        console.error('Error parsing locador data:', error);
        return null;
      }
    } else {
      return null;
    }
  }

  



  function fetchRentalsData(id) {
    fetch(`http://localhost:8080/aluguel/alugueis/locatario/${id}`)
      .then(response => response.json())
      .then(data => createRentals(data))
      .catch(error => console.error('Error fetching data:', error));
  }

  function createRentals(data) {
    const container = document.getElementById("rentals-container");
    data.forEach(aluguel => {
      container.innerHTML += `
        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
          <div class="profile-container">
          <div class="info-user">
            <img class="profile-photo" src="${aluguel.carro.image || '/src/front/images/car.png'}" alt="Vehicle Image">
            <div class="name-user">
              <span class="name">${aluguel.carro.modelo}</span>
              
            </div>
          </div>
          <div class="bio-user">
            <p class="bio-info" style="font-weight: bold;">
              Marca: ${aluguel.carro.marca}
              <br>
              Valor diário: R$ ${aluguel.carro.valorDiario}
              <br>
              Placa: ${aluguel.carro.placa}
              <br>
              Data de início: ${aluguel.dataInicio}
              <br>
              Data de término: ${aluguel.dataFim}
            </p>
            <div class="buttons-options">
              <div class="row">
                <div class="col-12">
                  <a class="btn" onclick="" >Devolver Veículo</a>
                  
                </div>
              </div>
            </div>
          </div>
        </div>
        </div>
      `;
    });
  }

