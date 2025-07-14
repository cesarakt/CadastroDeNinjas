# CADASTRODENINJAS
Capacitando a Inovação Através de um Gerenciamento Contínuo de Ninjas

![last-commit](https://img.shields.io/github/last-commit/cesarakt/CadastroDeNinjas?style=flat&logo=git&logoColor=white&color=0080ff) ![repo-top-language](https://img.shields.io/github/languages/top/cesarakt/CadastroDeNinjas?style=flat&color=0080ff) ![repo-language-count](https://img.shields.io/github/languages/count/cesarakt/CadastroDeNinjas?style=flat&color=0080ff)

Construído com as ferramentas e tecnologias:

![Spring](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&style=flat&logo=openjdk&logoColor=white)![Spring](https://img.shields.io/badge/Spring-000000.svg?style=flat&logo=Spring&logoColor=white) ![XML](https://img.shields.io/badge/XML-005FAD.svg?style=flat&logo=XML&logoColor=white)

---

## Sumário
* [Visão Geral](#visão-geral)
* [Começando](#começando)
    * [Pré-requisitos](#pré-requisitos)
    * [Instalação](#instalação)
* [Uso](#uso)
* [Testes](#testes)

---

## Visão Geral
**CadastroDeNinjas** é um sistema abrangente baseado em Spring Boot para gerenciar registros e missões de ninjas, combinando APIs RESTful, migrações de banco de dados e uma interface web. Ele fornece uma base sólida para a construção de aplicações full-stack de gerenciamento com arquitetura limpa e manipulação de dados contínua.

### Por que CadastroDeNinjas?
Este projeto simplifica o desenvolvimento de sistemas de gerenciamento de ninjas, integrando recursos essenciais como:
* 🧩 **Endpoints de API**: Serviços RESTful para operações CRUD em ninjas e missões, permitindo fácil integração e automação.
* 🎨 **Interface Web**: Páginas amigáveis para listar, visualizar, adicionar e excluir registros de ninjas, melhorando a experiência do usuário.
* 🚀 **Migrações de Banco de Dados**: Atualizações de esquema com controle de versão usando Flyway, garantindo a evolução suave do seu modelo de dados.
* 📜 **Documentação OpenAPI**: Documentação de API integrada para referência rápida e testes.
* 🔄 **Transformação de Dados**: DTOs e mappers para uma clara separação de preocupações e consistência de dados.
* 🧪 **Estabilidade da Aplicação**: Testes fundamentais para validar os componentes e dependências principais.

---

## Começando

### Pré-requisitos
Este projeto requer as seguintes dependências:
* **Linguagem de Programação**: Java
* **Gerenciador de Pacotes**: Maven

### Instalação
Construa o CadastroDeNinjas a partir do código-fonte e instale as dependências:

1.  Clone o repositório:
    ```bash
    ❯ git clone [https://github.com/cesarakt/CadastroDeNinjas](https://github.com/cesarakt/CadastroDeNinjas)
    ```
2.  Navegue até o diretório do projeto:
    ```bash
    ❯ cd CadastroDeNinjas
    ```
3.  Instale as dependências:
    Usando `maven`:
    ```bash
    ❯ mvn install
    ```

---

## Uso
Execute o projeto com:
Usando `maven`:
```bash
mvn exec:java
```

## Testes
O CadastroDeNinjas usa o framework de teste {test_framework}. Execute o conjunto de testes com:
Usando maven:
```bash
mvn install
```
