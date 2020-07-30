# Read Me
### build
```
mvn package

docker run  -p 24224:24224 -p 24224:24224/udp -v $(pwd)/fluentd:/fluentd/etc -e FLUENTD_CONF=fluentd.conf fluent/fluentd:v1.6-debian-1

docker run -p 8080:8080 -p 8081:8081 -p 8082:8082 --log-driver fluentd --log-opt fluentd-address=localhost:24224 --log-opt tag=docker -t spring-app-microservice:0.0.1-SNAPSHOT
```
### swagger
http://127.0.0.1:8080/calculation-service/api/v1/swagger-ui.html

### calculate logarithm
http://127.0.0.1:8080/calculation-service/api/v1/calculation/logarithm?base=2&number=8

### error request
http://127.0.0.1:8080/calculation-service/api/v1/calculation/logarithm

### readiness
http://127.0.0.1:8081/actuator/readiness

### metrics (calculationMbean)
http://127.0.0.1:8082/metrics