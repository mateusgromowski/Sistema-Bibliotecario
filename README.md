# Sistema Bibliotecário

Sistema de gerenciamento de biblioteca desenvolvido em Java utilizando arquitetura em camadas, JDBC e PostgreSQL.

## Sobre o Projeto

Este projeto foi desenvolvido com o objetivo de aplicar conceitos fundamentais de Engenharia de Software e desenvolvimento back-end em Java.

O sistema permite o gerenciamento de:

* Livros
* Usuários
* Empréstimos

Além disso, foram aplicados conceitos como separação de responsabilidades, tratamento de exceções, DTOs, persistência de dados e regras de negócio.

---

## Arquitetura

O projeto segue uma arquitetura em camadas:

```text
UI
 ↓
Controller
 ↓
Service
 ↓
Repository
 ↓
PostgreSQL
```

### Responsabilidades

#### UI

Responsável pela interação com o usuário através do terminal.

#### Controller

Recebe as solicitações da interface e encaminha para a camada de serviço.

#### Service

Contém as regras de negócio da aplicação.

#### Repository

Responsável pelo acesso ao banco de dados utilizando JDBC.

#### Model

Representa as entidades do sistema.

#### DTO

Objetos utilizados para transferência de dados entre camadas.

---

## Tecnologias Utilizadas

* Java
* Maven
* PostgreSQL
* JDBC
* Lombok

---

## Estrutura do Projeto

```text
src
│
├── controller
├── dto
├── exception
├── model
├── repository
├── service
├── ui
└── factory
```

---

## Funcionalidades

### Livros

* Cadastrar livro
* Listar livros
* Buscar livro
* Atualizar livro
* Remover livro

### Usuários

* Cadastrar usuário
* Listar usuários
* Buscar usuário
* Atualizar usuário
* Remover usuário

### Empréstimos

* Registrar empréstimo
* Listar empréstimos
* Consultar empréstimos detalhados
* Impedir empréstimos simultâneos do mesmo livro

---

## Banco de Dados

O sistema utiliza PostgreSQL para persistência dos dados.

Antes de executar a aplicação, configure a conexão com o banco de dados na classe:

```java
ConnectionFactory
```

---

## Execução do Projeto

### Clone o repositório

```bash
git clone <url-do-repositorio>
```

### Entre na pasta

```bash
cd sistema-bibliotecario
```

### Compile o projeto

```bash
mvn clean install
```

### Execute

```bash
mvn exec:java
```

ou execute a classe:

```java
Main.java
```

---

## Conceitos Aplicados

* Programação Orientada a Objetos
* Arquitetura em Camadas
* Injeção de Dependências Manual
* JDBC
* DTO Pattern
* Repository Pattern
* Service Layer Pattern
* Tratamento de Exceções
* Optional
* Maven

---

## Objetivo Acadêmico

Este projeto foi desenvolvido como prática de estudos em Java e Engenharia de Software, com foco na construção de aplicações organizadas, escaláveis e alinhadas com boas práticas de desenvolvimento.
