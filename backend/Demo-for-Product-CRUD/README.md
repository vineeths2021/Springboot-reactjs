# Demo-RESTful Service for-Product-CRUD

The project is based on a small RESTful service which uses the following technologies
- Java 1.8
- Spring Boot 2.5
- Database H2 (In-Memory)
- Maven
- The Struture of the web service is built with the following components:
  - DataTransferObjects: Objects which are used for outside communication via the API.
  - RestController: Implements the processing logic of the REST service, parsing of parameters and validation of in- and outputs.
  - Mapper: MapStruct is used for mapping the DTO to Entity vice-versa.
  - Service: Implements the business logic and handles the access to the Data Persitence.
  - Persistence: Interface for the database. Inserts, updates, deletes and reads objects from the database
  
 ## How to start the app
 You should be able to start the example application by executing com.example.product, 
 which starts a webserver on port 8080 (http://localhost:8080) and serves SwaggerUI where can inspect and try existing endpoints
 
 ## Useful Urls
  -  Swagger URL : http://localhost:8080/swagger-ui.html
  -  Actuator URL :http://localhost:8080/actuator/health
  -  H2 DB URL : http://localhost:8080/h2-console
