const enviarbtn = document.getElementById('enviarbtn');


const urlParams = new URLSearchParams(window.location.search);
const id_aluguel = urlParams.get('aluguel');
console.log(id_aluguel);
enviarbtn.addEventListener('click', function(event) {
    event.preventDefault();
    // Fazer caso queira conferir se aluguel existe
    // fetch('http://localhost:8080/aluguel/${}', {
    //     method: 'get',
    //     headers: {
    //         'Content-Type': 'application/json',
    //     },
    //     body: JSON.stringify({
    //         status: true,
    //     }),
    // })

    var descricao = document.getElementById('descricao').value;
            
            const dataAtual = new Date();
            const ano = dataAtual.getFullYear();
            const mes = (dataAtual.getMonth() + 1).toString().padStart(2, '0'); 
            const dia = dataAtual.getDate().toString().padStart(2, '0'); 
    
            
            const dataFormatada = `${ano}-${mes}-${dia}`;
    
            //console.log(dataFormatada); // Saída: "2024-05-13"

            let corpo = {
                descricao: descricao,
                data: dataFormatada,
                valorExtra: 0.0,
                aluguel: { id_aluguel: id_aluguel }
            }
           // console.log(corpo);

    fetch(`http://localhost:8080/problema`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(corpo),
    }).then(
        console.log(corpo),
        alert('Problema enviado com sucesso!'),
        
        window.location.href = "menuLocador.html"
    )
    .catch((error) => {
        console.error('Error:', error);
        alert('Erro ao enviar problema, verifique os campos!');
    });
})
