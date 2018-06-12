FROM openjdk:8-jre-alpine
COPY target/*.jar app/spring-hateoas-example-1.0-SNAPSHOT.jar
#default command
CMD ["java","-jar","app/spring-hateoas-example-1.0-SNAPSHOT.jar"]