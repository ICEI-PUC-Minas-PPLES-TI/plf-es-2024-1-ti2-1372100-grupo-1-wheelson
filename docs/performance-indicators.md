## 5. Indicadores de desempenho
<!--
_Apresente aqui os principais indicadores de desempenho e algumas metas para o processo. Atenção: as informações necessárias para gerar os indicadores devem estar contempladas no modelo relacional. Defina no mínimo 3 indicadores._

_Usar o seguinte modelo:_

| **Indicador** | **Objetivos** | **Descrição** | **Fonte de dados** | **Fórmula de cálculo** |
| ---           | ---           | ---           | ---             | ---             |
| Percentual de reclamações | Avaliar quantitativamente as reclamações | Percentual de reclamações em relação ao total atendimento | Tabela reclamações | número total de reclamações / número total de atendimentos |
| Taxa de requisições atendidas | Melhorar a prestação de serviços medindo a porcentagem de requisições atendidas| Mede a % de requisições atendidas na semana | Tabela solicitações | (número de requisições atendidas / número total de requisições) * 100 |
| Taxa de entrega de material | Manter controle sobre os materiais que estão sendo entregues | Mede % de material entregue dentro do mês | Tabela pedidos | (número de pedidos entregues / número total de pedidos) * 100 |

-->
<!--
PROCESSO 1:

| **Indicador** | **Objetivos** | **Descrição** | **Fonte de dados** | **Fórmula de cálculo** |
| ---           | ---           | ---           | ---             | ---             |
| Percentual de Usuários novos| Avaliar crescimento do Sistema | Percentual de usuários novos no mês em relação à todos os cadastrados | Tabela Locador e Locatário | (Locadores novos no mês + Locatários novos no mês) / Quantidade de usuários cadastrados(locador+locatário) * 100 |
|Taxa de Aprovação de Usuários|	Avaliar a eficiência do processo de verificação|	Percentual de usuários aprovados em relação ao total de usuários cadastrados no mês|	Tabela Locador e Locatário|	(Número de usuários aprovados no mês / Número total de usuários cadastrados no mês) * 100|
|Tempo Médio de Cadastro|	Melhorar a eficiência do processo de cadastro|	Média de tempo que um usuário leva desde o início do cadastro até a aprovação|	Tabela Locador e Locatário|	(Data de aprovação - Data de início do cadastro) / Número total de usuários cadastrados|

PROCESSO 2:

| **Indicador**                        | **Objetivos**                                              | **Descrição**                                                            | **Fonte de Dados**                 | **Fórmula de Cálculo**                                                              |
| ------------------------------------ | ---------------------------------------------------------- | ------------------------------------------------------------------------ | --------------------------------- | ------------------------------------------------------------------------------------ |
| Taxa de Cadastros Bem-Sucedidos      | Assegurar eficácia do processo de verificação e cadastro do veículo | Percentual de veículos cadastrados após todas as verificações em relação ao total de tentativas de cadastro | Tabela Cadastro de Veículos       | (Número de cadastros bem-sucedidos / Número total de tentativas de cadastro) * 100   |
| Tempo Médio de Cadastro de Veículo   | Reduzir o tempo necessário para o cadastro completo do veículo | Média de tempo desde o envio do código RENAVAN até o final do cadastro | Tabela Cadastro de Veículos       | (Somatório de (Data/hora de conclusão - Data/hora de início) / Número total de cadastros concluídos) |
| Taxa de Comunicações de Erro         | Melhorar a comunicação em casos de erro durante o processo | Percentual de e-mails enviados em casos de não permissão para seguir com o processo em relação ao total de processos com erros | Tabela Comunicações de Erro      | (Número de e-mails enviados / Número total de processos com erros) * 100             |
-->

PROCESSO 3:
| **Indicador**                        | **Objetivos**                                               | **Descrição**                                                              | **Fonte de Dados**                   | **Fórmula de Cálculo**                                                                 |
| ------------------------------------ | ----------------------------------------------------------- | -------------------------------------------------------------------------- | ----------------------------------- | -------------------------------------------------------------------------------------- |
| Taxa de reservas feitas no mês        |Analisar alcance e efetividade do sistema | Percentual de reservas feitas no mês em relação com todas as outras reservas já efetuadas na vida útil do sistema | Tabela Aluguel               | (Número de reservas realizadas / Número total de reservas) * 100         |
| Duração média das reservas | Avaliar a duração média dos alugueis realizados, analisando o tempo que usuários costumam alugar um veículo |Tempo médio entre o inicio e fim de um aluguel | Tabela Aluguel           | Média de (Data e hora da reserva / Data e hora do final da reserva)          |
| Frequência de Aluguel por Veículo    | Avaliar a utilização do inventário de veículos               | Média de vezes que cada veículo é alugado em um determinado período        | Tabela de Histórico de Aluguel      | Total de aluguéis por veículo / Número total de veículos                                |

<!--
PROCESSO 4:
| **Indicador** | **Objetivos** | **Descrição** | **Fonte de dados** | **Fórmula de cálculo** |
| ---           | ---           | ---           | ---             | ---             |
| Percentual de devoluções  com danos  | Avaliar quantitativamente as devoluções de carros danificados| Percentual de devoluções com danos em relação ao total de devoluções  |Tabela problema|número total de devoluções com danos / número total de devoluções| 
| Percentual de devoluções sem problemas  |Avaliar quantitativamente as devoluções de carros devolvidos sem danos| Percentual de devoluções sem danos em relação ao total de devoluções  |Tabela aluguel|número total de devoluções sem danos / número total de devoluções| 
|Percentual dos valores extras a serem pagos maiores que 1000 reais|Manter controle sobre os carros que foram devolvidos com danos significativos.|Mede % de problemas devolução com valor superior a 1000 reais   |Tabela problema| numero de problemas com valor extra maior que 1000 reais / numero total de problemas| 
-->


_Obs.: todas as informações para gerar os indicadores devem estar no modelo relacional._
