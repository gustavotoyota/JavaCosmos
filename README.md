# JavaCosmos - Comprehensive Java Demonstrations

JavaCosmos is a comprehensive structured collection of code demonstrations for technologies essential to Java development. It may be helpful to beginners by providing clear and practical examples, while advanced users may benefit from quick overviews or experimentation with various technologies.

## Setting up JavaCosmos

In order to run JavaCosmos, first you must start the services using docker-compose:

```
docker-compose up -d
```

(The `-d` above is used to detach the services from the command line, making them run in the background.)

Then you just have to run the application, either through your IDE or by using the following command:

```
./mvnw spring-boot:run
```

## Features currently covered by JavaCosmos

- Spring Boot
- Spring Web
  - Spring MVC
  - Spring WebFlux
  - GraphQL
- Spring Security
  - Basic HTTP authentication
  - Form-based authentication
  - JWT authentication
- Spring AOP
- Database technologies
  - Hibernate
    - PostgreSQL
  - MongoDB
- Messaging technologies
  - Kafka
  - RabbitMQ
- Template engines
  - Thymeleaf
  - JSP
- Testing libraries
  - JUnit
  - Mockito
- Swagger
- Lombok
- File uploads and downloads

## License

MIT
