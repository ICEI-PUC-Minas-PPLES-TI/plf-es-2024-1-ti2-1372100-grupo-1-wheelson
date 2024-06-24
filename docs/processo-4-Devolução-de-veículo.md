### 3.3.4 Processo 4 – Devolução de veículo

_Se consiste no processo de devoução de um veículo para o locador. Trata as medidas necessarias em caso de entrega do automóvel em condições piores do que na data inicial de aluguel._

![image](https://github.com/ICEI-PUC-Minas-PPLES-TI/plf-es-2024-1-ti2-1372100-grupo-1-wheelson/assets/129300086/d0b69828-0dfd-48ee-87e3-9fb15f913609)





#### Detalhamento das atividades



**Registrar no sistema uma descrição detalhada do problema**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| [Nome do campo] | [tipo de dados]  |                |                   |
|  Descrição      | Área de Texto    | Mínimo 30 caracteres |                |

| **Comandos**         |  **Destino**                   | **Tipo** |
| ---                  | ---                            | ---               |
| Enviar            | Envio para a equipe WheelsOn     | default           |


**Iniciar Devolução**


| **Comandos**         |  **Destino**                   | **Tipo** |
| ---                  | ---                            | ---               |
| [Nome do botão/link] | Atividade/processo de destino  | (default/cancel/  ) |
| Devolver veículo            | Tela inicial "menu locatário"    | default           |


**Registrar o valor extra a ser pago pelo proprietário**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| [Nome do campo] | [tipo de dados]  |                |                   |
| Valor               | Número       |                |                   |
| Descrição           | Área de texto       |                |                   |

| **Comandos**         |  **Destino**                   | **Tipo** |
| ---                  | ---                            | ---               |
| Enviar            | Envio para o locatário     | default           |



**Confirmar devolução**
| **Comandos**         |  **Destino**                   | **Tipo** |
| ---                  | ---                            | ---               |
| Confirmar devolução  |Fim do processo de aluguel    | default           |



















