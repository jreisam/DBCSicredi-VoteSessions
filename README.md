# DBC-Sicredi-VoteSessions: Teste João Robson Jr
Projeto teste para DBC / Sicredi: Implementação de uma solução que disponibiliza sessões de votação de pautas, para associados, com delimitação de tempo, persistência e controle destas sessões.
        
1 - Certifique-se de primeiro ter instalado e configurado as tecnologias:
    Java, Maven, Maven-Wrapper.

2 - Rodar Dev: "`mvn -N io.takari:maven:0.7.7:wrapper` e então `mvnw clean spring-boot:run`. 

3 - Rodar build: "`mvn package`" e então "`java -jar .\DBCjreis\target\DBCjreis-0.0.1-SNAPSHOT.jar`.

4 - Visualizar Endpoints: `http://localhost:8888/swagger-ui.html#/`

5 - caso haja erro ao buildar, tente `yarn add webpack --dev` para atualizar o packager.

Tecnologias usadas:
* PostgreSQL
* SpringBoot / JPA / Swagger
 
