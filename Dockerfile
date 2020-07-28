FROM adoptopenjdk/openjdk11:alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} /app/calculation-service.jar
EXPOSE 8080 8081
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/calculation-service.jar"]