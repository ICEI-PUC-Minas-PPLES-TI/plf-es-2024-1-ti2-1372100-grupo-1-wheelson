// const output = _system._organization.getPermalink({_id: _pin._id, _classId: _pin._classId, appIdentifier: 'main'});
// const permalink = output.permalink;



// let objetoEmail = {};
// let objetoEmailCurso = [];
// let nomeDoAluno = _pin.aluno.name;
 
// _pin.cursos.forEach(curso => {
//     objetoEmailCurso.push({
//         "nomeDoCurso": curso.nome,
//         "precoDoCurso": curso.preco,
//         "duracaoDoCurso": curso.duracao
//     });
//     }

// );
 
//  let infosCursos = ""; 
//  objetoEmailCurso.forEach(curso => {
//      infosCursos += " Nome: " + curso.nomeDoCurso + ", "; 
//      infosCursos += "Preço: R$" + curso.precoDoCurso + ", ";
//      infosCursos += "Duração: " + curso.duracaoDoCurso + " minutos ";
//      infosCursos += " || ";
//  });
 

//  throw _utils.stringifyAsJson(objetoEmailCurso)
// const mustache = require('mustache');


// const view = {
//     nomeLocador: "RENATOOOOOOOOO",
//     cursos: "AAAAAAAAAAAAA" 
//     };


// _ecm._mailbox.send({
//   // Identificadorou _id da caixa de e-mail criada (objeto em ECM > Mailbox / Caixa de e-mail)
//   mailbox: 'mailboxGabrielleLira',
//   email: {
//     // Remetente do email. Opcional, se não informado será
//     // utilizado o remetente padrão configurado na mailbox
//     from: 'WhellsOn@gmail.com',
//     // Destinatários do e-mail separados por vírgula / COLOCAR O EMAIL DO LOCATARIO NO FUTURO
//     to: 'locatario@gmail.com',
//     subject: "Boleto - Matrícula",		
//     // Conteúdo HTML do corpo do e-mail
//     htmlBody: mustache.render(corpoDoEmail, view),
//     // Lista de anexos (opcional). Referência a campos do tipo 'Arquivo'
//     attachments: [
      
//         _pin.boleto.boletoArquivo
      
//     ]
//   }
// });


function fetchSendEmail(){
    var subject = "Boleto - Aluguel";
    var to = "locatario@gmail.com";
    
    const corpoDoEmail = "<div style='margin: 3% 5%; max-width: 90%; padding: 0 2%;'><img src='https://ci3.googleusercontent.com/meips/ADKq_NacE-q11DYiraIk0KirmhyhsjaEG-kVmKERQyVQ2R0Ut_USXJ3d7hRT77PBlS1vThmbwxRaEdSKmZakB2lB8V_w8ns=s0-d-e1-ft#https://levty.com/images/brand/levty-logo.png' alt='LEVTY' style='width:15%;height:auto;margin-left:5%' class='CToWUd' data-bit='iit'><hr><b>'Olá, {{nomeLocador}}!'</b><p>Estamos muito felizes com seu interesse pelos cursos:</p><br>{{cursos}}!<br> <br>Falta pouco para que tenha acesso ao conteúdo, basta pagar o boleto anexado</p><p>Após efetuar o pagamento, favor enviar o comprovante em nosso sistema, na página: <a href={{}}>Enviar comprovante de pagamento</a><p>Atenciosamente, LEVTY - Cursos</p><small>E-mail automático enviado pelo Processo Matrícula em Curso. Favor não responder. Caso tenha dúvidas, entre em contato com o suporte (11) 97227-2618</small><hr><div style='display: flex; align-items: center;'><img src='https://levty.com/images/brand/og-image-wide.png' jsaction='VQAsE' class='sFlh5c pT0Scc iPVvYb' style='max-width: 8%; height: auto; width: 20%;' alt='Trainee 2024 | LEVTY' jsname='kn3ccd' aria-hidden='false'><div style='border-left: 1px solid black; padding-left: 1%; margin-left: 1%;'><a href='https://levty.com/br'>levty.com</a></div></div></div>";
   const email = {
    to: to,
    subject: subject,
    body: corpoDoEmail,
   }
   
   var response = fetch(`http://localhost:8080/send-email`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(email),
    }).then( 
        console.log(email),
        
    )
    .catch((error) => {
        console.error('Error:', error);
        alert('Erro ao enviar problema, verifique os campos!');
    });
    console.log(response);
}
