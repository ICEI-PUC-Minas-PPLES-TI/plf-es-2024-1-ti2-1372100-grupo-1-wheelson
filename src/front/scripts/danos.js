const enviarbtn = document.getElementById('enviarbtn');


const urlParams = new URLSearchParams(window.location.search);
const id_aluguel = urlParams.get('id_aluguel');

enviarbtn.addEventListener('click', async (event) => {
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
            // Obter a data atual
            const dataAtual = new Date();

            // Extrair o ano, mês e dia
            const ano = dataAtual.getFullYear();
            // O mês é retornado de 0 a 11, então precisamos adicionar 1 para obter o valor correto
            const mes = (dataAtual.getMonth() + 1).toString().padStart(2, '0'); // Adiciona zero à esquerda se for menor que 10
            const dia = dataAtual.getDate().toString().padStart(2, '0'); // Adiciona zero à esquerda se for menor que 10
    
            // Formatar a data no formato desejado "xxxx-yy-zz"
            const dataFormatada = `${ano}-${mes}-${dia}`;
    
            console.log(dataFormatada); // Saída: "2024-05-13"
    fetch(`http://localhost:8080/problema`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            descricao: descricao,
            data: dataFormatada,
            valorExtra: null,
            aluguel: { id: id_aluguel }

        }),
    }).then(
        //alert dizendo que foi enviado com sucesso
        alert('Problema enviado com sucesso!'),
        
        window.location.href = "menuLocador.html"
    )
    .catch((error) => {
        console.error('Error:', error);
        alert('Erro ao enviar problema, verifique os campos!');
    });
})
