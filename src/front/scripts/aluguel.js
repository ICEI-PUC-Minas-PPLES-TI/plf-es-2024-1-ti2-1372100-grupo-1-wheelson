document.addEventListener("DOMContentLoaded", function() {
  const locatarioId = getLocatarioId();
  if (!locatarioId) {
    alert("ID do locatário não encontrado!");
    return;
  }

  fetchVehicles();

  function fetchVehicles() {
    fetch('http://localhost:8080/carro/all')
      .then(response => response.json())
      .then(data => createVehicleCards(data))
      .catch(error => console.error('Error fetching vehicles:', error));
  }

  function createVehicleCards(vehicles) {
    const container = document.getElementById("vehicles-container");
    vehicles.forEach(vehicle => {
      const vehicleCard = document.createElement('div');
      vehicleCard.className = 'col-xs-12 col-sm-6 col-md-6 col-lg-3';
      vehicleCard.innerHTML = `
        <div class="profile-container">
          <div class="info-user">
            <img class="profile-photo" src="/src/front/images/car.png" alt="Vehicle Image">
            <div class="name-user">
              <span class="name">${vehicle.model}</span>
              <span class="descrip">${vehicle.location}</span>
            </div>
          </div>
          <div class="bio-user">
            <p class="bio-info">
              Marca: ${vehicle.brand}
              <br>
              Valor diário: R$ ${vehicle.dailyRate}
            </p>
            <div class="buttons-options">
              <div class="row">
                <div class="col-12">
                  <button class="btn btn-outline-light btn-sm" onclick="rentVehicle(${vehicle.id}, ${locatarioId})">Alugar</button>
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

function getLocatarioId() {
  // Suponha que o ID do locatário seja armazenado em algum lugar, como no localStorage
  return localStorage.getItem('locatarioId');
}

function rentVehicle(vehicleId, locatarioId) {
  const aluguelData = {
    locatarioId: locatarioId,
    carroId: vehicleId,
    statusPagamento: false,
    ativo: true,
    valorTotal: 0 // Defina o valor total conforme necessário
  };

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
  })
  .catch(error => console.error('Error:', error));
}
