/*document.addEventListener("DOMContentLoaded", function() {
  const locatarioId = getLocatarioId();
  if (!locatarioId) {
    alert("ID do locatário não encontrado!");
    return;
  }
*/
  fetchVehicles();

  async function fetchVehicles() {
    try {
      const response = await fetch('http://localhost:8080/carro/all');
      const data = await response.json();
      await createVehicleCards(data);
    } catch (error) {
      console.error('Error fetching vehicles:', error);
    }
    // fetch('http://localhost:8080/carro/all')
    //   .then(response => response.json())
    //   .then(data =>  await createVehicleCards(data))
    //   .catch(error => console.error('Error fetching vehicles:', error));
  }

  async function createVehicleCards(vehicles) {
    const container = document.getElementById("vehicles-container");
    for (const carro of vehicles) {
      const ponto = await fetchPontodeEncontro(carro)
      console.log(ponto);
      console.log(carro);
      const vehicleCard = document.createElement('div');
      vehicleCard.className = 'col-xs-12 col-sm-6 col-md-6 col-lg-3';
      vehicleCard.innerHTML = `
        <div class="profile-container">
          <div class="info-user">
            <img class="profile-photo" src="/src/front/images/car.png" alt="Vehicle Image">
            <div class="name-user">
              <span class="name">${carro.modelo}</span>
              
            </div>
          </div>
          <div class="bio-user">
            <p class="bio-info">
              Marca: ${carro.marca}
              <br>
              Valor diário: R$ ${carro.valorDiario}
              <br>
              Ponto de encontro: ${ponto.rua}, bairro ${ponto.bairro}. Ponto de referência: ${ponto.ponto_referencia}
            </p>
            <div class="buttons-options">
              <div class="row">
                <div class="col-12">
                <a href="/src/front/pages/formAluguel.html">
                  <button class="btn btn-outline-light btn-sm" onclick="rentVehicle(${carro.id})">Alugar</button>
                </a>
                </div>
              </div>
            </div>
          </div>
        </div>
      `;
      container.appendChild(vehicleCard);
    };
  }
;

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
async function fetchPontodeEncontro(veiculo)
{
  try {
    const res = await fetch(`http://localhost:8080/pontoDeEncontro/carro/${veiculo.id}`);
    const data = await res.json();
    return data[0];
  } catch (error) {
    console.error('Error fetching ponto de encontro:', error);
    return null;
  }
  // fetch(`http://localhost:8080/pontoDeEncontro/carro/${veiculo.id}`)
  // .then(res => res.json())
  // .then(data => {
  //   console.log(data)
  //   return data[0]})
}
