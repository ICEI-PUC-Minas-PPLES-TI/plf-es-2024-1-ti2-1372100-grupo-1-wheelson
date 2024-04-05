### 3.3.1 Processo 1 – Gerenciamento de Clientes

É essencial para qualquer software deseja sempre se manter ativo, que seus usuários sejam identificados e verificados, assim mantendo uma boa segurança para seu sistema. Tendo em vista isso, o processo Gerenciamento de clientes visa controlar essa admissão dos usuários para uma plataforma mais segura e eficiente.


![gerenciamento-de-clientes](https://github.com/ICEI-PUC-Minas-PPLES-TI/plf-es-2024-1-ti2-1372100-grupo-1-wheelson/assets/129970038/5b7a3ec7-e7ee-4dde-9bb3-063603e66f28)


#### Detalhamento das atividades

_Descreva aqui cada uma das propriedades das atividades do processo 1. 
Devem estar relacionadas com o modelo de processo apresentado anteriormente._

_Os tipos de dados a serem utilizados são:_

_* **Área de texto** - campo texto de múltiplas linhas_

_* **Caixa de texto** - campo texto de uma linha_

_* **Número** - campo numérico_

_* **Data** - campo do tipo data (dd-mm-aaaa)_

_* **Hora** - campo do tipo hora (hh:mm:ss)_

_* **Data e Hora** - campo do tipo data e hora (dd-mm-aaaa, hh:mm:ss)_

_* **Imagem** - campo contendo uma imagem_

_* **Seleção única** - campo com várias opções de valores que são mutuamente exclusivas (tradicional radio button ou combobox)_

_* **Seleção múltipla** - campo com várias opções que podem ser selecionadas mutuamente (tradicional checkbox ou listbox)_

_* **Arquivo** - campo de upload de documento_

_* **Link** - campo que armazena uma URL_

_* **Tabela** - campo formado por uma matriz de valores_


**Nome da atividade 1**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| [Nome do campo] | [tipo de dados]  |                |                   |
| ***Exemplo:***  |                  |                |                   |
| login           | Caixa de Texto   | formato de e-mail |                |
| senha           | Caixa de Texto   | mínimo de 8 caracteres |           |

| **Comandos**         |  **Destino**                   | **Tipo** |
| ---                  | ---                            | ---               |
| [Nome do botão/link] | Atividade/processo de destino  | (default/cancel/  ) |
| ***Exemplo:***       |                                |                   |
| entrar               | Fim do Processo 1              | default           |
| cadastrar            | Início do proceso de cadastro  |                   |


**Nome da atividade 2**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| [Nome do campo] | [tipo de dados]  |                |                   |
|                 |                  |                |                   |

| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| [Nome do botão/link] | Atividade/processo de destino  | (default/cancel/  ) |
|                      |                                |                   |

**Escolher cadastro**

| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| [Nome do botão/link] | Atividade/processo de destino  | (default/cancel/  ) |
|    Cadastrar-se como Locador   |  Tela de cadastro de locador        |       |
| Cadastrar-se como Locatário | Tela de cadastro de locatário |     |
| Voltar | Retorna a página inicial  | cancel |

**Cadastro de Locatário**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| [Nome do campo] | [tipo de dados]  |                |                   |
|   Nome          |   Caixa de texto |                |                   |
|   CPF           | Caixa de texto   | 000.000.000-00 |                   |
| Data de nascimento | Data          |    00/00/0000  |                   |
|   E-mail        | Caixa de texto   |                |                   |
|   Telefone     | Número            | (00) 9 0000-0000 |                 |  
| Rua            | Caixa de texto  |                |                     |
| Bairro        | Caixa de texto  |                   |                   |
| Número         | Número            |                |                   |
| Cidade        | Caixa de seleção   |                |                   |
| UF            | Caixa de seleção   |                |                   |
| Foto do documento CNH        | Arquivo  |                |              |          
            

| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| [Nome do botão/link] | Atividade/processo de destino  | (default/cancel/  ) |
|   Enviar            |   Envia dados para Análise da documentação |       Default            |
| Voltar | Retorna para tela anterior | cancel |

**Cadastro de Locador**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| [Nome do campo] | [tipo de dados]  |                |                   |
|   Nome          |   Caixa de texto |                |                   |
|   CPF           | Caixa de texto   | 000.000.000-00 |                   |
| Data de nascimento | Data          |    00/00/0000  |                   |
|   E-mail        | Caixa de texto   |                |                   |
|   Telefone     | Número            | (00) 9 0000-0000 |                 |  
| Rua            | Caixa de texto  |                |                     |
| Bairro        | Caixa de texto  |                   |                   |
| Número         | Número            |                |                   |
| Cidade        | Caixa de seleção   |                |                   |
| UF            | Caixa de seleção   |                |                   |

| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| [Nome do botão/link] | Atividade/processo de destino  | (default/cancel/  ) |
|   Enviar            |  Envia dados para Tela de confirmação      |       Default            |
| Voltar | Retorna para tela anterior | cancel |



**Análise da documentação**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| [Nome do campo] | [tipo de dados]  |                |                   |
|   Nome          |   Caixa de texto |   Apenas visualização             |                   |
|   CPF           | Caixa de texto   | Apenas visualização|                   |
| Data de nascimento | Data          |   Apenas visualização  |                   |
|   E-mail        | Caixa de texto   |      Apenas visualização          |                   |
|   Telefone     | Número            | Apenas visualização |                 |  
| Rua            | Caixa de texto  |      Apenas visualização          |                     |
| Bairro        | Caixa de texto  |         Apenas visualização          |                   |
| Número         | Número            |         Apenas visualização       |                   |
| Cidade        | Caixa de seleção   |        Apenas visualização        |                   |
| UF            | Caixa de seleção   |        Apenas visualização        |                   |
| Foto do documento CNH        | Imagem  |      Apenas visualização          |              |         

| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| [Nome do botão/link] | Atividade/processo de destino  | (default/cancel/  ) |
| Proxima tarefa       | Tela de confirmação            |                 |

**Confirmação**
| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| [Nome do botão/link] | Atividade/processo de destino  | (default/cancel/  ) |
|         Aprovar          |      Fim do processo    |                   |
|         Reprovar         |    Cancela processo                  | cancel  |


