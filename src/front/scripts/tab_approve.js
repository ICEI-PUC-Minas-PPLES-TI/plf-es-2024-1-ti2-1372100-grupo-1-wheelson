fetchTableData()

function fetchTableData(){
    let data;
    fetch('http://localhost:8080/locatario/status/false')
    .then(response => console.log(response.json().then(data => createTable(data))))
    

}

function createTable(data){
    console.log("data",data);
    const table = document.querySelector(".table")
    data.forEach(element => {
        table.innerHTML += `
    
        <tr id="card${element.id}">                                                
            <td>${element.nome}</td>
            <td>${element.cnh}</td>
            <td>${element.cpf}</td>
            <td>
            <input type="button" class="big" data-toggle="modal" data-target="#modalEliminar" value="Validar" onclick = validateLocatario(${element.id})>
            </input> 
            </td>
        </tr>
    
        `
            
    });

}
function validateLocatario(id_locatario){
    console.log("validar");
    console.log(id_locatario);
    fetch(`http://localhost:8080/locatario/${id_locatario}`,{
        method: 'PATCH',
        headers: {
            'Content-Type': 'application/json',
        },
    }
    ).then(alert("Locatário validado com sucesso!"))
    .catch(error => console.log(error))
    //remover card de locatario da tela
    var card = document.getElementById("card"+id_locatario);
    card.remove();


}