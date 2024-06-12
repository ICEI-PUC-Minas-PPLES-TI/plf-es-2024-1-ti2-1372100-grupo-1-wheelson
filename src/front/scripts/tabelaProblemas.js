document.addEventListener("DOMContentLoaded", function() {
    const tabelaNresolvidos= document.getElementById("tabelaNresolvidos");
    const tabelaResolvidos= document.getElementById("tabelaResolvidos");

    fetchProblemasNaoResolvidos(tabelaNresolvidos);

    fetchProblemasResolvidos(tabelaResolvidos);

    function fetchProblemasNaoResolvidos(tabelaNresolvidos) {
        fetch(`http://localhost:8080/problema/naoResolvido`)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok ' + response.statusText);
                }
                return response.json();
            })
            .then(data => createProblemaCards(data,tabelaNresolvidos))
            .catch(error => console.error('Error fetching problemas:', error));
    }

    function fetchProblemasResolvidos(tabelaResolvidos) {
        fetch(`http://localhost:8080/problema/resolvido`)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok ' + response.statusText);
                }
                return response.json();
            })
            .then(data => createProblemaCards(data,tabelaResolvidos))
            .catch(error => console.error('Error fetching problemas:', error));
    }
    
    //FUNCAO PARA CRIAR OS CARDS DE PROBLEMAS
    function createProblemaCards(data, tabela) {
        console.log("data", data);
        if (tabela === tabelaNresolvidos) {
        data.forEach(problema => {
            formatadorData = new Date(problema.data);
            problema.data = formatadorData.toLocaleDateString('pt-BR');
            tabela.innerHTML += `
        
            <tr id="=problemaID${problema.id_problema}">                                                
                <td>${problema.id_problema}</td>
                <td>${problema.data}</td>
                <td>${problema.aluguel.carro.id}</td>
                <td>${problema.aluguel.carro.placa}</td>
                <td>
                      <a href="/src/front/pages/detalhesDanos.html?idProblema=${problema.id_problema}">
                        <button type="button" class="btn btn-primary btn-sm" >
                          <i class="fa fa-search"></i>
                        </button> 
                      </a>
                    </td>
            </tr>
        
            `

        });
    } else {
        data.forEach(problema => {
            formatadorData = new Date(problema.data);
            problema.data = formatadorData.toLocaleDateString('pt-BR');
            tabela.innerHTML += 
            `
            <tr id="=problemaID${problema.id_problema}">                                                
                <td>${problema.id_problema}</td>
                <td>${problema.data}</td>
                <td>${problema.aluguel.carro.id}</td>
                <td>${problema.aluguel.carro.placa}</td>
                <td>${problema.valorExtra}</td>
            </tr>
            `

        });}
    }



});