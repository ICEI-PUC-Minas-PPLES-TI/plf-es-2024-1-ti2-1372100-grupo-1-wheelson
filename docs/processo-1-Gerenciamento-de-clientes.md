### 3.3.1 Processo 1 – Gerenciamento de Clientes

É essencial para qualquer software deseja sempre se manter ativo, que seus usuários sejam identificados e verificados, assim mantendo uma boa segurança para seu sistema. Tendo em vista isso, o processo Gerenciamento de clientes visa controlar essa admissão dos usuários para uma plataforma mais segura e eficiente.


![gerenciamento-de-clientes](https://github.com/ICEI-PUC-Minas-PPLES-TI/plf-es-2024-1-ti2-1372100-grupo-1-wheelson/assets/129970038/864c8836-f91e-4892-bb9a-f4a59fbc80d9)



#### Detalhamento das atividades


**Escolher como deve se cadastrar**

| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
|    Locar um veículo   |  Tela de cadastro de locador        |       |
| Alugar um veículo | Tela de cadastro de locatário |     |
| Voltar | Retorna a página inicial  | cancel |

**Cadastrar dados como locatário**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
|   Nome Completo         |   Caixa de texto |                |                   |
|   E-mail        | Caixa de texto   |                |                   |
|   Telefone     | Número            | (00) 9 0000-0000 |                 |  
| Data de nascimento | Data          |    00/00/0000  |                   |
| Rua            | Caixa de texto  |                |                     |
| Bairro        | Caixa de texto  |                   |                   |
| Número         | Número            |                |                   |
| Cidade        | Caixa de seleção   |                |                   |
| UF            | Caixa de seleção   |                |                   |
|   CPF           | Caixa de texto   | 000.000.000-00 |                   |
| Registro documento CNH        | Caixa de texto  |                |              |   
| Senha        | Caixa de texto  |                   |                   |       
            

| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
|   Enviar            |   Envia dados para Analisar documentação |       Default            |
| Voltar | Retorna para tela anterior | cancel |

**Cadastrar dados como locador**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
|   Nome Completo         |   Caixa de texto |                |                   |
|   CPF           | Caixa de texto   | 000.000.000-00 |                   |
| Data de nascimento | Data          |    00/00/0000  |                   |
|   E-mail        | Caixa de texto   |                |                   |
|   Telefone     | Número            | (00) 9 0000-0000 |                 |  
| Rua            | Caixa de texto  |                |                     |
| Bairro        | Caixa de texto  |                   |                   |
| Número         | Número            |                |                   |
| Cidade        | Caixa de seleção   |                |                   |
| UF            | Caixa de seleção   |                |                   |
|Senha        | Caixa de texto  |                   |                   |

| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
|   Enviar            |  Volta para o Menu principal      |       Default            |
| Voltar | Retorna para tela anterior | cancel |



**Analisar documentação**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
|   Nome          |   Caixa de texto |   Apenas visualização             |                   |
| N° de registro CNH | Caixa de texto | Apenas visualização |                   |       
|   CPF           | Caixa de texto   | Apenas visualização|                   |



**Atualizar status do usuário**
| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
|         Aprovar          |    Aprova usuário e Fim do processo    |                   |



