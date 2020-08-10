FROM openjdk:8-jre-alpine
ADD target/user-service-*.jar app.jar
EXPOSE 9091
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
