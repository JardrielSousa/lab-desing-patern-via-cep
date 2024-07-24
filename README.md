# lab-desing-patern-via-cep

# ClienteRestController

## Descrição
O `ClienteRestController` é um controlador REST que gerencia operações relacionadas a clientes em uma aplicação Spring Boot. Ele fornece endpoints para criar, ler, atualizar e deletar (CRUD) informações sobre clientes.

## Endpoints

### 1. `GET /clientes`
- **Descrição**: Retorna uma lista de todos os clientes.
- **Método HTTP**: `GET`
- **URL**: `/clientes`
- **Retorno**:
  - **Código de Status**: `200 OK`
  - **Tipo de Conteúdo**: `application/json`
  - **Corpo da Resposta**:
    ```json
    [
      {
        "id": 1,
        "nome": "Cliente 1",
        "email": "cliente1@example.com"
      },
      {
        "id": 2,
        "nome": "Cliente 2",
        "email": "cliente2@example.com"
      }
    ]
    ```

### 2. `GET /clientes/{id}`
- **Descrição**: Retorna um cliente específico com base no ID fornecido.
- **Método HTTP**: `GET`
- **URL**: `/clientes/{id}`
- **Parâmetros**:
  - **Path Variable**:
    - `id`: ID do cliente a ser buscado (do tipo `Long`).
- **Retorno**:
  - **Código de Status**: `200 OK`
  - **Tipo de Conteúdo**: `application/json`
  - **Corpo da Resposta**:
    ```json
    {
      "id": 1,
      "nome": "Cliente 1",
      "email": "cliente1@example.com"
    }
    ```
  - **Código de Status**: `404 Not Found`
  - **Descrição**: Cliente não encontrado.

### 3. `POST /clientes`
- **Descrição**: Insere um novo cliente.
- **Método HTTP**: `POST`
- **URL**: `/clientes`
- **Parâmetros**:
  - **Request Body**:
    ```json
    {
      "nome": "Novo Cliente",
      "email": "novocliente@example.com"
    }
    ```
- **Retorno**:
  - **Código de Status**: `200 OK`
  - **Tipo de Conteúdo**: `application/json`
  - **Corpo da Resposta**:
    ```json
    {
      "id": 3,
      "nome": "Novo Cliente",
      "email": "novocliente@example.com"
    }
    ```
  - **Código de Status**: `400 Bad Request`
  - **Descrição**: Dados inválidos.

### 4. `PUT /clientes/{id}`
- **Descrição**: Atualiza um cliente existente.
- **Método HTTP**: `PUT`
- **URL**: `/clientes/{id}`
- **Parâmetros**:
  - **Path Variable**:
    - `id`: ID do cliente a ser atualizado (do tipo `Long`).
  - **Request Body**:
    ```json
    {
      "nome": "Cliente Atualizado",
      "email": "clienteatualizado@example.com"
    }
    ```
- **Retorno**:
  - **Código de Status**: `200 OK`
  - **Tipo de Conteúdo**: `application/json`
  - **Corpo da Resposta**:
    ```json
    {
      "id": 1,
      "nome": "Cliente Atualizado",
      "email": "clienteatualizado@example.com"
    }
    ```
  - **Código de Status**: `404 Not Found`
  - **Descrição**: Cliente não encontrado.
  - **Código de Status**: `400 Bad Request`
  - **Descrição**: Dados inválidos.

### 5. `DELETE /clientes/{id}`
- **Descrição**: Deleta um cliente existente.
- **Método HTTP**: `DELETE`
- **URL**: `/clientes/{id}`
- **Parâmetros**:
  - **Path Variable**:
    - `id`: ID do cliente a ser deletado (do tipo `Long`).
- **Retorno**:
  - **Código de Status**: `200 OK`
  - **Descrição**: Indica que a operação foi bem-sucedida.
  - **Código de Status**: `404 Not Found`
  - **Descrição**: Cliente não encontrado.

## Anotações

- `@RestController`: Indica que esta classe é um controlador REST.
- `@RequestMapping("clientes")`: Define o endpoint base para todas as operações relacionadas a clientes.
- `@Autowired`: Injeta a dependência do serviço `ClienteService` para utilização dentro do controlador.

## Dependências

- **ClienteService**: Serviço responsável pelas operações de negócio relacionadas aos clientes.
- **Cliente**: Modelo que representa a entidade Cliente.

## Exemplos de Uso

Aqui estão alguns exemplos de como você pode interagir com os endpoints deste controlador usando `curl`:

1. **Listar todos os clientes**:
    ```bash
    curl -X GET http://localhost:8080/clientes
    ```

2. **Buscar um cliente por ID**:
    ```bash
    curl -X GET http://localhost:8080/clientes/1
    ```

3. **Inserir um novo cliente**:
    ```bash
    curl -X POST http://localhost:8080/clientes -H "Content-Type: application/json" -d '{"nome": "Novo Cliente", "email": "novocliente@example.com"}'
    ```

4. **Atualizar um cliente existente**:
    ```bash
    curl -X PUT http://localhost:8080/clientes/1 -H "Content-Type: application/json" -d '{"nome": "Cliente Atualizado", "email": "clienteatualizado@example.com"}'
    ```

5. **Deletar um cliente**:
    ```bash
    curl -X DELETE http://localhost:8080/clientes/1
    ```

## Autor

Projeto baseado pela DIO Cursos e implementado por Jardriel Sousa .
