### 3.3.3 Processo 3 – Reserva de veículo

No processo de reservas de veículos, o cliente inicialmente faz uma solicitação, e a agência verifica a disponibilidade do veículo desejado. Uma vez confirmada a disponibilidade, o cliente fornece informações pessoais e de pagamento, e a agência emite a confirmação da reserva junto com os detalhes do aluguel. Após receber as instruções, o cliente retira o veículo no local e data combinados. Ao término do período de uso, o cliente devolve o veículo à agência.


![reserva atualizada](https://github.com/ICEI-PUC-Minas-PPLES-TI/plf-es-2024-1-ti2-1372100-grupo-1-wheelson/assets/135463549/aff83f06-1aea-4a52-a127-b5622b52f563)


#### Detalhamento das atividades

**Enviar foto da CNH**

| **Campo**             | **Tipo**         | **Restrições** | **Valor default** |
| ---                   | ---              | ---            | ---               |
| [enviar arquivo]      | [jpeg] [pdf]     |[photoshop][png]|                   |
| ***Exemplo:***        |                  |                |                   |
| arquivo               | pdf              |[photoshop][png]|                   |

| **Comandos**         |  **Destino**                   | **Tipo** |
| ---                  | ---                            | ---                 |
| [Nome do botão/link] | Atividade/processo de destino  | (default/cancel/  ) |
| ***Exemplo:***       |                                |                     |
| Enviar CRV           | Validar documentação           | default             |

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
