fetchRentalsData();

  function fetchRentalsData(id) {
    fetch(`http://localhost:8080/aluguel/alugueis/locatario/${id}`)
      .then(response => response.json())
      .then(data => createRentals(data))
      .catch(error => console.error('Error fetching data:', error));
  }

  function createRentals(data) {
    const container = document.getElementById("rentals-container");
    data.forEach(rental => {
      container.innerHTML += `
        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-3">
          <div class="profile-container">
            <div class="info-user">
              <img class="profile-photo" src="front/images/car.png">
              <div class="name-user">
                <span class="name">${rental.name}</span>
                <span class="descrip">${rental.location}</span>
                <span class="fake">Detalhes</span>
              </div>
            </div>
            <div class="bio-user">
              <p class="bio-info">
                Marca: ${rental.brand}
                <br>
                Valor diário: R$ ${rental.dailyRate}
              </p>
              <div class="buttons-options">
                <div class="row">
                  <div class="col-12">
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      `;
    });
  }
});
