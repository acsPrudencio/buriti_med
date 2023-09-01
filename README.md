# 🏥 Buriti med

Neste projeto, trabalhamos em parceria com a fictícia empresa "Buriti Med", uma rede de clínicas médicas amplamente distribuída 
pelo território brasileiro. Nosso objetivo foi desenvolver um sistema completo e integrado para a gestão eficiente do cadastro de médicos, 
pacientes e o agendamento de consultas.

Com a necessidade de gerenciar suas operações de maneira mais eficaz, a Buriti Med nos escolheu como parceiros para criar 
uma solução sob medida. Este sistema proporciona uma interface intuitiva para administrar todas as atividades cruciais 
para uma clínica médica moderna e em expansão.

## 💎 Principais Recursos:

* **Cadastro de Médicos e Pacientes**: O sistema permite o cadastro detalhado de médicos, incluindo suas especializações e 
informações de contato. Além disso, os dados dos pacientes são armazenados de forma segura, garantindo um histórico completo e acessível.

* **Agendamento de Consultas**: Com uma interface de agendamento simplificada, pacientes podem marcar consultas com médicos 
disponíveis de acordo com suas necessidades e preferências. Isso otimiza o fluxo de trabalho e melhora a experiência do paciente.

Ao desenvolver esse sistema sob medida para a Buriti Med, estamos contribuindo para a modernização de suas operações
clínicas e para a melhoria na qualidade do atendimento aos pacientes em suas diversas clínicas pelo Brasil. Este projeto é 
um exemplo do nosso compromisso em fornecer soluções tecnológicas eficientes e adaptadas às necessidades específicas de nossos clientes.


API conta com recursos avançados como validações de entrada utilizando o Bean Validation, paginação de dados, 
padronização de retornos dos controllers, uso correto de códigos HTTP e implementação de segurança com o módulo Spring Security, 
incluindo autenticação por meio de Json Web Tokens (JWT) e controle de acesso.



## 🎯 Funcionalidades
1. **Operações CRUD**: A API oferece endpoints para criar, ler, atualizar e deletar recursos no banco de dados.  


2. **Banco de Dados:** Utiliza o banco de dados PostgreSQL para armazenar os dados da aplicação.


3. **Validações com Bean Validation:** Realiza validações nas entradas da API usando o Bean Validation, garantindo a integridade dos dados.


4. **Paginação de Dados:** Implementa paginação nos endpoints que retornam listas de recursos, melhorando a performance e a experiência do usuário.


5. **Padronização de Retornos:** Todos os retornos dos controllers seguem um padrão consistente, facilitando o entendimento por parte dos consumidores da API.


6. C**ódigos HTTP Corretos:** Utilização apropriada dos códigos de status HTTP para indicar o resultado de cada requisição.


7. **Spring Security:** Integração do módulo Spring Security para melhorar a segurança da API.


8. **Autenticação com JWT:** Implementação de autenticação na API utilizando Json Web Tokens (JWT), garantindo a autenticidade das requisições.


9. **Controle de Acesso:** Realização de controle de acesso com base nas permissões dos usuários, restringindo o acesso a certos endpoints.


## ⚙️ Configuração 
1. Clone este repositório para sua máquina local.
2. Configure as informações de conexão com o banco de dados no arquivo application.properties.
3. Inicie a aplicação Spring Boot.

## 🔒 Autenticação
A autenticação na API é realizada por meio de Json Web Tokens (JWT). Para acessar endpoints protegidos, inclua o token 
JWT no cabeçalho da requisição.

## 🔐 Controle de Acesso
O controle de acesso é baseado nas permissões dos usuários. Certifique-se de configurar corretamente as permissões ao cadastrar novos usuários.

📋 Requisitos

* Java 17
* Maven
* PostgreSQL

🛠️ Tecnologias  
* Spring Boot
* Spring Data
* Spring Security
* Bean Validation
* Json Web Token
* PostgreSQL
* JPA/Hibernate
* Maven
* Postman