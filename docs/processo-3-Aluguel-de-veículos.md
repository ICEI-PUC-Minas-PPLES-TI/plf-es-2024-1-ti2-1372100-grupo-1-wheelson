### 3.3.3 Processo 3 – Aluguel de veículos

No processo de aluguel de veículos, o cliente inicialmente faz uma solicitação, e a agência verifica a disponibilidade do veículo desejado. Uma vez confirmada a disponibilidade, o cliente fornece informações pessoais e de pagamento, e a agência emite a confirmação da reserva junto com os detalhes do aluguel. Após receber as instruções, o cliente retira o veículo no local e data combinados. Ao término do período de uso, o cliente devolve o veículo no local previamente descrito.

![reserva atualizada](https://github.com/ICEI-PUC-Minas-PPLES-TI/plf-es-2024-1-ti2-1372100-grupo-1-wheelson/assets/135463549/4a2db5aa-c11a-4d61-85a2-4b88b3fb23f3)

#### Detalhamento das atividades

**Escolher veículo que deseja alugar**

| **Campo**             | **Tipo**         | **Restrições** | **Valor default** |
| ---                   | ---              | ---            | ---               |
| tipo de veículo       | ret, suv, sedã   |tipo            |                   |

| **Comandos**            |  **Destino**                         | **Tipo** |
| ---                     | ---                                  | ---      |
| Escolher tipo do veículo|Tela de verificação de disponibilidade| default  |

**Verificar se o veículo encontra-se  disponível**

| **Comandos**         |  **Destino**                   | **Tipo**            |
| ---                  | ---                            | ---                 |
| Disponível           | Prosseguir para escolher local de retirada e devolução   | default             |
| Indisponível         | Retornar para "Escolher veículo que deseja alugar" | default             |


**Escolher local de retirada e devolução**

| **Campo**             | **Tipo**          | **Restrições**                                    | **Valor default** |
| ---                   | ---               |    ---                                            | ---               |
| local                 |endereço completo  | Local não escolhido dentro das opções disponíveis |                   |

| **Comandos**                              | **Destino**                                       | **Tipo** |
| ---                                       | ---                                               | ---      |
| Escolher local (opções disponíveis)       | Página de revisão                                 | default  |
|                                           |                                                   |          |


**Revisar data, local, custos totais e horário de retirada**

| **Campo**       | **Tipo**         | **Restrições**                                 | **Valor default** |
| ---             | ---              | ---                                            | ---               |
| [Data]          | (dd-mm-aaaa)     |[qualquer um fora do tipo]                      | 00/00/0000        |
| [Local]         | Nome Local       |[qualquer não compatível com local selecionado] | default           |
| [Custos Totais] | 000,00           |[entre 0000,0 e 00,00]                          | 000,00            |
| [Horário]       | (hh:mm:ss)       |[qualquer um fora do tipo]                      | 00:00:00          |

| **Comandos**         |  **Destino**                   | **Tipo**            |
| ---                  | ---                            | ---                 |
| [Nome do botão/link] | Atividade/processo de destino  | (default/cancel/  ) |
| Validar informações  | Validar informações            |                     |


**Escolher forma de pagamento**

| **Comandos**         |  **Destino**                             | **Tipo**           |
| ---                  | ---                                      | ---                |
| [Nome do botão/link] | Atividade/processo de destino            | (default/cancel/  )|
| PIX                  | Tela de pagamento por pix                | default            |
| Cartão de crédito    | Tela de preenchimento de dados do cartão | default            |

**Preencher dados do cartão de crédito**

| **Campo**         | **Tipo**         | **Restrições**   | **Valor default** |
| ---               | ---              | ---              | ---               |
| [Nome do campo]   | [tipo de dados]  |                  |                   |
| Numero do cartão  | Caixa de texto   | 0000.0000.0000.00|                   |
| Data de vencimento| Caixa de texto   | 00/00/0000       |                   |
| Nome no titular   | Caixa de texto   |                  |                   |
| CVV               | Caixa de texto   | 000              |                   |
| CPF               | Caixa de texto   | 000.000.000-00   |                   |


| **Comandos**                |  **Destino**                   | **Tipo**            |
| ---                         | ---                            | ---                 |
| [Nome do botão/link]        | Atividade/processo de destino  | (default/cancel/  ) |
| Cadastrar cartão de crédito | Tela de confirmação            |                     |
| Realizar o pagamento via PIX| Tela de confirmação            |                     |
| Tela de confirmação         | Tela de confirmação            | cancel              |

**Concluir reserva**
| **Comandos**             |  **Destino**                   | **Tipo**            |
| ---                      | ---                            | ---                 |
| [Nome do botão/link]     | Atividade/processo de destino  | (default/cancel/  ) |
|         Aprovar          | Fim do processo                |                     |
|         Reprovar         | Cancela processo               | cancel              |

