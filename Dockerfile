FROM openjdk:21
EXPOSE 8080
ADD target/netology-springboot-rest-authservice-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]
