# Read Me
### build
```
mvn package
docker run -p 8080:8080 -p 8081:8081 -t spring-app-microservice:0.0.1-SNAPSHOT
```
### swagger
http://127.0.0.1:8080/calculation-service/api/v1/swagger-ui.html

### calculate logarithm
http://127.0.0.1:8080/calculation-service/api/v1/calculation/logarithm?base=2&number=8

### error request
http://127.0.0.1:8080/calculation-service/api/v1/calculation/logarithm

### readiness
http://127.0.0.1:8081/actuator/readiness
