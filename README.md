# CREDIT ANALYSIS SYSTEM 
## Descrição

O presente projeto visa a implementação de uma API REST para cadastro de cliente e solicitação de empréstimos como solução pro desafio proposto pela empresa TQI em seu Bootcamp na plataforma da DIO.


## Desafio
Uma empresa de empréstimo precisa criar um sistema de análise de crédito para fornecer aos seus clientes as seguintes funcionalidades:

 i. Cadastro de clientes

* O cliente pode cadastrar: nome, e-mail, CPF, RG, endereço completo, renda e senha.
  
 ii. Login

* A autenticação será realizada por e-mail e senha.
  
 iii. Solicitação de empréstimo

* Para solicitar um empréstimo, precisamos do valor do empréstimo, data da primeira parcela e quantidade de parcelas.
* O máximo de parcelas será 60 e a data da primeira parcela deve ser no máximo 3 meses após o dia atual.
  
 iv. Acompanhamento das solicitações de empréstimo

* O cliente pode visualizar a lista de empréstimos solicitados por ele mesmo e também os detalhes de um de seus empréstimos.
* Na listagem, devemos retornar no mínimo o código do empréstimo, o valor e a quantidade de parcelas.
* No detalhe do empréstimo, devemos retornar: código do empréstimo, valor, quantidade de parcelas, data da primeira parcela, e-mail do cliente e renda do cliente.

## Tecnologias e ferramentas utilizadas no projeto
- Java 11
- Maven
- Spring Boot
- Spring Web
- Spring Security
- Spring JPA
- Validation
- Lombok
- ModelMapper
- H2 Database - Banco de dados em memória
- Visual Studio Code
- Thunder Client (plugin VS Code like Postman)
- Git e Github
  
  
# API Endpoints
Abaixo estão detalhados os Endpoints da API:

# Cadastro de Usuário

Para realizar o cadastro de novo cliente não é necessário estar logado no sistema, bastando somente enviar uma requisição POST com os dados do cliente e seu endereço conforme mostrado abaixo.

Obs: O campo username deve ser preenchido com um email válido.

## Requisição POST em http://localhost:8080/api/v1/clients
  
Exemplo padrão de dados formatados e obrigatórios:

Request Body:
```json
{
    "name":"rafa",
    "username":"rafael@gmail.com",
    "cpf":"01234567890",
    "rg":"027789654124",
    "income":5023.84,
    "password":"123",
    "address": {        
        "street": "Av. 04",
        "number": 48,
        "postalCode": 6500000,
        "city": "Sao Luis",
        "state": "Maranhao",
        "country": "Brazil"
    }  
}
```
# Solicitação de Empréstimo

Para a realização de solicitações de empréstimos é necessário que o cliente esteja logado, sendo necessário serem enviados os dados de Autorização Básica em cada requisição junto aos dados do empreśtimo conforme mostrado abaixo. É necessário também que sejam respeitadas as restrições de:

- Número máx. de parcelas: 60
- Data da primeira parcela ser no máximo 3 meses após a data atual


### Requisição POST em http://localhost:8080/api/v1/loans
Exemplo padrão de dados formatados e obrigatórios:

Request Body:
```json
{ 
    "amount":15000.85,
    "firstPaymentDate":"2022-02-20",
    "installmentsAmount":60
}
```

# Acompanhamento de solicitações de empréstimos realizadas
## Listar empréstimos solicitados

O cliente tem a opção de listar todas as suas solicitações de empréstimos e os mesmos serão apresentados de forma resumida conforme mostrado no exemplo abaixo.
### Requisição GET em http://localhost:8080/api/v1/loans

Response Body:
```json
[
  {
    "id": 1,
    "amount": 15563.60,
    "installmentsAmount": 48
  },
  {
    "id": 2,
    "amount": 54779.45,
    "installmentsAmount": 60
  }
]
```

## Detalhar individualmente empréstimo solicitado 
O cliente também tem a opção de detalhar seus empréstimos de forma individual substituindo no endpoint o {id} pelo código id do empréstimo desejado e o mesmo será apresentado de forma um pouco mais completa conforme mostrado no exemplo abaixo.
### Requisição GET em http://localhost:8080/api/v1/loans/{id}

Response Body:
```json
{
  "id": 2,
  "amount": 15000,
  "installmentsAmount": 60,
  "firstPaymentDate": "2022-02-20 00:00:00.0",
  "clientEmail": "rafael@gmail.com",
  "clientIncome": 4023.84
}
```

# Oportunidades de melhorias 
Algumas oportunidades de melhorias já identificadas a serem implementadas:
- Melhor tratamento de exceções
- Correção de BUGs
- Adicionar mais opções de gerenciamento de clientes e empréstimos (lado do )
- Testes Unitários (Junit, Mockito)
- Documentação da API (OpenAPI)
- JWT (Autenticação)
- Paginação
- Níveis de autorização (ADMIN, USER,...)
- Serviço de geração automática de parcelas utilizando regras de negócio
- Opção de busca de dados parciais de endereço via CEP automaticamente, visando preenchimento automático (API ViaCep)
- Diferentes ambientes (Test, Desenvolvimento, Produção)
- Conteinerização
  