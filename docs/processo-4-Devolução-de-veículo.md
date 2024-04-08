### 3.3.4 Processo 4 – Devolução de veículo

_Se consiste no processo de devoução de um veículo para o locador. Trata as medidas necessarias em caso de entrega do automóvel em condições piores do que na data inicial de aluguel._

![image](https://github.com/ICEI-PUC-Minas-PPLES-TI/plf-es-2024-1-ti2-1372100-grupo-1-wheelson/assets/129300086/cc8d968b-a61c-4bdb-b573-8a29624fea2e)




#### Detalhamento das atividades



**Registro do problema na devolução**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| [Nome do campo] | [tipo de dados]  |                |                   |
|  Descrição      | Área de Texto    | Mínimo 30 caracteres |                |

**Finalização do aluguel**


| **Comandos**         |  **Destino**                   | **Tipo** |
| ---                  | ---                            | ---               |
| [Nome do botão/link] | Atividade/processo de destino  | (default/cancel/  ) |
| Finalizar aluguel            | Fim do Processo de devolução     | default           |


**Registro do valor extra a ser pago**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| [Nome do campo] | [tipo de dados]  |                |                   |
| Valor               | Número       |                |                   |

**Escolher froma de pagamento**

| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| [Nome do botão/link] | Atividade/processo de destino  | (default/cancel/  ) |
| PIX                  | Tela de pagamento por pix      | default                  |
|   Cartão de crédito |  Tela de preenchimento de dados do cartão| default       |

**Preencher dados do cartão de crédito**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| [Nome do campo] | [tipo de dados]  |                |                   |
|  Nome do titular  | Caixa de texto  |                |                   |
|  Número do cartão     |    Número   |0000 0000 0000 0000    |                   |
|   Data de validade  |    Data        |   00/00/0000       |                   |
|  CVV               |    Número              |3 dígitos                |           |
|CPF ou CNPJ do titular   |Caixa de texto   |      formato de CPF ou CNPJ          |   |


















