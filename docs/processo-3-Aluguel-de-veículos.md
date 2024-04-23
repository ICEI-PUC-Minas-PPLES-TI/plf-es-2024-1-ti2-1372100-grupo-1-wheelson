### 3.3.3 Processo 3 – Aluguel de veículos

No processo de aluguel de veículos, o cliente inicialmente faz uma solicitação, e a agência verifica a disponibilidade do veículo desejado. Uma vez confirmada a disponibilidade, o cliente fornece informações pessoais e de pagamento, e a agência emite a confirmação da reserva junto com os detalhes do aluguel. Após receber as instruções, o cliente retira o veículo no local e data combinados. Ao término do período de uso, o cliente devolve o veículo no local previamente descrito.

![reserva tis](https://github.com/ICEI-PUC-Minas-PPLES-TI/plf-es-2024-1-ti2-1372100-grupo-1-wheelson/assets/135463549/8643cc08-4265-4194-813a-0e448e89061c)

#### Detalhamento das atividades


**Escolher veículo que deseja alugar**

| **Campo**             | **Tipo**         | **Restrições** | **Valor default** |
| ---                   | ---              | ---            | ---               |
| Pesquisar             |   Caixa de texto |                |                   |

| **Comandos**            |  **Destino**                         | **Tipo** |
| ---                     | ---                                  | ---      |
|  Pesquisar              | Filtrar veículos disponíveis         |          |
| Escolher veículo        |Tela de exibição de disponibilidade do veículo| default  |

**Verificar se o veículo encontra-se  disponível**

| **Comandos**         |  **Destino**                   | **Tipo**            |
| ---                  | ---                            | ---                 |
| Disponível           | Prosseguir para escolher local de retirada e devolução   | default             |
| Indisponível         | Retornar para "Escolher veículo que deseja alugar" | default             |


**Ponto de encontro**

| **Campo**             | **Tipo**          | **Restrições**                                    | **Valor default** |
| ---                   | ---               |    ---                                            | ---               |
| Data e Hora da retirada          | Data e hora         |               |        |
| Data e hora da devolução         | Data e hora            |               |        |
| Rua             | Caixa de texto       |                         |            |
| Bairro             | Caixa de texto       |                         |            |
| Ponto de referência      | Área de texto      |                         |            |
| [Custos Totais] | Número         |[entre 0000,0 e 00,00]  -                         |             |

| **Comandos**                              | **Destino**                                       | **Tipo** |
| ---                                       | ---                                               | ---      |
| Escolher local                            | Página de revisão                                 | default  |



**Revisar data, local, custos totais e horário de retirada**

| **Campo**       | **Tipo**         | **Restrições**                                 | **Valor default** |
| ---             | ---              | ---                                            | ---               |
| Data e Hora da retirada          | Data e hora         |       Apenas visualização        |        |
| Data e hora da devolução         | Data e hora            |       Apenas visualização        |        |
| Rua             | Caixa de texto       |      Apenas visualização                   |            |
| Bairro             | Caixa de texto       |      Apenas visualização                   |            |
| Ponto de referência      | Área de texto      |      Apenas visualização                   |            |
| [Custos Totais] | Número         |[entre 0000,0 e 00,00]  - Apenas visualização                        |             |


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

