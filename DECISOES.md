# Decisões Técnicas e Arquiteturais

Este documento detalha as escolhas feitas durante o desenvolvimento da API de Agendamento Clínico.

---

### 1. Arquitetura e Organização
Optei pela **Arquitetura em Camadas** (Controller, Service, Repository, Entity).
- **Por que?** Essa separação garante que a lógica de negócio (Service) não fique misturada com a entrada de dados (Controller), facilitando a manutenção e a criação de testes unitários.

### 2. Persistência de Dados
Utilizei o banco de dados **H2** (em memória).
- **Por que?** Para um teste técnico, o H2 permite que o avaliador execute o projeto imediatamente sem precisar instalar ou configurar um banco de dados local (como MySQL ou PostgreSQL). Os dados são resetados a cada execução, garantindo um ambiente limpo para testes.

### 3. Regras de Negócio Implementadas
Foquei em garantir a integridade dos agendamentos:
- **Conflito de Horário:** O sistema valida se um profissional já possui uma consulta no mesmo horário antes de confirmar um novo agendamento.
- **Validação de Data:** Implementei uma trava para impedir que consultas sejam marcadas em datas ou horários passados.
- **Status de Cancelamento:** Em vez de excluir o registro, o sistema altera o status para `CANCELADO` e exige um motivo, mantendo o histórico da clínica.

- ### 4. Padronização de Retornos
A API utiliza os códigos de status HTTP corretamente:
- `201 Created` para cadastros.
- `400 Bad Request` para erros de validação de negócio.
- `404 Not Found` quando um paciente ou agendamento não existe.

- ### 5. Ferramentas de IA
Utilizei IA para auxiliar na estruturação da documentação e modelagem inicial do banco. Toda a lógica de código e validação de regras foi revisada e adaptada manualmente para garantir que os requisitos do teste fossem atendidos.
