# DsCommerce API 👩‍💻

Este projeto foi realizado durante o curso Spring Boot Professional da Dev Superior, ministrado pelo professor Nélio Alves.  
Neste projeto, foi possível adquirir bastante conhecimento criando uma API REST com Spring Boot.

---

# 🕹️ Controllers

## Authorization Server

- Este endpoint é responsável pela autenticação de usuários e geração de tokens de acesso para a API.

```http
POST /oauth2/token
```

- **Content-Type:** `application/x-www-form-urlencoded`  
- **Authorization Type:** `Basic Auth`  
  - `Username`: `myclientid`  
  - `Password`: `myclientsecret`

---

## Body

Deve ser enviado no formato `x-www-form-urlencoded`:

| Key         | Value        | Description                       |
| ----------- | ------------ | --------------------------------- |
| `username`  | alex@gmail   | Credencial de acesso do usuário   |
| `password`  | 123456       | Senha do usuário                  |
| `grant_type`| password     | Tipo de grant, deve ser "password" |

**Response**:
```json
{
    "access_token": "eyJraWQiOiIwOTlkMDY5OC1lMWVlLTRlMWUtO...",
    "token_type": "Bearer",
    "expires_in": 86400
}
```

---

## Categories

- Este endpoint é responsável por recuperar as categorias.

```http
GET /categories
```

**Response**:
```json
[
    { "id": 1, "name": "Livros" },
    { "id": 2, "name": "Eletrônicos" },
    { "id": 3, "name": "Computadores" }
]
```

---

## Order

### GET /orders/{id}
- Este endpoint é responsável por recuperar um pedido por id.  
- **Authorization:** `Bearer <access_token>` (Admin only)

```http
GET /orders/1
```

**Response**:
```json
{
    "id": 1,
    "moment": "2022-07-25T13:00:00Z",
    "status": "PAID",
    "client": { "id": 1, "name": "Maria Brown" },
    "payment": { "id": 1, "moment": "2022-07-25T15:00:00Z" },
    "items": [
        { "productId": 1, "name": "The Lord of the Rings", "price": 90.5, "quantity": 2, "imgUrl": "https://.../1-big.jpg", "subTotal": 181.0 },
        { "productId": 3, "name": "Macbook Pro", "price": 1250.0, "quantity": 1, "imgUrl": "https://.../3-big.jpg", "subTotal": 1250.0 }
    ],
    "total": 1431.0
}
```

### POST /orders
- Este endpoint é responsável por gerar um novo pedido associado ao usuário logado.  
- **Authorization:** `Bearer <access_token>` (Admin only)

```http
POST /orders
```

**Response**:
```json
{
    "id": 4,
    "moment": "2025-04-28T18:38:45.126462Z",
    "status": "WAITING_PAYMENT",
    "client": { "id": 2, "name": "Alex Green" },
    "payment": null,
    "items": [
        { "productId": 1, "name": "The Lord of the Rings", "price": 90.5, "quantity": 2, "imgUrl": "https://.../1-big.jpg", "subTotal": 181.0 },
        { "productId": 5, "name": "Rails for Dummies", "price": 100.99, "quantity": 1, "imgUrl": "https://.../5-big.jpg", "subTotal": 100.99 }
    ],
    "total": 281.99
}
```

---

## Product

### GET /products/{id}
- Recupera um produto por id.

```http
GET /products/10
```

**Response**:
```json
{
    "id": 10,
    "name": "PC Gamer Y",
    "description": "Lorem ipsum...",
    "price": 1700.0,
    "imgUrl": "https://.../10-big.jpg",
    "categories": [{ "id": 3, "name": "Computadores" }]
}
```

### GET /products
- Recupera produtos de forma paginada, permitindo filtros, ordenações e controle de quantidade por página.

```http
GET /products
```

| Parameter | Type    | Example   | Description                                      |
|:----------|:--------|:----------|:-------------------------------------------------|
| `size`    | `int`   | 12        | Quantidade de produtos exibidos por página.      |
| `page`    | `int`   | 1         | Número da página a ser exibida (começando em 0). |
| `sort`    | `string`| name,desc | Campo para ordenação e direção (`asc` ou `desc`).|
| `name`    | `string`| Pc Gamer  | Filtrar produtos pelo nome.                     |

### POST /products
- Cria um novo produto.  
- **Authorization:** `Bearer <access_token>` (Admin only)

```http
POST /products
```

**Body**:
```json
{
    "name": "Livro do Natal",
    "description": "Lorem ipsum...",
    "imgUrl": "https://.../1-big.jpg",
    "price": 25.99,
    "categories": [{ "id": 2 },{ "id": 3 }]
}
```

### PUT /products/{id}
- Atualiza um produto existente.  
- **Authorization:** `Bearer <access_token>` (Admin only)

```http
PUT /products/2
```

**Body**:
```json
{
    "name": "Produto Atualizado",
    "description": "Lorem ipsum...",
    "imgUrl": "https://.../1-big.jpg",
    "price": 200.0,
    "categories": [{ "id": 2 },{ "id": 3 }]
}
```

### DELETE /products/{id}
- Remove um produto por id.  
- **Authorization:** `Bearer <access_token>` (Admin only)

```http
DELETE /products/23
```

---

## User

### GET /users/me
- Retorna as informações do usuário atualmente autenticado.

```http
GET /users/me
```

**Response**:
```json
{
    "id": 2,
    "name": "Alex Green",
    "email": "alex@gmail.com",
    "phone": "977777777",
    "birthDate": "1987-12-13",
    "roles": [
        "ROLE_CLIENT",
        "ROLE_ADMIN"
    ]
}
```

---

# ⚒️ Tecnologias

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- H2 Database
- Lombok
- JWT / OAuth2

---

# 👦 Autor

- [LinkedIn](https://www.linkedin.com/in/leandrocavalcantidev/)
- Email: leandrocavalcanti499@gmail.com

