### 3.3.4 Processo 4 – Devolução de veículo

_Se consiste no processo de devoução de um veículo para o locador. Trata as medidas necessarias em caso de entrega do automóvel em condições piores do que na data inicial de aluguel._

![image](https://github.com/ICEI-PUC-Minas-PPLES-TI/plf-es-2024-1-ti2-1372100-grupo-1-wheelson/assets/129300086/248b516d-fed0-4759-b77a-9d6e1efd4316)




#### Detalhamento das atividades



**Registrar no sistema uma descrição detalhada do problema**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| [Nome do campo] | [tipo de dados]  |                |                   |
|  Descrição      | Área de Texto    | Mínimo 30 caracteres |                |

| **Comandos**         |  **Destino**                   | **Tipo** |
| ---                  | ---                            | ---               |
| Enviar            | Envio para a equipe WheelsOn     | default           |


**Finalizar aluguel**


| **Comandos**         |  **Destino**                   | **Tipo** |
| ---                  | ---                            | ---               |
| [Nome do botão/link] | Atividade/processo de destino  | (default/cancel/  ) |
| Finalizar aluguel            | Fim do Processo de devolução     | default           |


**Registrar o valor extra a ser pago pelo proprietário**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| [Nome do campo] | [tipo de dados]  |                |                   |
| Valor               | Número       |                |                   |
| Descrição           | Área de texto       |                |                   |

| **Comandos**         |  **Destino**                   | **Tipo** |
| ---                  | ---                            | ---               |
| Enviar            | Envio para o locatário     | default           |

**Escolher forma de pagamento (cartão de crédito ou pix)**

| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| [Nome do botão/link] | Atividade/processo de destino  | (default/cancel/  ) |
| PIX                  | Tela de pagamento por pix      | default                  |
|   Cartão de crédito |  Tela de preenchimento de dados do cartão| default       |

**Preencher dados do cartão de crédito e realizar pagamento**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| [Nome do campo] | [tipo de dados]  |                |                   |
|  Nome do titular  | Caixa de texto  |                |                   |
|  Número do cartão     |    Número   |0000 0000 0000 0000    |                   |
|   Data de validade  |    Data        |   00/00/0000       |                   |
|  CVV               |    Número              |3 dígitos                |           |
|CPF ou CNPJ do titular   |Caixa de texto   |      formato de CPF ou CNPJ          |   |

| **Comandos**         |  **Destino**                   | **Tipo** |
| ---                  | ---                            | ---               |
| Realizar pagamento   |Tela de finalização do aluguel    | default           |



















