# Decisões Técnicas e Arquiteturais

Este documento detalha as escolhas feitas durante o desenvolvimento da API de Agendamento Clínico.

---

### 1. Arquitetura e Organização
Optei pela **Arquitetura em Camadas** (Controller, Service, Repository, Entity).
- **Por que?** Essa separação garante que a lógica de negócio (Service) não fique misturada com a entrada de dados (Controller), facilitando a manutenção e a criação de testes unitários. O Controller cuida do HTTP, o Service guarda as regras de negócio (validações) e o Repository cuida do banco.

- **Diferencial (Front-end):** Decidi incluir uma interface web funcional (static/index.html) para facilitar a homologação e demonstrar a integração completa do ecossistema.

### 2. Persistência de Dados
Utilizei o banco de dados **H2** (em memória).
- **Por que?** Para um teste técnico, o H2 permite que o avaliador execute o projeto imediatamente sem precisar instalar ou configurar um banco de dados local (como MySQL ou PostgreSQL). Os dados são resetados a cada execução, garantindo um ambiente limpo para testes.

### 3. Regras de Negócio Implementadas
Foquei em garantir a integridade dos agendamentos:
- **Conflito de Horário:** O sistema valida se um profissional já possui uma consulta no mesmo horário antes de confirmar um novo agendamento.
- **Validação de Data:** Implementei uma trava para impedir que consultas sejam marcadas em datas ou horários passados.
- **Status de Cancelamento:** Em vez de excluir o registro, o sistema altera o status para `CANCELADO` e exige um motivo, mantendo o histórico da clínica.


### 4. O que Priorizei
- **Regras de Negócio Blindadas:** Minha prioridade foi garantir que o sistema não permitisse agendamentos inválidos (datas passadas ou médicos ocupados)
- **Documentação de Endpoints:** Garanti que o Swagger estivesse configurado para que a API fosse autoexplicativa.
- **Organização e Boas Práticas** Garantindo um sistema limpo e de fácil entendimento.

### 5. O que ficou de fora?
- **Autenticação** O sistema não possui login/senha.
- **Persistência em Disco:** Como usei H2 em memória, os dados são resetados ao desligar o servidor. Para produção, trocaria pelo PostgreSQL ou Oracle.

### 6. Padronização de Retornos
A API utiliza os códigos de status HTTP corretamente:
- `201 Created` para cadastros.
- `400 Bad Request` para erros de validação de negócio.
- `404 Not Found` quando um paciente ou agendamento não existe.

### 7. Experiência do Usuário (UX)
- **Documentação com Swagger:** Implementei o Swagger UI para que qualquer desenvolvedor possa testar os endpoints de forma independente e entender o contrato da API rapidamente.
- **Desing:** Interface amigável e moderna.
  
### 8. Ferramentas de IA
Utilizei IA para auxiliar na estruturação da documentação e modelagem inicial do banco. Toda a lógica de código e validação de regras foi revisada e adaptada manualmente para garantir que os requisitos do teste fossem atendidos. A IA auxiliou na depuração de erros críticos (como o conflito de fuso horário entre JS e Java) acelerando a resolução de bugs de infraestrutura.
