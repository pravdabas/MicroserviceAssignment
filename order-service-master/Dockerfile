FROM openjdk:8-jre-alpine
ADD target/order-service-*.jar app.jar
EXPOSE 19090
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
