<div align="center">

# API de Agendamento Clínico

> Sistema de Gerenciamento e Controle de agendamentos de consultas.

</div>

---

##  Sobre o Teste

Essa API foi desenvolvida com a finalidade de solucionar a necessidade de organização de uma clínica médica. 
Seu foco principal é garantir a integridade dos dados e o cumprimento das regras de negócio, como a disponibilidade dos profissionais e a organização das consultas.

A aplicação funciona como "o cérebro" de um sistema de gestão, permitindo que recepcionistas e administradores realizem operações de cadastro e agendamento de forma segura, evitando erros comuns de conflitos de horários ou datas passadas.

---

##  Funcionalidades Principais

- [x] Cadastro e Listagem de Pacientes.
- [x] Criação de Agendamentos com validação de disponibilidade do profissional.
- [x] Listagem de Agendamentos com filtros (Paciente, Profissional, Status).
- [x] Cancelamento de consultas com registro de motivo.

---

## Tecnologias e Ferramentas
- **Java 17** (Linguagem principal)
- **Spring Boot 3** (Framework para a API)
- **Spring Data JPA** (Persistência de dados)
- **H2 Database** (Banco de dados em memória)
- **Bean Validation** (Validações de campos)
- **Maven** (Gerenciador de dependências)

### Pré-requisitos
- Java 17 ou superior instalado.

### Instalação
```bash
# Clone o repositório
git clone [https://github.com/barbpsouza/teste-tecnico-clinica-api.git]

# Entre na pasta do projeto
# Execute o comando:
No Linux/Mac: ./mvnw spring-boot:run
No Windows: mvnw.cmd spring-boot:run
```

## Testes
O projeto conta com testes automatizados focados nas regras de negócio críticas.
- **Caso de teste principal:** Impedir o agendamento de consultas em datas retroativas.

Para rodar os testes:
`./mvnw test`

## Modelo de Dados
Abaixo, a estrutura do banco de dados relacional desenhada para este projeto:

![Diagrama do Banco](<img width="829" height="518" alt="diagrama png" src="https://github.com/user-attachments/assets/45a0df71-4699-434c-a59b-0bc4742b56e3" />
)

---
Desenvolvido por **Bárbara Paranhos** - [Meu LinkedIn](https://www.linkedin.com/in/barbpsouza/)
# Thank U!
