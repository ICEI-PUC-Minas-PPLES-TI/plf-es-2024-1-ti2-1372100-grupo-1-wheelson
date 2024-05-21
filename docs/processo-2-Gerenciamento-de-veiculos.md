### 3.3.2 Processo 2 – Gerenciamento de veiculo

Um processo eficiente de gerenciamento de veículos é fundamental para garantir a disponibilidade e qualidade da frota de uma locadora de veículos. O processo de Gerenciamento de Veículos visa controlar o cadastramento e a disponibilidade dos veículos para garantir que a locadora possa atender às demandas dos clientes de forma segura e eficaz.


![gerenciamento de veiculo](https://github.com/ICEI-PUC-Minas-PPLES-TI/plf-es-2024-1-ti2-1372100-grupo-1-wheelson/assets/89420964/4b296ff4-0fd6-4f0e-9eb7-815acd36cdaa)



#### Detalhamento das atividades
<!--
_Descreva aqui cada uma das propriedades das atividades do processo 2. 
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
-->
**Enviar certificado de Registro de Veiculo (CRV) ou Recibo de compra e venda**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| Cadastrar RENAVAM  | Text          |                |                   |


| **Comandos**         |  **Destino**                   | **Tipo** |
| ---                  | ---                            | ---               |
| [Nome do botão/link] | Atividade/processo de destino  | (default/cancel/  ) |
| Enviar RENAVAM           | Validar documentação           |                   |



**Enviar informações do carro**

| **Campo**       | **Tipo**         | **Restrições** | **Valor default** |
| ---             | ---              | ---            | ---               |
| Placa           | Caixa de texto   |sem caracteres especiais|     0000000       |
| Modelo          | Caixa de texto   |                |                   |
| Ano de fabricação| Data            |                |                   |
| Valor Diário| Número            |       R$00,00         |                   |


| **Comandos**         |  **Destino**                   | **Tipo**          |
| ---                  | ---                            | ---               |
| [Nome do botão/link] | Atividade/processo de destino  | (default/cancel/  ) |
| Enviar informações   |  Validar informações           |                   |



