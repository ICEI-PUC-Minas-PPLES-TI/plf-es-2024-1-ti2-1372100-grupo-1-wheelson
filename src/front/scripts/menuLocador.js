document.addEventListener("DOMContentLoaded", function() {
  const locadorId = getLocadorId();
  if (!locadorId) {
    alert("ID do locador não encontrado!");
    return;
  }

  console.log("Locador ID:", locadorId); // Verificação do ID do locador

  fetchVehicles();
 fetchAlugueis();
 
  function fetchVehicles() {
    fetch(`http://localhost:8080/carro/locador/${locadorId}`)
      .then(response => {
        if (!response.ok) {
          throw new Error('Network response was not ok ' + response.statusText);
        }
        return response.json();
      })
      .then(data => createVehicleCards(data))
      .catch(error => console.error('Error fetching vehicles:', error));
  }

  function fetchAlugueis() {
    fetch(`http://localhost:8080/aluguel/alugueis/locador/${locadorId}`)
      .then(response => {
        if (!response.ok) {
          throw new Error('Network response was not ok ' + response.statusText);
        }
        return response.json();
      })
      .then(data => createRentCards(data))
      .catch(error => console.error('Error fetching rents:', error));
  }

  function createRentCards(rents) {
    const container = document.getElementById("aluguel-container");
    container.innerHTML = ''; // Limpar o container antes de adicionar novos cartões
    rents.forEach(aluguel => {
      
      const janela = `<a class="btn" href="/src/front/pages/danos.html?aluguel=${aluguel.id_aluguel}">Danos</a>`;
      const vehicleCard = document.createElement('div');
      vehicleCard.className = 'col-xs-12 col-sm-6 col-md-6 col-lg-3';
      vehicleCard.innerHTML = `
        <div class="profile-container">
          <div class="info-user">
            <img class="profile-photo" src="${aluguel.carro.image || '/src/front/images/car.png'}" alt="Vehicle Image">
            <div class="name-user">
              <span class="name">${aluguel.carro.modelo}</span>
              
            </div>
          </div>
          <div class="bio-user">
            <p class="bio-info">
              Marca: ${aluguel.carro.marca}
              <br>
              Valor diário: R$ ${aluguel.carro.valorDiario}
            </p>
            <div class="buttons-options">
              <div class="row">
                <div class="col-12">
                  <a class="btn" onclick="deleteVehicle(${aluguel.carro.id})">Apagar</a>
                  ${janela}
                </div>
              </div>
            </div>
          </div>
        </div>
      `;
      container.appendChild(vehicleCard);
    });}

  function createVehicleCards(vehicles) {
    const container = document.getElementById("vehicles-container");
    container.innerHTML = ''; // Limpar o container antes de adicionar novos cartões
    vehicles.forEach(vehicle => {
      if (vehicle.disponivel === false) {
        return;
      }
      const vehicleCard = document.createElement('div');
      vehicleCard.className = 'col-xs-12 col-sm-6 col-md-6 col-lg-3';
      vehicleCard.innerHTML = `
        <div class="profile-container">
          <div class="info-user">
            <img class="profile-photo" src="${vehicle.image || '/src/front/images/car.png'}" alt="Vehicle Image">
            <div class="name-user">
              <span class="name">${vehicle.modelo}</span>
              
            </div>
          </div>
          <div class="bio-user">
            <p class="bio-info">
              Marca: ${vehicle.marca}
              <br>
              Valor diário: R$ ${vehicle.valorDiario}
            </p>
            <div class="buttons-options">
              <div class="row">
                <div class="col-12">
                  <a class="btn" onclick="deleteVehicle(${vehicle.id})">Apagar</a>
                                  </div>
              </div>
            </div>
          </div>
        </div>
      `;
      container.appendChild(vehicleCard);
    });
  }
});

function getLocadorId() {
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

function deleteVehicle(vehicleId) {
  fetch(`http://localhost:8080/carro/${vehicleId}`, {
    method: 'DELETE',
    headers: {
      'Content-Type': 'application/json'
    }
  })
  .then(response => {
    if (response.ok) {
      alert('Veículo apagado com sucesso!');
      location.reload(); // Recarrega a página para atualizar a lista de veículos
    } else {
      alert('Falha ao apagar o veículo.');
    }
  })
  .catch(error => console.error('Error:', error));
}
