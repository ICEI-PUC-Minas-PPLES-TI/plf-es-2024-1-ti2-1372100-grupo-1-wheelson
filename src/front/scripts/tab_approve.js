fetchTableData()

function fetchTableData(){
    let data;
    fetch('http://localhost:8080/locatario')
    .then(response => console.log(response.json().then(data => createTable(data))))
    

}

function createTable(data){
    console.log("data",data);
    const table = document.querySelector(".table")
    data.forEach(element => {
        table.innerHTML += `
    
        <tr>                                                
            <td>${element.nome}</td>
            <td>${element.cnh}</td>
            <td>${element.cpf}</td>
            <td>
            <input type="button" class="big" data-toggle="modal" data-target="#modalEliminar" value="Validar">
            </input> 
            </td>
        </tr>
    
        `
            
    });

}