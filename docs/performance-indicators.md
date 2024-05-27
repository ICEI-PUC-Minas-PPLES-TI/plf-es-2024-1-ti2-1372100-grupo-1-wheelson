## 5. Indicadores de desempenho

_Apresente aqui os principais indicadores de desempenho e algumas metas para o processo. Atenção: as informações necessárias para gerar os indicadores devem estar contempladas no modelo relacional. Defina no mínimo 3 indicadores._

_Usar o seguinte modelo:_

| **Indicador** | **Objetivos** | **Descrição** | **Fonte de dados** | **Fórmula de cálculo** |
| ---           | ---           | ---           | ---             | ---             |
| Percentual de reclamações | Avaliar quantitativamente as reclamações | Percentual de reclamações em relação ao total atendimento | Tabela reclamações | número total de reclamações / número total de atendimentos |
| Taxa de requisições atendidas | Melhorar a prestação de serviços medindo a porcentagem de requisições atendidas| Mede a % de requisições atendidas na semana | Tabela solicitações | (número de requisições atendidas / número total de requisições) * 100 |
| Taxa de entrega de material | Manter controle sobre os materiais que estão sendo entregues | Mede % de material entregue dentro do mês | Tabela pedidos | (número de pedidos entregues / número total de pedidos) * 100 |



PROCESSO 1:

| **Indicador** | **Objetivos** | **Descrição** | **Fonte de dados** | **Fórmula de cálculo** |
| ---           | ---           | ---           | ---             | ---             |
| Percentual de Usuários novos| Avaliar crescimento do Sistema | Percentual de usuários novos no mês em relação à todos os cadastrados | Tabela Locador e Locatário | (Locadores novos no mês + Locatários novos no mês) / Quantidade de usuários cadastrados(locador+locatário) * 100 |
|Taxa de Aprovação de Usuários|	Avaliar a eficiência do processo de verificação|	Percentual de usuários aprovados em relação ao total de usuários cadastrados no mês|	Tabela Locador e Locatário|	(Número de usuários aprovados no mês / Número total de usuários cadastrados no mês) * 100|
|Tempo Médio de Cadastro|	Melhorar a eficiência do processo de cadastro|	Média de tempo que um usuário leva desde o início do cadastro até a aprovação|	Tabela Locador e Locatário|	(Data de aprovação - Data de início do cadastro) / Número total de usuários cadastrados|

PROCESSO 4:
| **Indicador** | **Objetivos** | **Descrição** | **Fonte de dados** | **Fórmula de cálculo** |
| ---           | ---           | ---           | ---             | ---             |
| Percentual de devoluções  com danos  | Avaliar quantitativamente as devoluções de carros danificados| Percentual de devoluções com danos em relação ao total de devoluções  |Tabela problema|número total de devoluções com danos / número total de devoluções| 
| Percentual de devoluções sem problemas  |Avaliar quantitativamente as devoluções de carros devolvidos sem danos| Percentual de devoluções sem danos em relação ao total de devoluções  |Tabela aluguel|número total de devoluções sem danos / número total de devoluções| 
|Percentual dos valores extras a serem pagos maiores que 1000 reais|Manter controle sobre os carros que foram devolvidos com danos significativos.|Mede % de problemas devolução com valor superior a 1000 reais   |Tabela problema|(numero de problemas com valor extra maior que 1000 reais / numero total de problemas| 



_Obs.: todas as informações para gerar os indicadores devem estar no modelo relacional._
