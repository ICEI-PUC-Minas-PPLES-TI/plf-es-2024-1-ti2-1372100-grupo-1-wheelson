# Rotas de usuário
## Locador 
| Método | Rota                       | Descrição                                                          |
| ------ | -------------------------- | ------------------------------------------------------------------ |
| GET   | `/locador/{id}`                   | Recebe um locador pelo ID                                             |
| GET   | `/locador`                   | Recebe todos os locadores                                           |
| GET   | `/locador/status/false`                   | Recebe todos os locadores com status false                         |
| GET   | `/locador/email/{email}`                   | Recebe um locador pelo email                                       |
| GET   | `/locador/login/{email}/{senha}`                   | Recebe um locador pelo email e senha                                       |
| POST  | `/locador`                   | Cadastra um locador                                           |
| PUT  | `/locador/{id}`                   | Altera os dados de um locador                                           |
| DELETE  | `/locador{id}`                   | Apaga o perfil de um Locador                                        |

## Locatário
| Método | Rota                       | Descrição                                                          |
| ------ | -------------------------- | ------------------------------------------------------------------ |
| GET   | `/locatario/{id}`                   | Recebe um locatário pelo ID                                       |
| GET   | `/locatario`                   | Recebe todos os locatários                                           |
| GET   | `/locatario/status/false`                   | Recebe todos os locatários com status false              |
| GET   | `/locatario/email/{email}`                   | Recebe um locatário pelo email                                       |
| GET   | `/locatario/login/{email}/{senha}`                   | Recebe um locatário pelo email e senha
| POST  | `/locatario`                   | Cadastra um locatário                                           |
| PUT  | `/locatario/{id}`                   | Altera os dados de um locatário                                           |
| DELETE  | `/locatario/{id}`                   | Apaga o perfil de um Locatário                                        |

## Carro
| Método | Rota                       | Descrição                                                          |
| ------ | -------------------------- | ------------------------------------------------------------------ |
| GET   | `/carro/{id}`                   | Retorna um carro específico baseado no seu ID                                     |
| GET   | `/carro/all`                   | Retorna uma lista com todos os carros|
| GET  | `/carro/locador/{id}`                   |  Retorna uma lista de carros baseados no ID do locador                                           |
| POST   | `/carro`                   | Cria um novo carro                                           |
| PUT   | `/carro/{id}`                   | Atualiza um carro existente baseado no ID fornecido            |
| DELETE   | `/carro/{id}`                   | Deleta um carro baseado no ID fornecido                                       |


